<template>
    <div style="display:flex">
        <el-tree style="width:250px" :data="treeData" :props="defaultProps"  @node-click="handleNodeClick"></el-tree>
        <div class="table">
            
            <div class="container">
                <div class="handle-box">
                    <el-button type="primary" icon="add" class="handle-del mr10"  @click="handleAdd()" >栏目添加</el-button>
                </div>
                <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange">
                    <el-table-column type="selection" width="55" align="center"></el-table-column>
                    <el-table-column prop="id" label="ID" sortable width="150">
                    </el-table-column>
                    <el-table-column prop="value" label="栏目名称" width="120">
                    </el-table-column>
                    <el-table-column prop="modelLocation" label="栏目路径" :formatter="formatter">
                    </el-table-column>
                    <el-table-column prop="type" label="类型" :formatter="formatter">
                    </el-table-column>
                    <el-table-column prop="isShow" label="显示" :formatter="formatter">
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
            <el-dialog title="编辑" :visible.sync="editVisible" width="40%">
                <el-form ref="form" :model="form" label-width="100px">
                    <el-form-item label="上级栏目">
                        <el-input v-model="form.parentId" :disabled="true"></el-input>
                    </el-form-item>
                    <el-form-item label="栏目名称">
                        <el-input v-model="form.value"></el-input>
                    </el-form-item>
                    <el-form-item label="栏目地址">
                        <el-input v-model="form.modelLocation"></el-input>
                    </el-form-item>
                    <el-form-item label="是否展示">
                        <el-input v-model="form.isShow"></el-input>
                    </el-form-item>
                    <el-form-item label="每页记录数">
                        <el-input v-model="form.count"></el-input>
                    </el-form-item>
                     <el-form-item label="站点">
                        <el-input v-model="form.stationId"></el-input>
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
    </div>
</template>

<script>
    import {
        getPros,
        getTree
    } from "@/api/api";
    export default {
        name: 'PragramaTable',
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
                parentId: '',
                form: {
                    id:'',
                    value:'',
                    modelLocation: '',
                    order:'',
                    isShow: '',
                    parentId: '',
                    model:'',
                    count:'',
                    type:'',
                    stationId:'',
                    isParent:''
                },
                idx: -1,
                treeData: [],
                defaultProps: {
                children: 'children',
                label: 'value'
                }
            }
        },
        created() {
            this.getData();
            this.parentId = 0;
         },
     
        methods: {
            // 分页导航
            handleCurrentChange(val) {
                this.cur_page = val;
                this.getData();
            },
            // 获取 easy-mock 的模拟数据
            getData() {
                // 开发环境使用 easy-mock 数据，正式环境使用 json 文件
                if (process.env.NODE_ENV === 'development') {
                    this.url = '/ms/table/list';
                };
                this.$axios.get(getPros,{
                      params:{
                            id:0
                        }
                }).then((res) => {
                    console.log(res.data);
                    this.tableData = res.data;
                });
                this.$axios.get(getTree).then((res)=>{
                    console.log(res.data);
                    this.treeData = res.data
                })

            },
            search() {
                this.is_search = true;
            },
            formatter(row, column) {
                return row.address;
            },
             handleNodeClick(data) {
                 this.parentId = data.id;
                this.$axios.get('http://localhost:8081/getPros',{
                        params:{
                            id:data.id
                        }
                    }).then((res) => {
                    console.log(res.data)
                    this.tableData = res.data;
                    this.parentId = data.id;
                });
                
            },
            handleAdd(){
                this.form = {
                    parentId: this.parentId,
                }
                this.editVisible = true;
            },
            filterTag(value, row) {
                return row.tag === value;
            },
            handleEdit(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.form = {
                    id:item.id,
                    value: item.value,
                    modelLocation: item.modelLocation,
                    order: item.order,
                    isShow: item.isShow,
                    parentId: item.parentId,
                    model: item.model,
                    stationId: item.stationId,
                    count: item.count,
                    type: item.type,
                    isParent: item.isParent,
                }
                this.editVisible = true;
            },
            handleDelete(index, row) {
                this.idx = index;
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
                
                this.$axios.post('http://localhost:8081/updatePro',
                       JSON.stringify(this.form),{headers: {'Content-Type': 'application/json'}}).then((res) => {
                    console.log(res.data)
                    this.tableData = res.data;
                });
                this.editVisible = false;
              
            },
            // 确定删除
            deleteRow(){
                this.tableData.splice(this.idx, 1);
                this.$message.success('删除成功');
                this.delVisible = false;
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
