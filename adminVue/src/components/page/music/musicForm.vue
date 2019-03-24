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
                <el-form ref="form" :model="music" label-width="200px">
                     <el-form-item label="歌名">
                        <el-input v-model="musicData.name"></el-input>
                    </el-form-item>
                    <el-form-item label="专辑">
                        <el-input v-model="musicData.album"></el-input>
                    </el-form-item>
                    <el-form-item label="播放路径">
                        <el-input v-model="musicData.auditionUrl"></el-input>
                    </el-form-item>
                    <el-form-item label="like">
                        <el-input v-model="musicData.like"></el-input>
                    </el-form-item>
                    <el-form-item label="下载">
                        <el-input v-model="musicData.download"></el-input>
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
                        <el-input v-model="musicData.popularity"></el-input>
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
                        <el-input v-model="musicData.lyric"></el-input>
                    </el-form-item>
                    <el-form-item label="审核">
                        <el-input v-model="musicData.commit"></el-input>
                    </el-form-item>
                  
                     <el-upload
                            ref="upload"
                            :action="upload"
                            name="picture"
                            list-type="picture-card"
                            :limit="1"
                            :file-list="fileList"
                            :on-exceed="onExceed"
                            :before-upload="beforeUpload"
                            :on-preview="handlePreview"
                            :on-success="handleSuccess"
                            :on-remove="handleRemove">
                        <i class="el-icon-plus"></i>
                    </el-upload>
                    <el-dialog :visible.sync="dialogVisible">
                        <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                    <el-popover
                        placement="right"
                        width="400"
                        trigger="click">
                        <el-table :data="musicData">
                            <el-table-column width="150" property="name" label="歌名"></el-table-column>
                            <el-table-column width="100" property="singer" label="歌手"></el-table-column>
                        </el-table>
                    </el-popover>
                    <vue-editor>
                    </vue-editor>
                    
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
        props:["musicId"],
        name: 'baseform',
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
                musicData:{},
                singerData:{},
                tagData:{},
                upload:upload
            }
        },
        methods: {
            onSubmit() {
                this.$message.success('提交成功！');
            }
        },
        created(){
             this.$axios.get(music+this.musicId).then((res)=>{
                this.options = res.data
                console.log(this.options)
             })
            this.$axios.get(getSingers,{
                params:{
                    pageSize:10,
                    currenPage:1,
                }
            }).then((res) => {
                console.log(res.data)
                this.singerData = res.data;
            });
            this.$axios.get(getLabels,{
                    params:{
                    currePage:1,
                    pageSize:10,
                    }
            }).then((res) => {
                console.log(res.data)
                this.tagData = res.data;
            });
              
        }
    }
</script>