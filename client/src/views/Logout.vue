<template>
  <div>
  </div>
</template>

<script>

import API from '@/util/API.js';

export default {
  name: 'Logout',
  components: {},
  data() {
    return {
      uid: this.$cookie.get("uid"),
      token: this.$cookie.get("token"),
    }
  },
  created: function() {
    this.doLogOut();
  },
  methods: {
    doLogOut: function(){
      let pform = {
        uid: this.uid,
        token: this.token,
      };
      
      API.userLogout(pform).then(res => {
        this.$cookie.delete("uid");
        this.$cookie.delete("token");
        this.$router.push({path:'/login'});
      }).catch(msg => {
        this.$cookie.delete("uid");
        this.$cookie.delete("token");
        this.$router.push({path:'/login'});
        alert(msg);
      });
      
    }
  }
}
</script>
