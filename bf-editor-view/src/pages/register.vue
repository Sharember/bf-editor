<template>
    <div class="register">
      <el-form ref="register" :model="newUser" label-width="80px">
        用户名： <el-input v-model="newUser.userName" placeholder="请输入用户名"></el-input>
        密  码： <el-input v-model="newUser.userPassword" placeholder="请输入密码"></el-input>
        确认密码： <el-input v-model="newUser.rePassword" placeholder="请再次输入密码"></el-input>

        <el-button type="primary" v-on:click="register">确认</el-button>
      </el-form>
    </div>
</template>
<script>
export default{
  name : 'register',
  data(){
      return{
        newUser : {
          userName : '',
          userPassword : '',
          rePassword : ''
        }
      }
  },
  methods: {
    register () {
      if(this.newUser.userPassword == this.newUser.rePassword){
        this.$store.dispatch('register', this.newUser)
      } else {
        alert("两次输入的密码不一致，请重新输入")
        this.newUser.rePassword = ''
        this.newUser.userPassword = ''
      }

    }
  }
}
</script>

<style  lang="scss">
.register {
  width:300px;
  height:200px;
  position:absolute;
  left:50%;
  top:50%;
  margin:-100px 0 0 -150px

}
</style>
