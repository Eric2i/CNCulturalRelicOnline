<template>
  <div>
    <MyContainer style="margin-top: 20px;">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/fm/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>搜索结果</el-breadcrumb-item>
      </el-breadcrumb>
    </MyContainer>
    <ProductList :list="list" title="场地列表"/>
    <Footer/>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import {mapGetters} from 'vuex'
import Footer from "@/views/fm/components/Footer";
import ProductList from "@/views/fm/components/ProductList";
import {listArea} from "@/api/system/area";


export default {
  name: 'Detail',
  components: {ProductList, Footer, MyContainer},
  computed: {
    ...mapGetters([
      'userId',
      'avatar',
      'name'
    ]),
  },
  data() {
    return {
      list: [],
    }
  },
  methods: {
    getList() {
      listArea(this.$route.query).then(({rows}) => {
        this.list=rows
      })
    },
  },
  created() {
    this.getList()
  }
}
</script>

<style scoped lang="scss">

</style>
