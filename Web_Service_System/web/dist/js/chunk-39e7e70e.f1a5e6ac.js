(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-39e7e70e"],{"2d6f":function(i,e,a){},"45b3":function(i,e,a){"use strict";a("2d6f")},6633:function(i,e,a){"use strict";a.r(e);var t=function(){var i=this,e=i.$createElement,a=i._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:i.loading,expression:"loading"}],staticClass:"difangmeishi-detail"},[a("div",[a("e-container",[a("div",{staticStyle:{margin:"10px 0 0 0"}},[a("e-module-model-box",{attrs:{title:"详情"}},[a("div",{},[a("div",{staticClass:"goods-info clearfix"},[a("div",{staticClass:"gallery-list"},[a("e-shangpinban",{attrs:{images:i.map.tupian}})],1),a("div",{staticClass:"goods-right-content"},[a("h3",{staticClass:"title",staticStyle:{"font-size":"30px"},domProps:{textContent:i._s(i.map.mingcheng)}}),a("hr"),a("div",{staticClass:"display"},[a("div",[a("span",{staticClass:"name"},[a("strong",[i._v("所属博物馆：")])]),a("span",{staticClass:"val"},[i._v(" "+i._s(i.map.fujinjingdian)+" ")])]),a("div",[a("span",{staticClass:"name"},[a("strong",[i._v("分类：")])]),a("span",{staticClass:"val"},[a("e-select-view",{attrs:{module:"meishifenlei",value:i.map.fenlei,select:"id",show:"fenleimingcheng"}})],1)]),a("div",[a("span",{staticClass:"name"},[a("strong",[i._v("文物简介：")])]),a("span",{staticClass:"val"},[i._v(" "+i._s(i.map.meishijianjie)+" ")])]),a("span",[a("strong",[i._v("点击收藏:")]),i._v("  "),a("nbsp")],1),a("e-collect",{attrs:{module:"difangmeishi",ziduan:"mingcheng",id:i.map.id},model:{value:i.isCollect,callback:function(e){i.isCollect=e},expression:"isCollect"}})],1)])])])])],1)])],1)])},s=[],n=(a("a9e3"),a("d722")),l=a("efff"),d={data:function(){return{loading:!1,isCollect:!1,map:{meishibianhao:"",mingcheng:"",fujinjingdian:"",fenlei:"",tupian:"",jiage:"",meishijianjie:"",addtime:""}}},props:{id:{type:[String,Number],required:!0}},watch:{id:{handler:function(){this.loadDetail()},immediate:!0}},computed:{},methods:{loadDetail:function(){var i=this;this.loading||(this.loading=!0,this.$get(n["a"].difangmeishi.webdetail,{id:this.id}).then((function(e){i.loading=!1,e.code==n["a"].code.OK?Object(l["d"])(i,e.data):i.$message.error(e.msg)})).catch((function(e){i.loading=!1,i.$message.error(e.message)})))}},created:function(){},mounted:function(){},destroyed:function(){}},o=d,c=(a("45b3"),a("2877")),r=Object(c["a"])(o,t,s,!1,null,"a8ebb066",null);e["default"]=r.exports}}]);