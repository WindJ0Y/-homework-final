<template>
  <div id="nav">
    <el-menu default-active="1" class="el-menu-demo" mode="horizontal">
      <el-menu-item >
        <i class="el-icon-edit"></i>
        <a class="LF">作业管理平台V0.1</a>
      </el-menu-item>
      <el-menu-item index="1" class="LF">作业中心</el-menu-item>
      <el-submenu index="2" style="float: right">
        <template slot="title" >
          <i class="el-icon-user"></i>
          <a class="LF">{{username}}</a>
        </template>
        <el-menu-item  @click="doExit()">退出</el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'RouterBar',
  props: ['username'],
  data(){
    return {
      //username: "666",
    }
  },
  methods: {
    doExit: function(){
      this.$confirm('确认登出？')
        .then( _ => {
          this.$router.push({path:'/logout'});
        })
        .catch( _ => {});
    }
  }
}
</script>

<style scoped>

</style>
