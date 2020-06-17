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

import LoginBox from '@/components/login/LoginBox.vue'

export default {
  name: 'Login',
  components: { LoginBox },
  data() {
    return {
      
    }
  },
  methods: {
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