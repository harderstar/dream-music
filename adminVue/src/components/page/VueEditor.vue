<template>
    <div class="editContainer">
        <quill-editor ref="myTextEditor" :value="value" @change="onEditorChange"></quill-editor>
    </div>
</template>

<script>
    import 'quill/dist/quill.core.css';
    import 'quill/dist/quill.snow.css';
    import 'quill/dist/quill.bubble.css';
    import { quillEditor } from 'vue-quill-editor';
    export default {
        name: 'Editor',
        props:["value"],
        components: {
            quillEditor
        },
        methods: {
            onEditorChange({ editor, html, text }) {
                this.$emit("input",html);
            },
        },
    }
</script>
<style scoped>
    .editor-btn{
        margin-top: 20px;
    }
</style>