<template>
  <div>
    <div class="backPic"></div>
    
    <el-container>

      <el-main>
          <LoginBox/>
      </el-main>

    </el-container>

  </div>
</template>

<script>

import LoginBox from '@/components/title/LoginBox.vue'

export default {
  name: 'Login',
  components: { LoginBox },
  data() {
    return {
      
    }
  },
  methods: {
    onSubmit(formName) {
      // 为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
          this.$router.push("/main");
        } else {
          this.dialogVisible = true;
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>

  .backPic {
    background-image: linear-gradient(to right , #7A88FF, #7AFFAF);
    height: 100%;
    position: fixed;
    width: 100%;
    top: 0;
    left: 0;
    z-index: -1
  }

</style>