<template>
  <el-dialog
    title="作业信息"
    :modal=false
    :visible.sync="dialogVisible"
    width="70%"
    :before-close="handleClose">
    
      {{info.name}}
      {{info.stutext}}
      {{info.tectext}}

    <div v-if="!info.submited && !info.bbed">
      <el-steps :active="0" finish-status="success" simple style="margin-top: 20px">
        <el-step title="填写回答"></el-step>
        <el-step title="等待批阅"></el-step>
        <el-step title="批阅完成"></el-step>
      </el-steps>
      <p>你还没有提交本次作业。</p>
      <el-form label-position="top" label-width="80px" class="TL LF">
        <el-form-item label="作业名称">
          <el-input v-model="info.name" disabled></el-input>
        </el-form-item>
        <el-form-item label="你的答案">
          <el-input v-model="info.stutext"></el-input>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="doSubmit()" >提交</el-button>
    </div>

    <div v-if="info.submited && !info.bbed">
      <el-steps :active="1" finish-status="success" simple style="margin-top: 20px">
        <el-step title="填写回答"></el-step>
        <el-step title="等待批阅"></el-step>
        <el-step title="批阅完成"></el-step>
      </el-steps>
      <p>你已经提交本次作业，但是老师还没哟评价，你可以在这之前修改内容。</p>
      <el-form label-position="top" label-width="80px" class="TL LF">
        <el-form-item label="作业名称">
          <el-input v-model="info.name" disabled></el-input>
        </el-form-item>
        <el-form-item label="你的答案">
          <el-input v-model="info.stutext"></el-input>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="doSubmit()" >修改</el-button>
    </div>

    <div v-if="info.submited && info.bbed">
      <el-steps :active="3" finish-status="success" simple style="margin-top: 20px">
        <el-step title="填写回答"></el-step>
        <el-step title="等待批阅"></el-step>
        <el-step title="批阅完成"></el-step>
      </el-steps>
      <p>本次作业已经评价完成。</p>
      <el-form label-position="top" label-width="80px" class="TL LF">
        <el-form-item label="作业名称">
          <el-input v-model="info.name" disabled></el-input>
        </el-form-item>
        <el-form-item label="你的答案">
          <el-input v-model="info.stutext" disabled></el-input>
        </el-form-item>
        <el-form-item label="教师评价">
          <el-input v-model="info.tectext" disabled></el-input>
        </el-form-item>
      </el-form>
    </div>


    <span slot="footer" class="dialog-footer">

    </span>
  </el-dialog>
</template>

<script>
import API from '@/util/API.js';

export default {
  name: 'InfoCover',
  components: {},
  props: ['uid','token','hid','dialogVisible'],
  data() {
    return {
      info: {
        "state": 0,
        "msg": "成功",
        "id": 1,
        "name": "作业1",
        "submited": true,
        "false": true,
        "stutext": "666",
        "tectext": "111",
      }
    }
  },
  methods: {
    handleClose: function(){
      this.$emit('onClose');
    },
    doSubmit: function(){
      let pform = {
        uid: this.uid,
        token: this.token,
        hid: this.hid,
        content: this.info.stutext,
      };

      console.log(pform);
      
      API.studentHomeworkSubmit(pform).then(res => {
        if (res.state === 0) {
          this.$message.info("提交成功");
          setTimeout(function(){location.reload()},1000);
        } else {
          this.$message.error(res.msg);
          console.log(res);
        }
      }).catch(msg => {
          alert(msg);
      });
    },
    refreshInfo: function(){
      let pform = {
        uid: this.uid,
        token: this.token,
        hid: this.hid,
      };
      
      API.studentHomeworkInfo(pform).then(res => {
        if (res.state === 0) {
          this.info = res;
        } else {
            this.$message.error(res.msg);
            console.log(res);
        }
      }).catch(msg => {
          alert(msg);
      });
    }
  },
  watch: {
    dialogVisible(newValue, oldValue) {
      if(newValue){
        this.refreshInfo();
      }
    }
  }
}

</script>

<style scoped>

</style>