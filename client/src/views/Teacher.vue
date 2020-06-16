<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar/>
      </el-header>

      <el-main>
        {{"Teacher"}}
      </el-main>

    </el-container>

  </div>
</template>

<script>

import RouterBar from '@/components/RouterBar.vue'

export default {
  name: 'Teacher',
  components: {
    RouterBar
  }
}
</script>
