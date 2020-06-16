<template>
  <el-card class="hower">
    <div>
      <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
        <h3 class="login-title">欢迎登录</h3>
        <el-form-item label="账号" prop="username">
          <el-input type="text" placeholder="请输入账号" v-model="form.username"/>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
        </el-form-item>
        
        <el-button type="primary" v-on:click=";">登录</el-button>
        <el-button v-on:click=";">注册</el-button>
        
      </el-form>
    </div>
  </el-card>
</template>

<script>

export default {
  name: 'LoginBox',
  components: {},
  data() {
    return {
      form: {
        username: '',
        password: ''
      },

      rules: {
        username: [
          {required: true, message: '账号不可为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不可为空', trigger: 'blur'}
        ]
      },
    }
  },
  methods: {}
}
</script>

<style scoped>
  .hower {
    display: inline-block;
    width: 500px;
  }
</style>