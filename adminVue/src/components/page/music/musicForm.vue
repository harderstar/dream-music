<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-lx-calendar"></i> 表单</el-breadcrumb-item>
                <el-breadcrumb-item>内容表单</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="200px">
                     <el-form-item label="歌名">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="专辑">
                        <el-input v-model="form.album"></el-input>
                    </el-form-item>
                    <el-form-item label="播放路径">
                        <el-input v-model="form.auditionUrl"></el-input>
                    </el-form-item>
                    <el-form-item label="like">
                        <el-input v-model="form.like"></el-input>
                    </el-form-item>
                    <el-form-item label="下载">
                        <el-input v-model="form.download"></el-input>
                    </el-form-item>
                     <el-popover
                        placement="right"
                        width="400"
                        trigger="click">
                        <el-table :data="tagData">
                             <el-table-column type="selection" width="55" align="center"></el-table-column>
                            <el-table-column prop="name" label="标签名">
                            </el-table-column>
                            <el-table-column prop="isTip" label="搜索提示" width="120">
                            </el-table-column>  
                        </el-table>
                        <div class="pagination">
                            <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :total="1000">
                            </el-pagination>
                        </div>
                        <el-button slot="reference">标签</el-button>
                    </el-popover>
                     <el-form-item label="流行数">
                        <el-input v-model="form.popularity"></el-input>
                    </el-form-item>
                     <el-popover
                        placement="right"
                        width="400"
                        trigger="click">
                        <el-table :data="singerData">
                            <el-table-column type="selection" width="55" align="center"></el-table-column>
                            <el-table-column prop="name" label="歌手名">
                            </el-table-column>
                            <el-table-column prop="birthday" label="生日" width="150">
                            </el-table-column>
                            <el-table-column prop="sex" label="性别" width="150">
                            </el-table-column>
                            <el-table-column prop="hotLevel" label="热度"  width="150">
                            </el-table-column>
                            <el-table-column prop="introduction" label="简介"  width="150">
                            </el-table-column>
                        </el-table>
                        <div class="pagination">
                            <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :total="1000">
                            </el-pagination>
                        </div>
                        <el-button slot="reference">歌手</el-button>
                    </el-popover>

                    <el-form-item label="歌词">
                        <el-input v-model="form.lyric"></el-input>
                    </el-form-item>
                    <el-form-item label="审核">
                        <el-input v-model="form.commit"></el-input>
                    </el-form-item>
                  
                     <el-upload
                            ref="upload"
                            :action="upload"
                            name="picture"
                            list-type="picture-card"
                            :limit="1"
                            :file-list="fileList"
                            :on-success="handleSuccess"
                            :on-remove="handleRemove">
                        <i class="el-icon-plus"></i>
                    </el-upload>
                    <el-dialog :visible.sync="dialogVisible">
                        <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                    <vue-editor> </vue-editor>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">表单提交</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>

    </div>
</template>

<script>
     import {
        music,
        upload,
        getSingers,
        getLabels,
    } from "@/api/api";
    import VueEditor from "@/components/page/VueEditor.vue";
    export default {
        props:["initialData"],
        name: 'Musicform',
        components:{
            VueEditor
        },
        data: function(){
            return {
                options:[],
                form: {
                    title: '',
                    titleColor: '',
                    subtitle: '',
                    digest: '',
                    stickLevel: '',
                    issuer: '',
                    commit: '',
                    uptime: '',
                    externalLink: '',
                    digest: '',
                    commentImage: '',
                    detail:'',
                    music:'',
                    options: [],
                },
                label:"value",
                value:"id",
                singerData:{},
                tagData:{},
                upload:upload,
                fileList:[],
            }
        },
        computed: {
            form(){

            },
            
        },
        methods: {
            onSubmit() {
                console.log(this.form);
                this.$emit("onFormSubmit","aaaaaaa");
                this.$message.success('提交成功！');
            },
            handleCurrentChange(){

            }
        },
        created(){
             
              
        }
    }
</script>