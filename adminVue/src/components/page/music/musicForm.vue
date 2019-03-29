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
                    <el-form-item label="标签">
                        <el-select 
                            v-model="form.labels" 
                            filterable 
                            multiple
                            value-key="id"
                            placeholder="请选择标签" 
                        >
                            <el-option
                                v-for="item in tagData"
                                :key="item.id"
                                :value="item"
                                :label="item.name"
                            ></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="流行数">
                        <el-input v-model="form.popularity"></el-input>
                    </el-form-item>
                    <el-form-item label="歌手">
                        <el-select 
                            v-model="form.singers" 
                            filterable 
                            multiple 
                            value-key="id"
                            placeholder="请选择歌手"
                        >
                            <el-option
                                v-for="item in singerData"
                                :key="item.id"
                                :value="item"
                                :label="item.name"
                            ></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="歌词">
                        <el-input v-model="form.lyric"></el-input>
                    </el-form-item>
                    <el-form-item label="审核">
                        <el-input v-model="form.commit"></el-input>
                    </el-form-item>
                  
                    <el-form-item label="上传歌曲">
                        <el-upload
                            ref="upload"
                            :action="upload"
                            name="picture"
                            list-type="picture-card"
                            :limit="1"
                            :file-list="fileList"
                            :on-success="handleSuccess"
                            :on-remove="handleRemove"
                        >
                            <i class="el-icon-plus"></i>
                        </el-upload>
                    </el-form-item>
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
        data(){
            return {
                options:[],
                form: {},//表单数据
                singerData:[],//歌手列表
                tagData:[],//标签列表
                label:"value",
                value:"id",
                upload:upload,
                fileList:[],
                dialogVisible:false,
                dialogImageUrl:"",
            }
        },
        methods: {
            onSubmit() {
                // console.log(this.form);
                this.$emit("onFormSubmit",this.form);
            },
            handleCurrentChange(){

            },
            handleSuccess(){

            },
            handleRemove(){

            },
        },
        watch:{
            initialData:{
                handler(newValue,olaValue){
                    this.form = newValue[0] || {};
                    this.singerData = newValue[1] || [];
                    this.tagData = newValue[2] || [];
                    this.form.labels = this.form.labels || [];
                },
                immediate:true,
            }
        }
    }
</script>