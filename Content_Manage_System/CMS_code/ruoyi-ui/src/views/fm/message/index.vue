<template>
  <div>
    <MyContainer>
      <h1 style="text-align:center;">有什么问题或者建议都可以反馈给我们！</h1>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="姓名">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="联系方式">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" v-model="form.content"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">提交</el-button>
        </el-form-item>
      </el-form>
    </MyContainer>
    <Footer/>
  </div>
</template>

<script>
import MyContainer from "@/components/Me/MyContainer";
import {mapGetters} from "vuex";
import Footer from "@/views/fm/components/Footer";
import {addMessage} from "@/api/system/message";

export default {
  components: {Footer, MyContainer},
  data() {
    return {
      form: {},
    }
  },
  computed: {
    ...mapGetters([
      'userId',
      'name',
    ])
  },
  created() {
  },
  methods: {
    onSubmit() {
      addMessage(this.form).then(({msg}) => {
        this.$modal.msgSuccess(msg)
        this.form={}
      })
    },
  },
}
</script>

<style scoped>

</style>
