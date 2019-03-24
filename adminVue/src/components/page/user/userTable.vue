<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-lx-cascades"></i> 基础表格</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                 <el-button type="primary" icon="add" class="handle-del mr10" @click="handleAdd()">添加</el-button>
                
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="名称"   >
                </el-table-column>
                <el-table-column label="会员等级" width="150" >
                    <div slot-scope="scope">
                        <span v-for="(item,index) in powers" :key="index">
                            {{item}} 
                        </span>
                    </div>
                </el-table-column>
                <el-table-column prop="downloadSize" label="下载数" width="150" >
                </el-table-column>
                <el-table-column prop="phonenumber" label="手机号码" width="150" >
                </el-table-column>
                <el-table-column prop="last_login_time" label="最后上线时间" width="150" >
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
                
                <el-form-item label="名称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="会员等级">
                    <el-input v-model="form.power"></el-input>
                </el-form-item>
                <el-form-item label="下载数">
                    <el-input v-model="form.downloadSize"></el-input>
                </el-form-item>
                <el-form-item label="手机号码">
                    <el-input v-model="form.phonenumber"></el-input>
                </el-form-item>
                <el-form-item label="最后上线时间">
                    <el-input v-model="form.last_login_time"></el-input>
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
      getUsers,
    } from "@/api/api";
    export default {
        name: 'basetable',
        data() {
            return { 
                param:{
                    
                },
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
                form: {
                    id:'',
                    name: '',
                    downloadSize: '',
                    phonenumber: '',
                    last_login_time: '',
                    power:'',
                },
                idx: -1
            }
        },
        created() {
            this.getData();
        },
        computed: {
             
        },
        methods: {
            // 分页导航
            handleCurrentChange(val) {
                this.cur_page = val;
                this.getData();
            },
            // 获取 easy-mock 的模拟数据
           getData() {
                
                this.$axios.get(getUsers,{
                     params:{
                          curPage:1,
                        pageSize:10
                     }
                }).then((res) => {
                  
                    this.tableData = res.data;
                    console.log( this.tableData)
                });
               

            },
            saveEdit(){
                this.$axios.post(updateUser,
                    JSON.stringify(this.form),{
                        headers: {'Content-Type': 'application/json'}}).then((res) => {
                    console.log(this.res.data)
                })
                this.$set(this.tableData, this.idx, this.form);
                this.editVisible = false;
                //this.$message.success(`修改第 ${this.idx+1} 行成功`);
            },
            handleAdd(){
                 this.form = {
                    
                }
                this.editVisible = true;
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
            handleEdit(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.form = {
                    id:item.id,
                    name:item.name,
                    downloadSize:item.downloadSize ,
                    fee:item.fee,
                    isBase:item.isBase,
                    isComtent:item.isComtent,
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
           
            // 确定删除
            deleteRow(){
                this.tableData.splice(this.idx, 1);
                this.$message.success('删除成功');
                this.delVisible = false;
            }
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
