<template>
  <el-dialog
    title="作业信息"
    :modal=false
    :visible.sync="dialogVisible"
    width="70%"
    :before-close="handleClose">

    <el-form label-position="top" label-width="80px" class="TL LF">
      <el-form-item label="作业名称">
        <el-input v-model="info.name" disabled></el-input>
      </el-form-item>
      <el-form-item label="提交列表">
        
        <el-table
          :data="info.list"
          style="width: 100%">
          <el-table-column
            prop="name"
            label="学生姓名"
            width="180">
          </el-table-column>
          <el-table-column
            prop="stutext"
            label="答案"
            width="180">
          </el-table-column>
          <el-table-column
            prop="tchtext"
            label="评价">
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                size="mini"
                @click="handleEdit(scope.row.sid)">评价</el-button>
            </template>
          </el-table-column>
        </el-table>

      </el-form-item>
    </el-form>

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
        "list": [
          {
            "sid": 1,
            "name": "11同学",
            "stutext": "666",
            "tchtext": "111"
          },
          {
            "sid": 2,
            "name": "12同学",
            "stutext": "stt",
            "tchtext": ""
          },
          {
            "sid": 3,
            "name": "13同学",
            "stutext": "",
            "tchtext": ""
          }
        ]
      }
    }
  },
  methods: {
    handleClose: function(){
      this.$emit('onClose');
    },
    doSubmit: function(sid){

    },
    refreshInfo: function(){
      let pform = {
        uid: this.uid,
        token: this.token,
        hid: this.hid,
      };
      
      API.teacherHomeworkInfo(pform).then(res => {
        if (res.state === 0) {
          this.info = res;
        } else {
            this.$message.error(res.msg);
            console.log(res);
        }
      }).catch(msg => {
          alert(msg);
      });
    },
    handleEdit: function(sid){
      this.$prompt('', '请输评价', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        let pform = {
          uid: this.uid,
          token: this.token,
          sid: sid,
          content: value,
        };
        
        API.teacherHomeworkSubmit(pform).then(res => {
          if (res.state === 0) {
            this.$message.success(res.msg);
            this.refreshInfo();
          } else {
            this.$message.error(res.msg);
            console.log(res);
          }
        }).catch(msg => {
            alert(msg);
        });
      }).catch(() => {});
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