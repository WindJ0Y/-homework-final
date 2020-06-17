<template>
  <div>

    <el-scrollbar style="height:100%;">
        
      <el-card class="box-card myListElm" v-for="elm in infoList" :key="elm.id">
        <div slot="header" class="clearfix myCardHeader">

          <span style="float: left">{{elm.name}}</span>

          <div v-if="role == 'student'">
            <el-tag type="warning" class = "myCardHeaderRight" v-if="!elm.bbed">
              <i class="el-icon-remove-outline"></i>
              未批阅
            </el-tag>
            <el-tag type="success" class = "myCardHeaderRight" v-if="elm.bbed">
              <i class="el-icon-circle-check"></i>
              已批阅
            </el-tag>
            <el-tag type="warning" class = "myCardHeaderRight" v-if="!elm.submited">
              <i class="el-icon-remove-outline"></i>
              未提交
            </el-tag>
            <el-tag type="success" class = "myCardHeaderRight" v-if="elm.submited">
              <i class="el-icon-circle-check"></i>
              已提交
            </el-tag>
          </div>


          <div v-if="role == 'teacher'">
            <el-tag class = "myCardHeaderRight">
              <i class="el-icon-circle-check"></i>
              批阅({{elm.readcnt}}/{{elm.total}}})
            </el-tag>
            <el-tag class = "myCardHeaderRight">
              <i class="el-icon-circle-check"></i>
              提交({{elm.submitcnt}}/{{elm.total}}})
            </el-tag>
          </div>

        </div>

        <div class="text item myCardBody" @click="elmClick(elm.id)">
          {{elm.content}}
        </div>
      </el-card>

    </el-scrollbar>

  </div>
</template>

<script>
import API from '@/util/API.js';

export default {
  name: 'HomeworkList',
  props: ['uid','token','role'],
  data(){
    return {
      infoList: [],
      /*
      infoList: [
        {
          id: 1,
          name: "作业1",
          submited: true,
          bbed: true,
          content: "作业1的内容",
        },
        {
          id: 2,
          name: "作业2",
          submited: true,
          bbed: false,
          content: "作业2的内容",
        },
        {
          id: 3,
          name: "作业3",
          submited: false,
          bbed: false,
          content: "aaaaaaaaa",
        },
      ]
      */
      /*
      infoList: [
        {
          id: 1,
          name: "作业1",
          submitcnt: 5,
          readcnt: 7,
          total: 10,
          content: "作业1的内容",
        },
        {
          id: 2,
          name: "作业2",
          submitcnt: 5,
          readcnt: 7,
          total: 10,
          content: "作业2的内容",
        },
        {
          id: 3,
          name: "作业3",
          submitcnt: 5,
          readcnt: 7,
          total: 10,
          content: "aaaaaaaaa",
        },
      ]
      */
    }
  },
  created: function() {
    this.reload();
  },
  methods: {
    elmClick: function(id){
      this.$emit('selectFunc',id);
    },
    reload: function(){
      if(this.role == "student"){
        this.loadStudent();
      }else if(this.role == "teacher"){

      }else{
        console.log("ERR");
      }
    },
    loadStudent: function(){
      let pform = {
        uid: this.uid,
        token: this.token,
      };
      
      API.studentHomeworkList(pform).then(res => {
        if(res.state == 0){
          this.infoList = res.list.reverse();
        }else{
          alert(res.msg);
        }
      }).catch(msg => {
        alert(msg);
      });
    },
  }
}
</script>

<style scoped>
  .myListElm{
    max-width: 1000px; 
    margin: 10px auto;
  }
  .myCardHeader{
    height: 18px;
  }
  .myCardBody{
    height: 80px;
    text-align: left;
  }
  .myCardHeaderRight{
    float: right; 
    margin: -5px 5px;
  }
</style>
