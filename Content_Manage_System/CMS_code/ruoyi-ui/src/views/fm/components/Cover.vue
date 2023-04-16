<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="8" v-for="(item, index) in list" style="height: 240px;margin-bottom: 20px;">
        <el-card shadow="hover">
          <router-link :to="'/fm/detail/'+item.id">
            <img :src="item.cover" class="image">
            <div style="padding: 14px;">
              <span>{{ item.name }}</span>
            </div>
          </router-link>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>

export default {
  name: 'Cover',
  components: {  },
  props:{
    label: {
      type: String,
      default: '音乐'
    },
  },
  data() {
    return {
      list: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 16,
      },
    }
  },
  methods: {
    getList() {
      listCharity(this.queryParams).then(res => {
        this.list = res.rows
      })
    },
    to(id) {
      this.$router.push('/item/f/detail/'+id)
    },
  },
  created() {
    this.getList()
    this.bus.$on('search', (data)=>{
      this.queryParams={...this.queryParams,...data}
      this.getList()
    })
  }
}
</script>

<style scoped>
.el-col {
  margin-bottom: 30px;
}

.image {
  width: 100%;
  height: 150px;
  display: block;
}

</style>
