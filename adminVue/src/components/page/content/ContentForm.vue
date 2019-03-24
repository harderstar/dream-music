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
                    <el-form-item label="选择栏目">
                        <el-cascader :options="options" :label="label" :value="value"  v-model="form.programe"></el-cascader>
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
                            <el-option key="bbk" label="步步高" value="bbk"></el-option>
                            <el-option key="xtc" label="小天才" value="xtc"></el-option>
                            <el-option key="imoo" label="imoo" value="imoo"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="上传时间">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.uptime" style="width: 100%;"></el-date-picker>
                        </el-col>
                        <el-col class="line" :span="2">-</el-col>    
                    </el-form-item>
                    <el-form-item label="置顶等级">
                        <el-input v-model="form.stickLevel"></el-input>
                    </el-form-item>
                    <el-form-item label="发布者">
                        <el-input v-model="form.issuer"></el-input>
                    </el-form-item>
                     <el-upload
                            ref="upload"
                            action=upload
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
                        <el-button slot="reference">歌曲</el-button>
                    </el-popover>

                    
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
        getContent,
        upload,
    } from "@/api/api";
    export default {
        props:["contId","proId"],
        name: 'ContentForm',
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
                musicData:[],
            }
        },
        methods: {
            onSubmit() {
                this.$message.success('提交成功！');
            }
        },
        created(){
              this.$axios.get(getContent+this.contId).then((res)=>{
                this.options = res.data
                console.log(this.options)
             })
           
              
        }
    }
</script>