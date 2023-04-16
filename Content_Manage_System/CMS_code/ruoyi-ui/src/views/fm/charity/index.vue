<template>
  <div>
    <MyContainer style="margin-top: 20px;">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/fm/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>场地项目</el-breadcrumb-item>
      </el-breadcrumb>
      <el-row>
        <el-col :span="3">
          <el-tabs tab-position="left" @tab-click="handleClick" style="height: 200px;margin-top: 30px;">
            <el-tab-pane v-for="item in clist" :label="item.categoryName" :name="item.id+''"></el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col :span="21">
          <Search/>
          <cover/>
        </el-col>
      </el-row>
    </MyContainer>
    <Footer/>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import {mapGetters} from 'vuex'
import Footer from "@/views/fm/components/Footer";
import ProductList from "@/views/fm/components/ProductList";

import CategoryMenu from "@/components/Me/CategoryMenu.vue";
import Search from "@/views/fm/components/Search.vue";
import Cover from "@/views/fm/components/Cover.vue";
import {listCategory} from "@/api/system/category";

export default {
  name: 'Detail',
  components: {Cover, Search, CategoryMenu, ProductList, Footer, MyContainer},
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
      clist: [],
      form: {},
    }
  },
  methods: {
    getList() {
      // listCharity(this.$route.query).then(({rows}) => {
      //   this.list=rows
      // })
    },
    handleClick(tab, event) {
      this.form.categoryId = tab.name;
      this.bus.$emit('search', this.form)
    }
  },
  created() {
    this.getList()
    listCategory().then(({rows}) => {
      this.clist = rows
    })
  }
}
</script>

<style scoped lang="scss">

</style>
