<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar/>
      </el-header>

      <el-main>
        {{"Student"}}
      </el-main>

    </el-container>

  </div>
</template>

<script>

import RouterBar from '@/components/RouterBar.vue'

export default {
  name: 'Student',
  components: {
    RouterBar
  }
}
</script>
