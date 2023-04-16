<template>
  <div>
    <el-table :data="list" style="width: 100%">
      <el-table-column label="场地名" align="center" prop="name" />
      <el-table-column label="主图" align="center" prop="cover" >
        <template slot-scope="scope">
          <img :src="scope.row.cover" alt="" width="100px" height="50px">
        </template>
      </el-table-column>
      <el-table-column label="筹款金额" align="center" prop="money" />
      <el-table-column label="联系方式" align="center" prop="tel" />
<!--      <el-table-column prop="createTime" label="创建时间"/>-->
    </el-table>
  </div>
</template>

<script>
import {mapGetters} from "vuex";


export default {
  name: "order",
  dicts: ['pay_status'],
  data () {
    return {
      list: [],
    }
  },
  computed: {
    ...mapGetters([
      'userId',
    ])
  },
  methods:{
    del(id) {
    },
    listOrder() {
      listCharity({
        p:this.userId
      }).then(({rows})=>{
        this.list=rows
      })
    },
  },
  created() {
    this.listOrder()
  }
}
</script>

<style scoped>
.price {
  color: orange;
  font-weight: bold;
  font-size: 20px;
  margin-right: 30px;
}
</style>
