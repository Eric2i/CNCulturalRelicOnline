<template>
  <div>
    <MyContainer>
      <CategoryMenu/>
      <carousel/>
    </MyContainer>
    <ProductList :list="list"/>

    <MyContainer>
      <el-divider><h1>资讯</h1></el-divider>
      <div class="flex-row mb20" v-for="a in articles">
        <img :src="a.cover" alt="" width="250px" height="150px">
        <div class="ml20 mt10">
          <h1 class="mb20">
            <router-link :to="'/fm/article/'+a.id">{{ a.title }}</router-link>
          </h1>
          <p>{{a.content}}
          </p>
          <p class="mt20">[{{a.createTime}}]</p>
        </div>
      </div>
    </MyContainer>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import CategoryMenu from "@/components/Me/CategoryMenu";
import ProductList from "@/views/fm/components/ProductList";
import {listArticle} from "@/api/system/article";

import Carousel from "@/views/fm/components/Carousel";
import {listArea} from "@/api/system/area";

export default {
  name: 'IndexMain',
  components: {Carousel, ProductList, CategoryMenu, MyContainer },
  data() {
    return {
      activeIndex: -1,
      list: [],
      articles: [],
    }
  },
  methods: {
    selectStyle(item, index) {
      this.activeIndex = index
    },
    outStyle(item) {
      this.activeIndex = -1
    },
    listProduct() {
      listArea().then(res=>{
        (res.rows.length>12)&&(res.rows.length=12)
        this.list=res.rows
      })
      listArticle().then(res=>{
        this.articles=res.rows
      })
    },
    toSearch(name){
      this.$router.push({path:'/fm/result',query: {name}})
    },
  },
  created() {
    this.listProduct()
  }
}
</script>

<style scoped>

</style>
