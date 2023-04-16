<template>
  <el-carousel trigger="click" height="360px">
<!--    <el-carousel-item v-for="item in list">-->
<!--      <router-link :to="'/fm/detail/'+item.itemId">-->
<!--      <img :src="item.url" alt="" style="width: 100%;">-->
<!--      </router-link>-->
<!--    </el-carousel-item>-->

    <el-carousel-item>
      <img src="@/assets/images/poster1.png" alt="" style="width: 100%;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="@/assets/images/poster2.png" alt="" style="width: 100%;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="@/assets/images/poster3.png" alt="" style="width: 100%;">
    </el-carousel-item>
  </el-carousel>
</template>

<script>

export default {
  name: "Carousel",
  data() {
    return {
      list: []
    }
  },
  methods: {
    getList() {
      listCarousel().then(({rows}) =>{
        this.list = rows;
      })
    }
  },
  created() {
    // this.getList();
  },
}
</script>

<style scoped>

</style>
