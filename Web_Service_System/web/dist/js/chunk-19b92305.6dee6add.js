(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-19b92305"],{1103:function(i,t,e){"use strict";e("e85c")},"1e4b":function(i,t,e){"use strict";e.r(t);var n=function(){var i=this,t=i.$createElement,e=i._self._c||t;return e("div",{directives:[{name:"loading",rawName:"v-loading",value:i.loading,expression:"loading"}]},[e("div",[e("el-carousel",{attrs:{"indicator-position":"outside",height:"450px"}},i._l(i.bhtList,(function(t){return e("el-carousel-item",{key:t.id},[e("div",{staticStyle:{"background-size":"cover",height:"100%"},on:{click:function(e){return i.$goto(t.url)}}},[e("e-img",{staticStyle:{height:"100%"},attrs:{src:t.image}})],1)])})),1)],1),e("div",[e("e-container",[e("div",{staticStyle:{margin:"10px 0 0 0"}},[e("e-module-model-box",{attrs:{title:"推荐文物信息"}},[e("el-row",{attrs:{gutter:30}},i._l(i.difangmeishilist2,(function(i){return e("el-col",{key:i.id,staticStyle:{"margin-bottom":"20px"},attrs:{md:6}},[e("e-module-products",{attrs:{title:i.mingcheng,price:"",description:i.meishijianjie,image:i.tupian,"image-height":100,ro:"","is-scale":!0,to:"/difangmeishidetail?id="+i.id}})],1)})),1)],1)],1)])],1),e("div",[e("e-container",[e("div",{staticStyle:{margin:"10px 0 0 0"}},[e("e-module-model-box",{attrs:{title:"热门博物馆"}},[e("el-row",{attrs:{gutter:30}},i._l(i.jingdianxinxilist1,(function(i){return e("el-col",{key:i.id,staticStyle:{"margin-bottom":"20px"},attrs:{md:6}},[e("e-module-products",{attrs:{title:i.jingdianmingcheng,price:i.piaojia,description:i.miaoshu,image:i.tupian,"image-height":100,"is-scale":!0,to:"/jingdianxinxidetail?id="+i.id}})],1)})),1)],1)],1)])],1),e("div"),e("div",[e("e-container",[e("div",{staticStyle:{margin:"10px 0 0 0"}},[e("e-module-model-box",{attrs:{title:"系统资讯"}},[e("div",{},i._l(i.xinwenxinxilist4,(function(t){return e("e-news-list",{key:t.id,attrs:{to:"/xinwenxinxidetail?id="+t.id,title:t.biaoti,description:t.neirong,len:80,image:t.tupian}},[e("span",[i._v("分类: "),e("e-select-view",{attrs:{module:"xinwenfenlei",value:t.fenlei,select:"id",show:"fenleimingcheng"}})],1),e("span",[i._v("添加人:"+i._s(t.tianjiaren))]),e("span",[i._v("点击率:"+i._s(t.dianjilv))])])})),1)])],1)])],1)])},a=[],o=e("d722"),s=e("efff"),d={data:function(){return{loading:!1,bhtList:[],jingdianxinxilist1:[],difangmeishilist2:[],lvyouxianlulist3:[],xinwenxinxilist4:[]}},watch:{},computed:{},methods:{loadPageData:function(){var i=this;this.loading||(this.loading=!0,this.$get("/index").then((function(t){i.loading=!1,t.code==o["a"].code.OK?Object(s["d"])(i,t.data):i.$message.error(t.msg)})).catch((function(t){i.loading=!1,i.$message.error(t.message)})))}},created:function(){this.loadPageData()},mounted:function(){},destroyed:function(){}},l=d,r=(e("1103"),e("2877")),c=Object(r["a"])(l,n,a,!1,null,"6e468d84",null);t["default"]=c.exports},e85c:function(i,t,e){}}]);