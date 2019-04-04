<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-lx-calendar"></i> 表单</el-breadcrumb-item>
                <el-breadcrumb-item>内容表单</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box" style="width:80%;">
                <el-form ref="form" :model="form" label-width="200px" size="medium">
                    <el-form-item label="栏目">
                        <el-input :value="form.programaName" disabled ></el-input>
                    </el-form-item>
                    <el-form-item label="标题">
                        <el-input v-model="form.title"></el-input>
                    </el-form-item>
                    <el-form-item label="标题颜色">
                        <el-input v-model="form.titleColor"></el-input>
                    </el-form-item>
                    <el-form-item label="简短标题">
                        <el-input v-model="form.subtitle"></el-input>
                    </el-form-item>
                     <el-form-item label="关键字">
                        <el-input v-model="form.digest"></el-input>
                    </el-form-item>
                     <el-form-item label="外部链接">
                        <el-input v-model="form.externalLink"></el-input>
                    </el-form-item>
                    <el-form-item label="类型">
                        <el-select v-model="form.region" placeholder="请选择">
                            <el-option key="bbk" label="音乐" value="bbk"></el-option>
                            <el-option key="xtc" label="新闻" value="xtc"></el-option>
                         </el-select>
                    </el-form-item>
                    <el-form-item label="上传时间">
                        <el-date-picker :value="form.uptime" disabled ></el-date-picker> 
                    </el-form-item>
                    <el-form-item label="置顶等级">
                        <el-input v-model="form.stickLevel"></el-input>
                    </el-form-item>
                    <el-form-item label="发布者">
                        <el-input v-model="form.issuer"></el-input>
                    </el-form-item>
                    <el-form-item label="上传图片">
                        <el-upload
                            ref="upload"
                            :action="upload"
                            name="picture"
                            list-type="picture-card"
                            :limit="1"
                            :on-success="handleSuccess">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                    </el-form-item>
                    <el-form-item label="选择歌曲">
                        <el-select 
                            v-model="form.music" 
                            filterable
                            remote
                            :remote-method="remoteFetch"
                            :loading="loading"
                            placeholder="请输入歌手关键词"
                        >
                            <el-option
                                v-for="item in musicsList"
                                :key="item.id"
                                :value="item.value"
                                :label="item.name"
                            ></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="详细信息">
                        <vue-editor v-model="form.detail"></vue-editor>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="handleSubmit">表单提交</el-button>
                        <el-button type="primary" @click="handleCancel">取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>

    </div>
</template>

<script>
    import {
        upload,
    } from "@/api/api";
    import VueEditor from "@/components/page/VueEditor.vue";
    export default {
        props:["visible","initialData"],
        name: 'ContentForm',
        components:{
            VueEditor
        },
        data(){
            return {
                form:{
                    programeId:'',
                    programa:null,//栏目的id
                    programaName:"",//栏目的名字
                    title: '',//标题
                    titleColor: '',//标题颜色
                    subtitle: '',//子标题
                    digest: '',//关键字
                    stickLevel: '',//置顶等级
                    issuer: '',//发布者
                    uptime: '',//上传时间
                    externalLink: '',//外部连接
                    commentImage: '',//图片
                    detail:'',//富文本内容
                    music:'',//音乐
                },
                label:"value",
                value:"id",
                upload,
                musicsList:[]
            }
        },
        methods: {
            handleSubmit() {
                console.log(this.form)
                console.log('form: ',this.form);
                this.$emit("onFormSubmit",this.form);
            },
            handleCancel(){
                this.$emit("update:visible",false);
            },
            handleSuccess(response,file){
                //console.log("上传图片成功：",response);
                this.form.commentImage = response.message;
            },
            remoteFetch(query){
                if(query!==""){
                    this.loading = true;
                    
                }
            }
        },
        created:{
            
        },
        watch:{
            initialData:{
                handler(newValue,olaValue){
                    console.log(this.upload);
                    this.form = newValue || {};
                },
                immediate:true,
            },
            visible(newValue,oldValue){
                if(!newValue)
                    this.$refs.upload.clearFiles();
            }
        }
    }
</script>