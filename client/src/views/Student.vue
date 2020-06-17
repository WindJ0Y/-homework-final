<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar
          :username = "username"
        />
      </el-header>

      <el-main>
        {{"Student"}}
      </el-main>

    </el-container>

  </div>
</template>

<script>

import RouterBar from '@/components/RouterBar.vue'
import API from '@/util/API.js';

export default {
  name: 'Student',
  components: {
    RouterBar
  },
  data() {
    return {
      uid: this.$cookie.get("uid"),
      token: this.$cookie.get("token"),
      username: "",
    }
  },
  created: function() {
    this.getInfo();
  },
  methods: {
    getInfo: function(){
      let pform = {
        uid: this.uid,
        token: this.token,
      };
      
      API.userInfo(pform).then(res => {
        if (res.state === 0) {
          this.username = res.username;
        } else {
            this.$message.error(res.msg);
            console.log(res);
        }
      }).catch(msg => {
          alert(msg);
      });
      
    }
  }
}
</script>
