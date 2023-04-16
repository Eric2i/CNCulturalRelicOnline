<template>
  <MyContainer>
    <el-row :gutter="20">
      <el-col :span="6" :xs="24">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>个人信息</span>
          </div>
          <div>
            <div class="text-center">
              <userAvatar :user="user" />
            </div>
            <ul class="list-group list-group-striped">
              <li class="list-group-item">
                <svg-icon icon-class="user" />学号
                <div class="pull-right">{{ user.userName }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="phone" />手机号码
                <div class="pull-right">{{ user.phonenumber }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="email" />用户邮箱
                <div class="pull-right">{{ user.email }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="tree" />科室
                <div class="pull-right" v-if="user.dept">{{ user.dept.deptName }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="peoples" />角色
                <div class="pull-right">{{ roleGroup }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="date" />创建日期
                <div class="pull-right">{{ user.createTime }}</div>
              </li>
            </ul>
          </div>
        </el-card>
      </el-col>
      <el-col :span="18" :xs="24">
        <el-card>
          <div slot="header" class="clearfix">
            <span>基本资料</span>
          </div>
          <el-tabs v-model="activeTab" tab-position="left">
            <el-tab-pane label="基本资料" name="userinfo">
              <userInfo :user="user" />
            </el-tab-pane>
            <el-tab-pane label="修改密码" name="resetPwd">
              <resetPwd :user="user" />
            </el-tab-pane>
            <el-tab-pane label="参与的项目" name="order">
              <order/>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-col>
    </el-row>
  </MyContainer>
</template>

<script>
import userInfo from '@/views/system/user/profile/userInfo'
import resetPwd from '@/views/system/user/profile/resetPwd'
import userAvatar from '@/views/system/user/profile/userAvatar'
import FileUpload from '@/components/FileUpload'
import {getUserProfile} from '@/api/system/user'
import MyContainer from '@/components/Me/MyContainer'
import { mapGetters } from 'vuex'
import Order from "@/views/fm/user/order";

export default {
  name: 'Resume',
  components:{Order, MyContainer, userAvatar,FileUpload,userInfo,resetPwd },
  data() {
    return {
      user:{},
      roleGroup: {},
      // 性别字典
      sexOptions: [],
      statusOptions: [],
      activeTab: "userinfo",
    }
  },
  created() {
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
    this.getUser();
  },
  computed:{
    ...mapGetters([
      'userId',
      'name',
      'roles',
    ]),
  },
  methods: {
    // 性别字典翻译
    sexFormat(value) {
      return this.selectDictLabel(this.sexOptions, value);
    },
    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
        this.license = response.data.url;
        this.roleGroup = response.roleGroup;
      });
    },
  }
}
</script>

<style scoped>

</style>
