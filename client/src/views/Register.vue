<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar/>
      </el-header>

      <el-main>
        {{"Register"}}
      </el-main>

    </el-container>

  </div>
</template>

<script>

import RouterBar from '@/components/RouterBar.vue'

export default {
  name: 'Register',
  components: {
    RouterBar
  }
}
</script>
