<template>
  <div class="floor">
    <el-divider><h1>{{ title }}</h1></el-divider>
    <div class="w clearfix">
      <div class="product">
        <div class="li" v-for="item in list">
          <div class="pro-img">
            <router-link :to="'/fm/detail/'+item.id">
              <img :src="item.cover" alt="">
            </router-link>
          </div>
          <h3>{{ item.name }}</h3>
          <p class="desc">{{ item.intro }}</p>
          <p class="price">
            <span>{{ item.money }}</span>元
          </p>
          <div class="review">
            <a href="#">
              <span class="msg">博物馆精选</span>
              <span class="auther"> 爱心接力,让爱丰富生活,让心充满希望。 </span>
            </a>
          </div>
        </div>
        <div v-if="false" class="li" v-for="i in 10">
          <div class="pro-img">
            <router-link :to="'/fm/detail/'+1">
              <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" alt="">
            </router-link>
          </div>
          <h3>清汤手擀面</h3>
          <p class="desc">吉玉面馆清汤手擀面美味，好吃</p>
          <p class="price">
            <span>41</span>元
            <del>199</del>
          </p>
          <div class="review">
            <a href="#">
              <span class="msg">博物馆精选</span>
              <span class="auther"> 爱心接力,让爱丰富生活,让心充满希望。 </span>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProductList",
  props: {
    list: {
      type: Array,
      default: () => []
    },
    title: {
      type: String,
      default: '热门场地'
    }
  }
}
</script>

<style scoped>
@import '~@/assets/styles/base.css';
.floor {
  background: #f5f5f5;
  margin-bottom: 50px;
}
/* 场地li */
.product .li {
  float: left;
  width: 285px;
  height: 300px;
  padding: 34px 0 20px;
  z-index: 1;
  margin-left: 14px;
  margin-bottom: 14px;
  background: #fff;
  -webkit-transition: all .2s linear;
  transition: all .2s linear;
  position: relative;
}

.pro-img {
  width: 150px;
  height: 150px;
  margin: 0 auto 18px;
}

.pro-img a {
  width: 100%;
  height: 100%;
}

.pro-img img {
  display: block;
  width: 100%;
  height: 100%;
}

.product .li h3 {
  margin: 0 10px;
  font-size: 14px;
  font-weight: 400;
  text-align: center;
}

.product .li h3 a {
  color: #333;
}

.desc {
  margin: 0 10px 10px;
  height: 18px;
  font-size: 12px;
  text-align: center;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  color: #b0b0b0;
}

.price {
  font-size: 14px;
  margin: 0 10px 10px;
  text-align: center;
  color: #ff6700;
}

.price del {
  color: #b0b0b0;
}

.review {
  position: absolute;
  bottom: 0;
  left: 0;
  z-index: 3;
  width: 100%;
  height: 0;
  overflow: hidden;
  font-size: 12px;
  background: #ff6700;
  opacity: 0;
  -webkit-transition: all .2s linear;
  transition: all .2s linear;
}

.review a {
  color: #757575;
  display: block;
  padding: 8px 30px;
  outline: 0;
}

.review a span {
  display: block;
  margin-bottom: 5px;
  color: #fff;
}

.product .li:hover {
  -webkit-box-shadow: 0 15px 30px rgba(0,0,0,0.1);
  box-shadow: 0 15px 30px rgba(0,0,0,0.1);
  -webkit-transform: translate3d(0, -2px, 0);
  transform: translate3d(0, -2px, 0);
}

.product .li:hover .review {
  opacity: 1;
  height: 76px;
}
</style>
