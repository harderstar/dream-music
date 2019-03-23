<template>
    <div style="display:flex">
        <el-tree 
            style="width:250px" 
            :data="treeData" 
            :props="defaultProps"
            
            @node-click="handleNodeClick"></el-tree>
        <div class="table">
            
            <div class="container">
                <div class="handle-box">
                    <el-button type="primary" icon="add" class="handle-del mr10"  @click="handleAdd()" >内容添加</el-button>

                </div>
                <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange">
                    <el-table-column type="selection" width="55" align="center"></el-table-column>
                     
                    <el-table-column prop="title" label="标题">
                    </el-table-column>
                    <el-table-column prop="stickLevel" label="置顶" width="100">
                    </el-table-column>
                    <el-table-column prop="clickNum" label="浏览量"  width="100">
                    </el-table-column>
                    <el-table-column prop="uptime" label="上传时间"  width="100">
                    </el-table-column>
                    <el-table-column prop="issuer" label="发布者"  width="100">
                    </el-table-column>
                    
                    <el-table-column prop="commit" label="状态" width="120" >
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
                :before-close="handleClose">
                <content-form v-if="editVisible" :proId="proId" :contId="contId" @changeValue="changeValue">
                </content-form>
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
    import contentForm from "@/components/page/content/contentForm.vue";
    export default {
        name: 'basetable',
        components:{
            contentForm
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
                parentId: '',
                proId:0,
                contId:0,
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
            this.parentId = 0;
            this.getData();
           // this.parentId = 0;
         },
     
        methods: {
            // 分页导航
            handleCurrentChange(val) {
                this.cur_page = val;
                this.getData();
            },
            changeValue(data){
                
            },
            // 获取 easy-mock 的模拟数据
            getData() {
                // 开发环境使用 easy-mock 数据，正式环境使用 json 文件
                if (process.env.NODE_ENV === 'development') {
                    this.url = '/ms/table/list';
                };
                this.$axios.get('http://localhost:8081/manager/getcomments',{
                      params:{
                        id : this.parentId,
                        pageSize : 10,
                        curPage : 1,
                      },
                }).then((res) => {
                    console.log(res.data)
                    this.tableData = res.data;
                });
                this.$axios.get('http://localhost:8081/manager/getTree').then((res)=>{

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
                this.$axios.get('http://localhost:8081/manager/getcomments',{
                        params:{
                           id : this.parentId,
                           pageSize : 10,
                           curPage : 1,
                         },
                }).then((res) => {
                    console.log(res.data)
                    this.tableData = res.data;
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
                this.$axios.post('http://localhost:8081/manager/deletePro',{
                        params:{
                            id:data.id
                        }
                    }).then((res) => {
                    console.log(res.data)
                    
                });
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
                
                this.$axios.post('http://localhost:8081/manager/updateCom',
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
    .card-list {
        background-color: #f6f8fb;
        padding: 0px 16px 16px 16px;
    }
    .card{
        cursor: pointer;
        padding-top: 16px;

    }
    .el-card__body {
        padding: 10px!important;
    }
</style>
