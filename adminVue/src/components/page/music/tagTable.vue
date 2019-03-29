<template>
    <div class="table">
         
        <div class="container">
            <div class="handle-box">
                <el-button type="primary" icon="add" class="handle-del mr10" @click="handleAdd">添加</el-button>
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="标签名">
                </el-table-column>
                <el-table-column prop="isTip" label="搜索提示" width="120">
                </el-table-column>
                <el-table-column prop="isCash" label="缓存状态"  width="120">
                </el-table-column>
                <el-table-column prop="searchTimes" label="搜索次数"  width="120">
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
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="50px">
                
                <el-form-item label="标签名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="搜索提示">
                    <el-input v-model="form.isTip"></el-input>
                </el-form-item>
                <el-form-item label="缓存状态">
                    <el-input v-model="form.isCash"></el-input>
                </el-form-item>
                 
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
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
     import {
        updateLabel,
        getLabel,
        getLabels,
        deleteLabel,
    } from "@/api/api"; 
    export default {
        name: 'TagTable',
        data() {
            return {
                tableData: [],
                cur_page: 1,
                multipleSelection: [],
                select_cate: '',
                select_word: '',
                del_list: [],
                is_search: false,
                editVisible: false,
                delVisible: false,
                form: {
                    id:'',
                    name: '',
                    isTip: '',
                    isCash: ''
                },
                id:0,
                idx: -1,
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
                this.$axios.get(getLabels,{
                      params:{
                        currePage:this.cur_page,
                        pageSize:10,
                      }
                }).then((res) => {
                    // console.log(res.data)
                    this.tableData = res.data;
                });
            },
            handleEdit(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.form = {
                    id: item.id,
                    name: item.name,
                    isTip: item.isTip,
                    isCash: item.isCash
                }
                this.editVisible = true;
            },
            handleDelete(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                console.log("delete item : ",item);
                this.id = item.id;
                this.delVisible = true;
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
                this.editVisible = false;
                 this.$axios.post(
                    updateLabel,
                    JSON.stringify(this.form),
                    {headers: {'Content-Type': 'application/json'}})
                 .then((res) => {
                    // console.log(res.data)
                    this.$set(this.tableData, this.idx, this.form);
                    this.$message.success(`编辑成功`);
                }).catch(err=>{
                    this.$message.error(`编辑失败`);
                });
                
            },
            // 确定删除
            deleteRow(){
                this.$axios.delete(deleteLabel+this.id)
                .then((res) => {
                    // console.log(res.data)
                    this.tableData.splice(this.idx, 1);
                    this.$message.success('删除成功');
                    this.delVisible = false;
                }).catch(err=>{
                    this.$message.error('删除失败');
                });   
            },
             handleAdd(){
                this.form = {};
                this.idx = this.tableData.length;
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
