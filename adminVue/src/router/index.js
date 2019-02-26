import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/',
            component: resolve => require(['../components/common/Home.vue'], resolve),
            meta: { title: '自述文件' },
            children:[
                {
                    path: '/dashboard',
                    component: resolve => require(['../components/page/Dashboard.vue'], resolve),
                    meta: { title: '系统首页' }
                },
                {
                    path: '/icon',
                    component: resolve => require(['../components/page/Icon.vue'], resolve),
                    meta: { title: '自定义图标' }
                },
                {
                    path: '/contentTable',
                    component: resolve => require(['../components/page/content/contentTable.vue'], resolve),
                    meta: { title: '内容列表' }
                },
                {
                    path: '/previewTable',
                    component: resolve => require(['../components/page/preview/previewTable.vue'], resolve),
                    meta: { title: '预览列表' }
                },
                {
                    path: '/columnTable',
                    component: resolve => require(['../components/page/column/columnTable.vue'], resolve),
                    meta: { title: '栏目列表' }
                },
                 
                {
                    path: '/musicTable',
                    component: resolve => require(['../components/page/music/musicTable.vue'], resolve),
                    meta: { title: '音乐列表' }
                },
                {
                    path: '/tabTable',
                    component: resolve => require(['../components/page/music/tabTable.vue'], resolve),
                    meta: { title: '标签列表' }
                },
                {
                    path: '/commentTable',
                    component: resolve => require(['../components/page/user/commentTable.vue'], resolve),
                    meta: { title: '评论列表' }
                },
                {
                    path: '/userTable',
                    component: resolve => require(['../components/page/user/userTable.vue'], resolve),
                    meta: { title: '用户列表' }
                },
                {
                    path: '/roleTable',
                    component: resolve => require(['../components/page/user/roleTable.vue'], resolve),
                    meta: { title: '角色列表' }
                },
                {
                    path: '/vipTable',
                    component: resolve => require(['../components/page/user/vipTable.vue'], resolve),
                    meta: { title: 'vip列表' }
                },
                {
                    path: '/tabs',
                    component: resolve => require(['../components/page/Tabs.vue'], resolve),
                    meta: { title: 'tab选项卡' }
                },
                {
                    path: '/form',
                    component: resolve => require(['../components/page/BaseForm.vue'], resolve),
                    meta: { title: '基本表单' }
                },
                {
                    // 富文本编辑器组件
                    path: '/editor',
                    component: resolve => require(['../components/page/VueEditor.vue'], resolve),
                    meta: { title: '富文本编辑器' }
                },
                {
                    // markdown组件
                    path: '/markdown',
                    component: resolve => require(['../components/page/Markdown.vue'], resolve),
                    meta: { title: 'markdown编辑器' }    
                },
                {
                    // 图片上传组件
                    path: '/upload',
                    component: resolve => require(['../components/page/Upload.vue'], resolve),
                    meta: { title: '文件上传' }   
                },
                {
                    // vue-schart组件
                    path: '/charts',
                    component: resolve => require(['../components/page/BaseCharts.vue'], resolve),
                    meta: { title: 'schart图表' }
                },
                {
                    // 拖拽列表组件
                    path: '/drag',
                    component: resolve => require(['../components/page/DragList.vue'], resolve),
                    meta: { title: '拖拽列表' }
                },
                {
                    // 拖拽Dialog组件
                    path: '/dialog',
                    component: resolve => require(['../components/page/DragDialog.vue'], resolve),
                    meta: { title: '拖拽弹框' }
                },
                {
                    // 权限页面
                    path: '/permission',
                    component: resolve => require(['../components/page/Permission.vue'], resolve),
                    meta: { title: '权限测试', permission: true }
                },
                {
                    path: '/404',
                    component: resolve => require(['../components/page/404.vue'], resolve),
                    meta: { title: '404' }
                },
                {
                    path: '/403',
                    component: resolve => require(['../components/page/403.vue'], resolve),
                    meta: { title: '403' }
                },
                {
                    path:'/content/add',
                    component: resolve => require(['../components/page/content/ContentForm.vue'],resolve),
                    meta: {title:'内容编辑'}
                },
            ]
        },
      
        {
            path: '/login',
            component: resolve => require(['../components/page/Login.vue'], resolve)
        },
        {
            path: '*',
            redirect: '/404'
        },
       
    ]
})
