<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar/>
      </el-header>

      <el-main>
        <div class="home">
          <img alt="Vue logo" src="../assets/logo.png">
          <HelloWorld msg="Welcome to Your Vue.js App"/>
        </div>
      </el-main>

    </el-container>

  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import RouterBar from '@/components/RouterBar.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld, RouterBar
  }
}
</script>
