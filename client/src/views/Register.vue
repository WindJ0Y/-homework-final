<template>
  <div>
    <div class="backPic"></div>
    
    <el-container>

      <el-main>
          <RegisterBox/>
      </el-main>

    </el-container>

  </div>
</template>

<script>

import RegisterBox from '@/components/register/RegisterBox.vue'

export default {
  name: 'Register',
  components: { RegisterBox },
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