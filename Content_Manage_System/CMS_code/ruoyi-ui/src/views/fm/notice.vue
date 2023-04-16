<template>
  <div>
    <MyContainer>
      <el-collapse v-model="activeNames" accordion>
        <el-collapse-item v-for="item in list" :title="item.noticeTitle" :name="item.noticeId">
          <div>{{item.createTime}}</div>
          <div v-html="item.noticeContent"></div>
        </el-collapse-item>
      </el-collapse>
    </MyContainer>
    <Footer/>
  </div>
</template>

<script>
import MyContainer from "@/components/Me/MyContainer";
import {listNotice} from "@/api/system/notice";
import Footer from "@/views/fm/components/Footer";
export default {
  name: "Notice",
  components: {Footer, MyContainer},
  data() {
    return {
      activeNames: ['1'],
      list: []
    };
  },
  methods: {},
  created() {
    listNotice().then(({rows}) => {
      this.list = rows
    })
  }
}
</script>

<style scoped>

</style>
