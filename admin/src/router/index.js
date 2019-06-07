import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Main from '@/unrule/Main'
import Dashboard from '@/unrule/Dashboard'
import Member from '@/unrule/Member'
import Owner from "@/unrule/Owner";
import LoginUser from "@/unrule/LoginUser";
import LoginSupermanager from "../unrule/LoginSupermanager";
import LoginManager from "../unrule/LoginManager";
import UnruleRequest from "../unrule/UnruleRequest";
import License from "../unrule/License";
import Me from "@/pages/Member"
import LastDone from "../unrule/LastDone";

let routes = [{
  path: '/',
  component: Main,
  hidden: true,
  children: [{
    path: '/',
    component: Dashboard,
    name: '首页',
  }]
}]

routes.push({
  path: '/',
  name: '车辆违章管理',
  component: Main,
  iconCls: 'fa fa-user-circle-o',
  children: [
    {
    path: '/member/data',
    component: Member,
    name: '违章信息管理',
    },
    {
      path: '/owner/data',
      component: Owner,
      name: '车主信息管理',
    },
   ]
})

routes.push({
  path: '/',
  name: '登陆信息管理',
  component: Main,
  iconCls: 'fa fa-user-circle-o',
  children: [
    {
      path: '/managerlogin/data',
      component: LoginManager,
      name: '管理员登陆信息管理',
    },
    {
      path: '/userlogin/data',
      component: LoginUser,
      name: '车主登陆信息管理',
    },
    {
      path: '/supermanagerlogin/data',
      component: LoginSupermanager,
      name: '超级管理员登陆信息管理',
    },
  ]
})

routes.push({
  path: '/',
  name: '违章处理信息管理',
  component: Main,
  iconCls: 'fa fa-user-circle-o',
  children: [
    {
      path: '/unrulerequest/data',
      component: UnruleRequest,
      name: '网上申请违章处理信息管理',
    },
    {
      path: '/',
      component: UnruleRequest,
      name: '网上违章处理结果',
    },
  ]
})

routes.push({
  path: '/',
  name: '车主驾照信息管理',
  component: Main,
  iconCls: 'fa fa-user-circle-o',
  children: [
    {
      path: '/licensemanage/data',
      component: License,
      name: '驾照信息管理',
    },
    {
      path: '/licensemanage/lastdone',
      component: LastDone,
      name: '驾照信息管理',
    },
  ]
})

const router = new Router({
  routes: routes
})

export default router
/*
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Main from '@/unrule/Main'
import Dashboard from '@/unrule/Dashboard'
import Member from '@/unrule/Member'

let routes = [{
  path: '/',
  component: Main,
  hidden: true,
  children: [{
    path: '/',
    component: Dashboard,
    name: '首页',
  }]
}]

routes.push({
  path: '/member',
  name: '车辆违章管理',
  component: Main,
  iconCls: 'fa fa-user-circle-o',
  children: [
    {
    path: '/member/data',
    component: Member,
    name: '违章信息管理',
    },
    {
      path: '/member/data',
      component: Member,
      name: '违章信息管理',
    },
    {
      path: '/member/data',
      component: Member,
      name: '违章信息管理',
    },
   ]
})

const router = new Router({
  routes: routes
})

export default router
*/
