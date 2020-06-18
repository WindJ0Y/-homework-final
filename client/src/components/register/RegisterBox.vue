<template>
  <el-card class="hower">
    <div>
      <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
        <h3 class="login-title">注册</h3>
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
        
        <el-button type="primary" v-on:click="onReg()">注册</el-button>
        
      </el-form>
    </div>
  </el-card>
</template>

<script>
import API from '@/util/API.js';

export default {
  name: 'RegisterBox',
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
    onReg: function(){
      let pform = {
        username: this.form.username,
        password: this.form.password,
        role: (this.job=="student" ? 0 : 1),
      };
      
      API.userReg(pform).then(res => {
        if(res.state == 0){
          this.$alert('注册成功', '恭喜', {
            confirmButtonText: '确定',
            callback: action => {
              this.$router.push({path:'/login'});
            }
          });
        }else{
          alert(res.msg);
        }
      }).catch(msg => {
        alert(msg);
      });
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