<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar
          :username = "username"
        />
      </el-header>

      <el-main>
        <HomeworkList
          :uid="uid" :token="token" role="teacher" @selectFunc="elmClick"
        />
      </el-main>

    </el-container>

  </div>
</template>

<script>

import RouterBar from '@/components/RouterBar.vue'
import HomeworkList from '@/components/HomeworkList.vue'
import API from '@/util/API.js';

export default {
  name: 'Teacher',
  components: {
    RouterBar, HomeworkList
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
      
    },
    elmClick: function(id){
      console.log("CL" + id);
    },
    elmDel: function(id){
      console.log("DEl" + id);
    }
  },
  
}
</script>
