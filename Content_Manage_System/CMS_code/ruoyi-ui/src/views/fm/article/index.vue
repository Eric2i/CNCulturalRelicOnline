<template>
  <div>
    <MyContainer style="margin-top: 20px;">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/fm/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>详情</el-breadcrumb-item>
      </el-breadcrumb>
      <el-card>
        <div slot="header">
          <div>
            <img :src="info.cover" alt="">
          </div>
          <el-divider><h2>{{info.title}}</h2></el-divider>
          <div class="justify-between">
            <span>
              <i class="el-icon-user-solid"></i>{{info.createBy}}
              <i class="el-icon-date ml20"></i>{{info.createTime}}
            </span>
            <span class="hot">浏览次数：{{info.views}}</span>
          </div>
        </div>
        <div v-html="info.content"></div>
      </el-card>
    </MyContainer>
    <Footer/>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import {mapGetters} from 'vuex'
import Footer from "@/views/fm/components/Footer";
import {getArticle,views} from "../../../api/system/article";

export default {
  name: 'Detail',
  components: { Footer, MyContainer},
  computed: {
    ...mapGetters([
      'userId',
      'avatar',
      'name'
    ])
  },
  data() {
    return {
      info: {},
      form: {},
      id: this.$route.params.id,
      num: 1,
      open: false,
    }
  },
  methods: {
    getInfo() {
      getArticle(this.id).then(res => {
        this.info = res.data
      })
      views(this.id).then(res=>{
        console.log(res)
      })
    },
  },
  created() {
    this.getInfo()
  }
}
</script>

<style scoped lang="scss">

img {
  width: 100%;
  max-height: 350px;
}

.hot {
  font-size: 14px;
  color: #ff4848;
}

</style>
