/**
 * Created by chengfan on 2017/4/15.
 */
import axios from '../http'
//import config from '../config'
import * as types from './type'
import router from "../router"

const actions = {

  // 登录验证三方法
  [types.LOGIN]: (context,data) => {
    axios({
      method: 'post',
      url: '/auth',
      data: data
    }).then(function(res){
      context.commit(types.LOGIN, res.data.token)
      console.log("login  " + res.data)
    }).catch(function(err){
      console.log(err)
    })

  },
  [types.LOGOUT]: (context, data) => {
    context.commit(types.LOGOUT, data)
  },
  [types.TITLE]: (context, data) => {
    context.commit(types.TITLE, data)
  },
  // 封装一个 ajax 方法
  tryLogin (context) {
    axios({
      method: 'post',
      url: '/login',
      data: context.state.newUser
    }).then(function(res){
      console.log(res.data)
    }).catch(function(err){
      console.log(err)
    })
  },
  register(context, data) {
    axios({
      method: 'post',
      url: '/auth/register',
      data: data
    }).then(function(res){
      router.push('/login')
      console.log(res)
    }).catch(function(err){
      console.log(err)
    })
  },
  getJianShuList(context) {
    axios({
      method: 'get',
      url: '/jianshu/all',
      // headers: {'Authorization':`Bearer ${context.state.token}`}
    }).then(function(res){
      context.commit('setJianShuList', res.data)
    }).catch(function(err){
      console.log(err)
    })
  },
  changeNowDir(context, nowDir){
    context.commit('changeNowDir', nowDir)
  },
  changeEditContentByFileIndex(context, index){
    context.commit('changeEditContentByFileIndex', index)
  },
  changeEditData(context, data){
    context.commit('changeEditData', data)
  },
  addDir(context,dirName){
    context.commit('addDir', dirName)
  },
  addFile(context, fileName){
    context.commit('addFile', fileName)
  },
  postArticle(context, data){
    axios({
      method: 'post',
      url: '/auth/article',
      data: data,
    }).then(function(res){
      //router.push('/login')
      console.log(res)
      alert("成功发布")
    }).catch(function(err){
      console.log(err)
    })

  }
}

export default actions
