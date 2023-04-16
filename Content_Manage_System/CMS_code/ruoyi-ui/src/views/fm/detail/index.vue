<template>
  <div>
    <MyContainer style="margin-top: 20px;">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/fm/index' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>{{ info.category.categoryName }}</el-breadcrumb-item>
        <el-breadcrumb-item>详情</el-breadcrumb-item>
      </el-breadcrumb>
      <el-card>
        <div slot="header">
          <h2>{{info.name}}</h2>
        </div>
        <el-row :gutter="12">
          <el-col :span="10">
            <img :src="info.cover" style="width: 100%;"/>
          </el-col>
          <el-col :span="10">
            <div class="pros-other">
              <p>价格 : ￥ <b style="color:orange;font-size: 20px;">{{ info.price }}</b>元</p>
              <p>分类 ： <span>{{info.category.categoryName}}</span></p>
              <p>开始时间 ： <span>{{info.startTime}}</span></p>
              <p>结束时间 ： <span>{{info.endTime}}</span></p>
              <p>提示 ： <span>支付支持蚂蚁花呗，信用卡支付，集分宝等，注意您的资金安全！！</span></p>
              <p class="flex-row">状态：<dict-tag :options="dict.type.a_status" :value="info.status"/></p>
              <p>创建时间：{{info.createTime}}</p>
            </div>
            <el-button style="align-self:flex-end;" type="primary" @click="j" :disabled="info.status!==0" icon="el-icon-mobile">预约</el-button>
          </el-col>
          <el-col :span="4" class="text-center">
            <div class="title">联络夹</div>
<!--            <img :src="info.wx" style="width: 100%;"/>-->
            <div>手机号</div>
            <p>{{info.tel}}</p>
          </el-col>
        </el-row>
      </el-card>

      <el-divider content-position="left">详细介绍</el-divider>
      <div class="notice" v-html="info.detail"></div>
      <my-comment :product-id="id" :can="can"/>
    </MyContainer>
    <el-dialog title="预约" :visible.sync="open" width="400px" append-to-body>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable size="small"
                          v-model="form.startTime"
                          type="datetime"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable size="small"
                          v-model="form.endTime"
                          type="datetime"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="价格" prop="price">￥{{form.price}}元</el-form-item>
        <!--        <el-form-item label="数量" prop="num">-->
        <!--          <el-input v-model="form.num" placeholder="请输入数量" />-->
        <!--        </el-form-item>-->
        <el-form-item label="总价" prop="totalPrice">￥{{form.totalPrice}}元</el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog title="付款" :visible.sync="open1" width="300px" append-to-body>
      <h1>已预约，请支付</h1>
      <img src="@/assets/images/ewm.jpg"/>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <Footer/>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import {mapGetters} from 'vuex'
import Footer from "@/views/fm/components/Footer";
import MyComment from "@/views/fm/components/MyComment.vue";
import {getArea} from "@/api/system/area";
import {addAppointment} from "@/api/system/appointment";

export default {
  name: 'Detail',
  dicts: ['a_status'],
  components: {MyComment, Footer, MyContainer},
  computed: {
    ...mapGetters([
      'userId',
      'avatar',
      'name'
    ]),
  },
  data() {
    return {
      info: {category:{}},
      plist: [],
      form: {},
      can: !!this.$route.query.can,
      open: false,
      open1: false,
      id: this.$route.params.id,
    }
  },
  methods: {
    j() {
      this.open=true
      this.form={
        itemId:this.$route.params.id,
        type:0,
        num:1,
        price:this.info.price,
        totalPrice:this.info.price,
      }
    },
    submitForm() {
      addAppointment(this.form).then(({data}) => {
        this.$modal.msgSuccess('已预约，请支付');
        this.getInfo()
        this.open=false
        this.open1=true
      })
    },
    cancel() {
      this.open = this.open1 = false
    },
    getInfo() {
      getArea(this.id).then(res => {
        this.info = res.data
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

.pros-other {
  background: #eee;
  font-size: 14px;
  padding: 10px 0 10px 10px;
}

.title {
  height: 40px;
  line-height: 40px;
  background: #dfefff;
  color: #37d;
}
.notice {
  border: solid 1px #ddd;
  padding: 35px 48px;
}
</style>
