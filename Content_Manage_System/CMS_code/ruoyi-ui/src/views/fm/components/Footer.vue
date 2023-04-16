<template>
  <div id="footer" class="">
    <MyContainer>
      <el-row>
        <el-col :span="2">
          <h4>学生服务</h4>
          <a>平台协议</a>
          <a>防骗指南</a>
          <a>使用帮助</a>
        </el-col>
        <el-col :span="2">
          <h4>企业服务</h4>
          <a>平台协议</a>
          <a>防骗指南</a>
          <a>使用帮助</a>
        </el-col>
        <el-col :span="10">
          <h4>联系在线博物馆</h4>
          <a>北京华品博睿网络技术有限公司</a>
          <a>公司地址 北京市朝阳区太阳宫中路16号院1号楼18层1801内09</a>
          <a>联系电话 010-84150633</a>
          <a>联系电话 010-84150633</a>
        </el-col>
        <el-col :span="5">
          <h4>XX学校在线博物馆</h4>
          <div class="footer-social">
            <a>企业服务热线和举报投诉 <span>400 065 5799</span></a>
            <a>工作日 <span>8:00 - 22:00</span></a>
            <a>休息日 <span>9:30 - 18:30</span></a>
          </div>
        </el-col>
        <el-col :span="5">
          <h4>微信公众号</h4>
          <img src="https://static.zhipin.com/v2/web/geek/images/we_chat_qr.jpg">
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <span style="float:left;margin-right: 30px;">Copyright © 2021 在线博物馆</span>
          <a href="https://beian.miit.gov.cn/" target="_blank">京ICP备14013441号-5</a>
        </el-col>
        <el-col :span="2">
          <a href="https://www.zhipin.com/activity/cc/businesslicense.html" rel="nofollow" ka="link-businesslicense" target="_blank">
            <img src="https://static.zhipin.com/v2/web/geek/images/icon-badge-1.png" alt="">
            电子营业执照
          </a>
        </el-col>
        <el-col :span="6">
          <a><img src="https://static.zhipin.com/v2/web/geek/images/icon-beian.png" alt=""> 京公网安备11010502032801</a>
        </el-col>
      </el-row>
    </MyContainer>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
export default {
  name: 'Footer',
  components: { MyContainer },
  data() {
    return {}
  },
  methods: {},
  created() {
  }
}
</script>

<style scoped>
a {
  display: block;
  font-size: 12px;
  color: #8d92a1;
  height: 24px;
  line-height: 24px;
}
a img {
  width: 16px;
  height: 16px;
  vertical-align: middle;
}
</style>
