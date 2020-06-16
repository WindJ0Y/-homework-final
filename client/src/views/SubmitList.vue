<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar/>
      </el-header>

      <el-main>
        {{"SubmitList"}}
      </el-main>

    </el-container>

  </div>
</template>

<script>

import RouterBar from '@/components/RouterBar.vue'

export default {
  name: 'SubmitList',
  components: {
    RouterBar
  }
}
</script>
