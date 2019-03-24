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
                        <el-cascader :options="options" :label="label" :value="value"  v-model="musicData.name"></el-cascader>
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
                     <el-form-item label="标签">
                        <el-input v-model="musicData.labels"></el-input>
                    </el-form-item>
                     <el-form-item label="流行数">
                        <el-input v-model="musicData.popularity"></el-input>
                    </el-form-item>
                    <el-form-item label="歌词">
                        <el-input v-model="musicData.lyric"></el-input>
                    </el-form-item>
                    <el-form-item label="审核">
                        <el-input v-model="musicData.lyric"></el-input>
                    </el-form-item>
                    <el-form-item label="类型">
                        <el-select v-model="form.region" placeholder="请选择">
                            <el-option key="bbk" label="步步高" value="bbk"></el-option>
                            <el-option key="xtc" label="小天才" value="xtc"></el-option>
                            <el-option key="imoo" label="imoo" value="imoo"></el-option>
                        </el-select>
                    </el-form-item>
                     <el-upload
                            ref="upload"
                            action="http://localhost:8081/manager/upload"
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
    export default {
        props:["musicId"],
        name: 'baseform',
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
            }
        },
        methods: {
            onSubmit() {
                this.$message.success('提交成功！');
            }
        },
        created(){
              this.$axios.get('http://localhost:8081/manager/music/'+this.musicId).then((res)=>{
                this.options = res.data
                console.log(this.options)
             })
           
              
        }
    }
</script>