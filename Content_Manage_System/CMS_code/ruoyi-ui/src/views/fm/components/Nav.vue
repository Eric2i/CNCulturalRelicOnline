<template>
  <MyContainer :span="17" :right-span="1">
    <el-container>
      <div class="logo">在线博物馆</div>
      <el-menu :default-active="activeIndex" mode="horizontal" text-color="#eee" active-text-color="#ffd04b" background-color="#000">
        <el-menu-item v-for="(item,index) in items[0]" :index="index+''" @click="changeMenu(index)">
          {{ item }}
        </el-menu-item>
        <el-menu-item v-if="name" v-for="(item,index) in items[1]" :index="index+items[0].length+''" @click="changeMenu(index+items[0].length)">
          {{ item }}
        </el-menu-item>
        <el-menu-item v-if="!name" v-for="(item,index) in items[2]" :index="index+items[0].length+items[1].length+''" @click="changeMenu(index+items[0].length+items[1].length)">
          {{ item }}
        </el-menu-item>
      </el-menu>
    </el-container>
    <div slot="right" v-if="name">
      <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
        <div class="avatar-wrapper">
          <img :src="avatar" class="user-avatar">
          <i class="el-icon-caret-bottom" />
        </div>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/fm/user">
            <el-dropdown-item>个人中心</el-dropdown-item>
          </router-link>
          <el-dropdown-item divided @click.native="logout">
            <span>退出登录</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </MyContainer>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import { mapGetters } from 'vuex'
export default {
  name: 'Nav',
  components: { MyContainer },
  data(){
    return{
      activeIndex:'0',
      items:[["首页"],["场地项目","个人中心","留言板","公告"],["注册","登录"]],
      navTos:["/fm/index",
        "/fm/charity","/fm/user","/fm/message","/fm/notice",
        "/fm/register","/fm/login"]
    }
  },
  computed:{
    ...mapGetters([
      'name',
      'avatar',
    ]),
  },
  methods:{
    changeMenu(index){
      this.activeIndex = index+'';
      this.$router.push(this.navTos[index])
    },
    logout() {
      this.$confirm('确定注销并退出系统吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$store.dispatch('LogOut').then(() => {
          location.href = '/fm/index';
        })
      })
    }
  }
}
</script>

<style scoped lang="scss">
.el-row {
  background-color: #000;
}
.logo {
  color: #409EFF;
  font-size: 30px;
  font-weight: 900;
  margin-right: 20px;
}
.right-menu-item {
  display: inline-block;
  padding: 0 8px;
  height: 100%;
  font-size: 18px;
  color: #5a5e66;
  vertical-align: text-bottom;

  &.hover-effect {
    cursor: pointer;
    transition: background .3s;

    &:hover {
      background: rgba(0, 0, 0, .025)
    }
  }
}

.avatar-container {
  float: right;
  margin-right: 30px;

  .avatar-wrapper {
    margin-top: 5px;
    position: relative;

    .user-avatar {
      cursor: pointer;
      width: 40px;
      height: 40px;
      border-radius: 10px;
    }

    .el-icon-caret-bottom {
      cursor: pointer;
      position: absolute;
      right: -20px;
      top: 25px;
      font-size: 12px;
    }
  }
}

</style>
