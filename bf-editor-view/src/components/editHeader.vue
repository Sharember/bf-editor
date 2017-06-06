<template>
    <div class="main-edit-header">

      <el-dialog title="文章发布" v-model="pushFileVisible">
        <el-form :model="push">
          <el-form-item label="选择网站" :label-width="formLabelWidth">
            <el-checkbox :indeterminate="isIndeterminate" v-model="checkedSites" @change="handleCheckAllChange">全选</el-checkbox>
            <div style="margin: 15px 0;"></div>
            <el-checkbox-group v-model="checkedSites" @change="handleCheckedSitesChange">
              <el-checkbox v-for="site in sites" :label="site" :key="site">{{site}}</el-checkbox>
            </el-checkbox-group>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="pushFileVisible = false">取 消</el-button>
          <el-button type="primary" @click="publish">确 定</el-button>
        </div>
      </el-dialog>


      <el-menu  class="setting-menu" mode="horizontal">

        <el-button-group class="operate-group">
          <el-button type="primary" icon="document">保存</el-button>
          <el-button type="primary" icon="share">分享</el-button>
          <el-button type="primary" @click="pushFileVisible = true"><i class="fa fa-external-link" ></i>&nbsp;发布</el-button>
        </el-button-group>

        <!--<el-menu-item index="1" @click="goHome">回到主页</el-menu-item>-->
        <el-menu-item index="2">文章管理</el-menu-item>
        <el-menu-item index="3">编辑设置</el-menu-item>

      </el-menu>

    </div>
</template>
<script>
const siteOptions = ['51CTO', '网易博客', '博客园', 'csdn'];
export default{
  name: 'editHeader',
  data(){
      return{

        pushFileVisible : false,
        formLabelWidth: '120px',
        checkAll: true,
        checkedSites: ['网易博客', '博客园'],
        sites: siteOptions,
        isIndeterminate: true
      }
  },
  methods : {
    handleCheckAllChange(event) {
      this.checkedSites = event.target.checked ? siteOptions : [];
      this.isIndeterminate = false;
    },
    handleCheckedSitesChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.sites.length;
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.sites.length;
    },
    publish : function (){
      if(this.checkedSites == "" || this.checkedSites == null){
        alert("请选择网站")
      }else{
        this.pushFileVisible = false
        const _state = this.$store.state
        let objArr = []
        this.checkedSites.forEach(function (value) {
          switch(value) {
            case "网易博客":
              objArr.push({id: 2, name : '网易博客'})
              break;
            case "博客园":
              objArr.push({id: 3, name : '博客园'})
              break;
          }
        });
        const PushArticle = {
          userId: '',
          title: '',
          description: '',
          content: '',
          postSite: [],
        }
        //拼凑数据
        const fileId = _state.nowData.nowFile
        PushArticle.userId = _state.user.id
        PushArticle.postSite = objArr
        PushArticle.title = _state.fileList[_state.nowData.nowDir - 1].list.find((o) => o.id == fileId).title
        //PushArticle.content = _state.fileList.find( dir => dir.id == dirId ).find( file => file.id == fileId ).content
        PushArticle.content = _state.nowData.editData.htmlValue
        //传递到后台
        this.$store.dispatch('postArticle', PushArticle)
        //判断是否成功

      }
    }
  }
}
</script>
<style lang="scss">
  .main-edit-header{
    box-shadow:0px 0px 15px #f00;
    .setting-menu{
      .operate-group{
        margin: 1%;
      }
      .el-menu-item, .el-submenu{
        float: right;
      }
    }
  }
</style>
