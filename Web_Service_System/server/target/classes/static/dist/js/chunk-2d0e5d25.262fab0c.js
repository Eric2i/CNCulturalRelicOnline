(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0e5d25"],{"95b5":function(a,i,s){"use strict";s.r(i);var t=function(){var a=this,i=a.$createElement,s=a._self._c||i;return s("div",{directives:[{name:"loading",rawName:"v-loading",value:a.loading,expression:"loading"}],staticClass:"jingdianxinxi-detail"},[s("div",[s("e-container",[s("div",{staticStyle:{margin:"10px 0 0 0"}},[s("e-module-model-box",{attrs:{title:"景点详情"}},[s("div",{},[s("div",{staticClass:"goods-info clearfix"},[s("div",{staticClass:"gallery-list"},[s("e-shangpinban",{attrs:{images:a.map.tupian}})],1),s("div",{staticClass:"goods-right-content"},[s("h3",{staticClass:"title",domProps:{textContent:a._s(a.map.jingdianmingcheng)}}),s("div",{staticClass:"descount"},[s("div",[s("span",{staticClass:"name"},[a._v(" 所属地区： ")]),s("span",{staticClass:"val"},[s("e-select-view",{attrs:{module:"diqu",value:a.map.suoshudiqu,select:"id",show:"diqumingcheng"}})],1)]),s("div",[s("span",{staticClass:"name"},[a._v(" 地址： ")]),s("span",{staticClass:"val"},[a._v(" "+a._s(a.map.dizhi)+" ")])]),s("div",[s("span",{staticClass:"name"},[a._v(" 开放时间： ")]),s("span",{staticClass:"val"},[a._v(" "+a._s(a.map.kaifangshijian)+" ")])]),s("div",[s("span",{staticClass:"name"},[a._v(" 附近美食： ")]),s("span",{staticClass:"val"},[a._v(" "+a._s(a.map.fujinmeishi)+" ")])]),s("div",[s("span",{staticClass:"name"},[a._v(" 票价： ")]),s("span",{staticClass:"val"},[a._v(" "+a._s(a.map.piaojia)+" ")])]),s("div",[s("span",{staticClass:"name"},[a._v(" 浏览量： ")]),s("span",{staticClass:"val"},[a._v(" "+a._s(a.map.liulanliang)+" ")])])]),s("e-collect",{attrs:{module:"jingdianxinxi",ziduan:"jingdianmingcheng",id:a.map.id},model:{value:a.isCollect,callback:function(i){a.isCollect=i},expression:"isCollect"}})],1)]),s("div",{staticClass:"goods-content",domProps:{innerHTML:a._s(a.map.miaoshu)}})])])],1)])],1)])},n=[],e=(s("a9e3"),s("d722")),d=s("efff"),l={data:function(){return{loading:!1,isCollect:!1,map:{jingdianbianhao:"",jingdianmingcheng:"",suoshudiqu:"",tupian:"",kaifangshijian:"",fujinmeishi:"",dizhi:"",piaojia:"",liulanliang:"",miaoshu:"",addtime:""}}},props:{id:{type:[String,Number],required:!0}},watch:{id:{handler:function(){this.loadDetail()},immediate:!0}},computed:{},methods:{loadDetail:function(){var a=this;this.loading||(this.loading=!0,this.$get(e["a"].jingdianxinxi.webdetail,{id:this.id}).then((function(i){a.loading=!1,i.code==e["a"].code.OK?Object(d["d"])(a,i.data):a.$message.error(i.msg)})).catch((function(i){a.loading=!1,a.$message.error(i.message)})))}},created:function(){},mounted:function(){},destroyed:function(){}},o=l,c=s("2877"),m=Object(c["a"])(o,t,n,!1,null,"71def704",null);i["default"]=m.exports}}]);