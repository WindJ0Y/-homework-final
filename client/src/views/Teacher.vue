<template>
  <div>
    
    <el-container>

      <el-header>
        <RouterBar
          :username = "username" role="teacher" @doAdd="doAdd"
        />
      </el-header>

      <el-main>
        <HomeworkList
          :uid="uid" :token="token" role="teacher" @selectFunc="elmClick"
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
import InfoCover from '@/components/teacher/InfoCover.vue'
import API from '@/util/API.js';

export default {
  name: 'Teacher',
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
    doAdd: function(){
      this.$prompt('', '请输入作业标题', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        let content = value;
        this.$prompt('', '请输入作业内容', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          this.submitAdd(content,value);
        }).catch(() => {});
      }).catch(() => {});
    },
    submitAdd: function(title,content){
      let pform = {
        uid: this.uid,
        token: this.token,
        title: title,
        content: content,
      };
      
      API.teacherHomeworkAdd(pform).then(res => {
        if (res.state === 0) {
          this.$message.success("添加成功");
          setTimeout(function(){location.reload()},1000);
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
  },
  
}
</script>
