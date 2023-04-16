<template>
  <div style="height: 93vh;overflow: hidden;background:rgb(93,213,200) url(https://static.zhipin.com/zhipin-geek/v364/web/geek/images/newbg.png) no-repeat center bottom;">
    <div class="form-wrap clearfix">
      <el-col :span="8">
        <h3>沟通</h3>
        <p>在线及时沟通</p>
        <h3>技术支持</h3>
        <p>北京厚普聚益科技有限公司</p>
      </el-col>
      <el-col :span="16">
        <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
          <el-form-item label="用户昵称" prop="nickName">
            <el-input v-model="formData.nickName" placeholder="请输入用户昵称" />
          </el-form-item>
          <el-form-item label="用户账号" prop="userName">
            <el-input v-model="formData.userName" placeholder="请输入用户账号" />
          </el-form-item>
          <el-form-item label="用户密码" prop="password">
            <el-input v-model="formData.password" placeholder="请输入用户密码" type="password" />
          </el-form-item>
          <el-form-item label="联系电话" prop="phonenumber">
            <el-input v-model="formData.phonenumber" placeholder="请输入联系电话" :maxlength="11" show-word-limit clearable
                      prefix-icon='el-icon-mobile' :style="{width: '100%'}"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="formData.email" placeholder="请输入邮箱" maxlength="50" />
          </el-form-item>
          <el-row>
            <el-col :span="12">
              <el-form-item label="性别">
                <el-select v-model="formData.sex" placeholder="请选择">
                  <el-option
                    v-for="dict in sexOptions"
                    :key="dict.dictValue"
                    :label="dict.dictLabel"
                    :value="dict.dictValue"
                  ></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </div>
  </div>
</template>
<script>
import MyContainer from '@/components/Me/MyContainer'
import { register } from "@/api/login";

export default {
  components: { MyContainer },
  data() {
    return {
      // 性别状态字典
      sexOptions: [],
      formData: {
        roleIds: [2],
      },
      rules: {
        "userName": [{
          required: true,
          message: '请输入账号名称',
          trigger: 'blur'
        }],
        "nickName": [{
          required: true,
          message: '请输入账号名称',
          trigger: 'blur'
        }],
        "phonenumber": [{
          required: true,
          message: '请输入联系电话',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        "password": [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }],
      },
    }
  },
  created() {
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
  },
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (valid) {
          register(this.formData).then(response => {
            if (response.code === 200) {
              this.$message.success(response.msg)
              this.$router.push("/fm/login")
            } else {
              this.$message.error(response.msg);
            }
          })
        }
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style scoped>
.el-upload__tip {
  line-height: 1.2;
}
.form-wrap {
  padding: 30px;
  width: 60%;
  margin: 50px auto 0;
  background: #fff;
  box-shadow: 0 6px 13px 0 rgba(0,0,0,.1);
  border-radius: 10px;
}
</style>
