<template>
  <div style="height: 100%">
    
    <el-container style="height: 100%">

      <el-header>
        <RouterBar
          :username = "username"
        />
      </el-header>

      <el-main>

        <HomeworkList
          :uid="uid" :token="token" role="student" @selectFunc="elmClick"
        />
        
      </el-main>

    </el-container>

    <InfoCover
      :dialogVisible.sync = "divShow" @onClose="elmClose"
      :uid="uid" :token="token" :hid="viewHid"
    />

  </div>
</template>

<script>

import RouterBar from '@/components/RouterBar.vue'
import HomeworkList from '@/components/HomeworkList.vue'
import InfoCover from '@/components/student/InfoCover.vue'
import API from '@/util/API.js';

export default {
  name: 'Student',
  components: {
    RouterBar, HomeworkList, InfoCover
  },
  data() {
    return {
      uid: this.$cookie.get("uid"),
      token: this.$cookie.get("token"),
      username: "",

      viewHid: -1,
      divShow: false,
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
    elmClick: function(hid){
      console.log(this.divShow);
      this.viewHid = hid;
      this.divShow = true;
    },
    elmClose: function(){
      //this.viewHid = -1;
      this.divShow = false;
    }
  }
}
</script>
