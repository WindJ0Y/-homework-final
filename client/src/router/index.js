import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Student from '../views/Student.vue'
import Teacher from '../views/Teacher.vue'
import SubmitList from '../views/SubmitList.vue'

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
    component: Login
  },
  {
    path: '/register',
    component: Register
  },
  {
    path: '/student',
    component: Student
  },
  {
    path: '/teacher',
    component: Teacher
  },

  {
    path: '/teacher/submits',
    component: SubmitList
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
