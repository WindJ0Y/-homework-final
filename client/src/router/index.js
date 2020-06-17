import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Student from '../views/Student.vue'
import Teacher from '../views/Teacher.vue'
import SubmitList from '../views/SubmitList.vue'
import Logout from '../views/Logout.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    component: Login
  },
  {
    path: '/ss',
    component: Home
  },
  {
    path: '/about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    component: Login,
    meta:{title:'登录页'},
  },
  {
    path: '/logout',
    component: Logout,
    meta:{title:'登出中...'},
  },
  {
    path: '/register',
    component: Register,
    meta:{title:'注册页'},
  },
  {
    path: '/student',
    component: Student,
    meta:{title:'学生页'},
  },
  {
    path: '/teacher',
    component: Teacher,
    meta:{title:'教师页'},
  },

  {
    path: '/teacher/submits',
    component: SubmitList,
    meta:{title:'作业提交列表'},
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
