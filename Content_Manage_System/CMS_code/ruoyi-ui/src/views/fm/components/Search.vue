<template>
  <div class="wrapper">
    <MyContainer :span="14">
      <el-input placeholder="请输入" v-model="name">
<!--        <el-select v-model="select" slot="prepend" placeholder="请选择">-->
<!--          <el-option label="岗位" value="1"></el-option>-->
<!--          <el-option label="公司" value="2"></el-option>-->
<!--        </el-select>-->
        <template slot="append">
          <el-button @click="toSearch" icon="el-icon-search">搜索</el-button>
        </template>
      </el-input>
    </MyContainer>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
export default {
  name: 'Search',
  components: { MyContainer },
  data() {
    return {
      select: '',
      name: '',
    }
  },
  methods:{
    toSearch(){
      this.$router.push({path:'/fm/result',query: {name:this.name}})
    },
  }
}
</script>

<style scoped lang="scss">
.wrapper {
  background-color: #fff;
}
.el-select {
  width: 100px;
}
.el-input {
  margin-top: 40px;
  margin-bottom: 40px;
}
.el-button {
  color: #409EFF!important;
  font-weight: bold;
}
</style>
