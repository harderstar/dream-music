<template>
    <div class="table">
         
        <div class="container">
            <div class="handle-box">
                <el-button type="primary" icon="add" class="handle-del mr10" @click="handleAdd">添加</el-button>
                 
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="歌曲名"  >
                </el-table-column>
                <el-table-column prop="singers" label="歌手" width="120">
                </el-table-column>
                <el-table-column prop="uptime" label="上传时间" width="120">
                </el-table-column>
                <el-table-column prop="commit" label="审核状态"  width="120">
                </el-table-column>
                <el-table-column prop="popularity" label="热度"  width="120">
                </el-table-column>
                <el-table-column prop="recommend" label="推荐"  width="120">
                </el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button type="text" icon="el-icon-delete" class="red" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :total="1000">
                </el-pagination>
            </div>
        </div>

         <!-- 编辑弹出框 -->
        <el-dialog title="编辑" 
            :visible.sync="editVisible" 
            width="85%"
            id=""
            :close-on-click-modal="false"
        >
            <music-form :initialData="formInitialData" @onFormSubmit="handleFromSubmit"></music-form>
        </el-dialog>

        <!-- 删除提示框 -->
        <el-dialog title="提示" :visible.sync="delVisible" width="300px" center>
            <div class="del-dialog-cnt">删除不可恢复，是否确定删除？</div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="delVisible = false">取 消</el-button>
                <el-button type="primary" @click="deleteRow">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import musicForm from "@/components/page/music/musicForm.vue";
     import {
        musics,
        deleteMusic,
        updateMusic,
         music,
         getSingers,
         getLabels
     } from "@/api/api";
    export default {
        name: 'basetable',
        components:{
            musicForm
        },
        data() {
            return {
                url: './vuetable.json',
                tableData: [],
                cur_page: 1,
                multipleSelection: [],
                select_cate: '',
                select_word: '',
                del_list: [],
                is_search: false,
                editVisible: false,
                delVisible: false,
                formInitialData:[],
                id:0,
                idx: -1
            }
        },
        created() {
            this.getData();
        },
        computed: {
            data() {
                return this.tableData.filter((d) => {
                    let is_del = false;
                    for (let i = 0; i < this.del_list.length; i++) {
                        if (d.name === this.del_list[i].name) {
                            is_del = true;
                            break;
                        }
                    }
                    if (!is_del) {
                        if (d.address.indexOf(this.select_cate) > -1 &&
                            (d.name.indexOf(this.select_word) > -1 ||
                                d.address.indexOf(this.select_word) > -1)
                        ) {
                            return d;
                        }
                    }
                })
            }
        },
        methods: {
            // 分页导航
            handleCurrentChange(val) {
                this.cur_page = val;
                this.getData();
            },
            // 获取 easy-mock 的模拟数据
            getData() {
                this.$axios.get(musics,{
                      params:{
                          currePage:this.cur_page,
                          pageSize:10
                      }
                }).then((res) => {
                    console.log(res.data)
                    this.tableData = res.data;
                });
            },
            getFormInitialData(id){
                var p1 = this.$axios.get(music+id).then(res=>res.data);
                var p2 = this.$axios.get(getSingers,{
                    params:{
                        pageSize:10,
                        currenPage:1,
                    }
                }).then(res =>res.data);
                var p3= this.$axios.get(getLabels,{
                        params:{
                        currePage:1,
                        pageSize:10,
                        }
                }).then(res =>res.data);
                return Promise.all(p1,p2,p3);
            },
            search() {
                this.is_search = true;
            },
            formatter(row, column) {
                return row.address;
            },
            filterTag(value, row) {
                return row.tag === value;
            },
            handleFromSubmit(formData){
                console.log(formData);
                this.editVisible = false;
            },
            handleEdit(index, row) {
                const item = this.tableData[index];
                this.id = item.id
                this.idx = index;
                this.getFormInitialData(this.id).then((res)=>{
                    this.formInitialData = res;
                })
                this.editVisible = true;
            },
            handleDelete(index, row) {
                this.delVisible = true;
                const item = this.tableData[index];
                this.id = item.id
                this.idx = index;
            },
            delAll() {
                const length = this.multipleSelection.length;
                let str = '';
                this.del_list = this.del_list.concat(this.multipleSelection);
                for (let i = 0; i < length; i++) {
                    str += this.multipleSelection[i].name + ' ';
                }
                this.$message.error('删除了' + str);
                this.multipleSelection = [];
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            // 保存编辑
            saveEdit() {
                this.$set(this.tableData, this.idx, this.form);
                this.editVisible = false;
                 this.$axios.post(updateMusic,
                       JSON.stringify(this.form),{headers: {'Content-Type': 'application/json'}}).then((res) => {
                    console.log(res.data)
                    this.tableData = res.data;
                });
                this.$message.success(`修改第 ${this.idx+1} 行成功`);
            },
            // 确定删除
            deleteRow(){
                 this.$axios.delete(deleteMusic+this.idx,{
                         
                    }).then((res) => {
                    console.log(res.data)
                    
                }); 
                this.tableData.splice(this.idx, 1);
                this.$message.success('删除成功');
                this.delVisible = false;
            },
             handleAdd(){
                this.form = {
                    parentId: this.parentId,
                }
                this.editVisible = true;
            },
        }
    }

</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
    .del-dialog-cnt{
        font-size: 16px;
        text-align: center
    }
    .table{
        width: 100%;
        font-size: 14px;
    }
    .red{
        color: #ff0000;
    }
    .mr10{
        margin-right: 10px;
    }
</style>
