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
        <el-form-item label="身份" prop="job">
          <el-select placeholder="请选择身份" v-model="form.job" style="width: 380px">
            <el-option label="学生" value="student"></el-option>
            <el-option label="教师" value="teacher"></el-option>
          </el-select>
        </el-form-item>
        
        <el-button type="primary" v-on:click="onLogin()">登录</el-button>
        <el-button v-on:click="onReg()">注册</el-button>
        
      </el-form>
    </div>
  </el-card>
</template>

<script>
import API from '@/util/API.js';

export default {
  name: 'LoginBox',
  components: {},
  data() {
    return {
      form: {
        username: '',
        password: '',
        job:''
      },

      rules: {
        username: [
          {required: true, message: '账号不可为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不可为空', trigger: 'blur'}
        ],
        job: [
          {required: true, message: '身份不可为空', trigger: 'blur'}
        ]
      },
    }
  },
  methods: {
    onLogin: function(){
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          let pform = {
            username: this.form.username,
            password: this.form.password,
            role: (this.form.job == "student" ? 0 : 1),
          };
          console.log(pform);
          
          API.userLogin(pform).then(res1 => {
            if (res1.state === 0) {
                this.$cookie.set("uid", res1.uid);
                this.$cookie.set("token", res1.token);
                this.$cookie.set("role", pform.role);
            } else {
                alert("登录失败");
            }
          }).catch(msg => {
              alert(msg);
          });
          

        } else {
          console.log(false);
        }
      });
    },
    onReg: function(){
      this.$router.push({path:'/register'});
    }
  }
}

</script>

<style scoped>
  .hower {
    display: inline-block;
    width: 500px;
  }
</style>