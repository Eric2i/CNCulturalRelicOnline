(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-014c80eb"],{3008:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"jingdianxinxi-add"},[n("el-card",{staticClass:"box-card"},[n("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[n("span",{staticClass:"title"},[e._v(" 添加景点信息")])]),n("div",{staticClass:"form-database-form"},[n("el-form",{ref:"formModel",attrs:{model:e.form,"label-width":"130px","status-icon":"","validate-on-rule-change":""}},[n("el-form-item",{attrs:{label:"景点编号",prop:"jingdianbianhao",rules:[{required:!0,message:"请填写景点编号"}]}},[n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"输入景点编号"},model:{value:e.form.jingdianbianhao,callback:function(t){e.$set(e.form,"jingdianbianhao",t)},expression:"form.jingdianbianhao"}})],1),n("el-form-item",{attrs:{label:"景点名称",prop:"jingdianmingcheng",required:"",rules:[{required:!0,message:"请填写景点名称"}]}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入景点名称"},model:{value:e.form.jingdianmingcheng,callback:function(t){e.$set(e.form,"jingdianmingcheng",t)},expression:"form.jingdianmingcheng"}})],1),n("el-form-item",{attrs:{label:"所属地区",prop:"suoshudiqu",required:"",rules:[{required:!0,message:"请填写所属地区"}]}},[n("el-select",{model:{value:e.form.suoshudiqu,callback:function(t){e.$set(e.form,"suoshudiqu",t)},expression:"form.suoshudiqu"}},e._l(e.diquList,(function(e){return n("el-option",{attrs:{value:e.id,label:e.diqumingcheng}})})),1)],1),n("el-form-item",{attrs:{label:"图片",prop:"tupian",required:"",rules:[{required:!0,message:"请填写图片"}]}},[n("e-upload-images",{model:{value:e.form.tupian,callback:function(t){e.$set(e.form,"tupian",t)},expression:"form.tupian"}})],1),n("el-form-item",{attrs:{label:"开放时间",prop:"kaifangshijian",required:"",rules:[{required:!0,message:"请填写开放时间"}]}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入开放时间"},model:{value:e.form.kaifangshijian,callback:function(t){e.$set(e.form,"kaifangshijian",t)},expression:"form.kaifangshijian"}})],1),n("el-form-item",{attrs:{label:"附近美食",prop:"fujinmeishi"}},[n("el-select",{attrs:{multiple:"multiple"},model:{value:e.form.fujinmeishi,callback:function(t){e.$set(e.form,"fujinmeishi",t)},expression:"form.fujinmeishi"}},e._l(e.difangmeishiList,(function(e){return n("el-option",{attrs:{value:e.mingcheng,label:e.mingcheng}})})),1)],1),n("el-form-item",{attrs:{label:"地址",prop:"dizhi",required:"",rules:[{required:!0,message:"请填写地址"}]}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入地址"},model:{value:e.form.dizhi,callback:function(t){e.$set(e.form,"dizhi",t)},expression:"form.dizhi"}})],1),n("el-form-item",{attrs:{label:"票价",prop:"piaojia",rules:[{validator:e.rule.checkNumber,message:"输入一个有效数字"}]}},[n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"输入票价"},model:{value:e.form.piaojia,callback:function(t){e.$set(e.form,"piaojia",t)},expression:"form.piaojia"}})],1),n("el-form-item",{attrs:{label:"描述",prop:"miaoshu",required:"",rules:[{required:!0,message:"请填写描述"}]}},[n("e-editor",{model:{value:e.form.miaoshu,callback:function(t){e.$set(e.form,"miaoshu",t)},expression:"form.miaoshu"}})],1),e.btnText?n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.submit}},[e._v(e._s(e.btnText))])],1):e._e()],1)],1)])],1)},i=[],a=n("d722"),o=n("b39c"),u=n("efff"),s={name:"jingdianxinxi-add",data:function(){return{rule:o["a"],loading:!1,form:{jingdianbianhao:o["a"].getID(),jingdianmingcheng:"",suoshudiqu:"",tupian:"",kaifangshijian:"",fujinmeishi:"",dizhi:"",piaojia:"",miaoshu:""},diquList:[],difangmeishiList:[]}},watch:{},props:{isRead:{type:Boolean,default:!0},btnText:{type:String,default:"提交"}},computed:{},methods:{submit:function(){var e=this;this.$refs.formModel.validate().then((function(t){if(!e.loading){e.loading=!0;var n=e.form;e.$post(a["a"].jingdianxinxi.insert,n).then((function(t){e.loading=!1,t.code==a["a"].code.OK?(e.$message.success("添加成功"),e.$emit("success",t.data),e.$refs.formModel.resetFields(),e.loadInfo()):e.$message.error(t.msg)})).catch((function(t){e.loading=!1,e.$message.error(t.message)}))}})).catch((function(e){console.log(e.message)}))},loadInfo:function(){var e=this;this.form;this.loading=!0,this.$post(a["a"].jingdianxinxi.create,{id:this.$route.query.id}).then((function(t){e.loading=!1,t.code==a["a"].code.OK?Object(u["d"])(e,t.data):(e.$message.error(t.msg),e.$router.go(-1))})).catch((function(t){e.$message.error(t.message),e.$router.go(-1)}))}},created:function(){this.loadInfo()},mounted:function(){},destroyed:function(){}},c=s,l=(n("fcb6"),n("2877")),f=Object(l["a"])(c,r,i,!1,null,"5ee2ddf4",null);t["default"]=f.exports},"94ab":function(e,t,n){},b39c:function(e,t,n){"use strict";n("ac1f"),n("00b4");var r=n("0499"),i=n("efff");n("fb6a"),n("d3b7"),n("25f0"),n("5319");function a(e,t){var n,r,i=["Sun","Mon","Tues","Wednes","Thurs","Fri","Satur","January","February","March","April","May","June","July","August","September","October","November","December"],a=/\\?(.?)/gi,o=function(e,t){return r[e]?r[e]():t},u=function(e,t){e=String(e);while(e.length<t)e="0"+e;return e};r={d:function(){return u(r.j(),2)},D:function(){return r.l().slice(0,3)},j:function(){return n.getDate()},l:function(){return i[r.w()]+"day"},N:function(){return r.w()||7},S:function(){var e=r.j(),t=e%10;return t<=3&&1==parseInt(e%100/10,10)&&(t=0),["st","nd","rd"][t-1]||"th"},w:function(){return n.getDay()},z:function(){var e=new Date(r.Y(),r.n()-1,r.j()),t=new Date(r.Y(),0,1);return Math.round((e-t)/864e5)},W:function(){var e=new Date(r.Y(),r.n()-1,r.j()-r.N()+3),t=new Date(e.getFullYear(),0,4);return u(1+Math.round((e-t)/864e5/7),2)},F:function(){return i[6+r.n()]},m:function(){return u(r.n(),2)},M:function(){return r.F().slice(0,3)},n:function(){return n.getMonth()+1},t:function(){return new Date(r.Y(),r.n(),0).getDate()},L:function(){var e=r.Y();return e%4===0&e%100!==0|e%400===0},o:function(){var e=r.n(),t=r.W(),n=r.Y();return n+(12===e&&t<9?1:1===e&&t>9?-1:0)},Y:function(){return n.getFullYear()},y:function(){return r.Y().toString().slice(-2)},a:function(){return n.getHours()>11?"pm":"am"},A:function(){return r.a().toUpperCase()},B:function(){var e=3600*n.getUTCHours(),t=60*n.getUTCMinutes(),r=n.getUTCSeconds();return u(Math.floor((e+t+r+3600)/86.4)%1e3,3)},g:function(){return r.G()%12||12},G:function(){return n.getHours()},h:function(){return u(r.g(),2)},H:function(){return u(r.G(),2)},i:function(){return u(n.getMinutes(),2)},s:function(){return u(n.getSeconds(),2)},u:function(){return u(1e3*n.getMilliseconds(),6)},e:function(){throw"Not supported (see source code of date() for timezone on how to add support)"},I:function(){var e=new Date(r.Y(),0),t=Date.UTC(r.Y(),0),n=new Date(r.Y(),6),i=Date.UTC(r.Y(),6);return e-t!==n-i?1:0},O:function(){var e=n.getTimezoneOffset(),t=Math.abs(e);return(e>0?"-":"+")+u(100*Math.floor(t/60)+t%60,4)},P:function(){var e=r.O();return e.substr(0,3)+":"+e.substr(3,2)},T:function(){return"UTC"},Z:function(){return 60*-n.getTimezoneOffset()},c:function(){return"Y-m-d\\TH:i:sP".replace(a,o)},r:function(){return"D, d M Y H:i:s O".replace(a,o)},U:function(){return n/1e3|0}};var s=function(e,t){return n=void 0===t?new Date:t instanceof Date?new Date(t):new Date(1e3*Math.floor(t)),e.replace(a,o)};return s(e,t)}var o=n("d722");function u(e,t){return e||t}t["a"]={checkRemote:function(e,t,n){var i={table:e.module,checktype:e.checktype,col:e.col};"update"==e.checktype&&(i.id=e.id),i[e.col]=t,r["a"].post(o["a"].checkField,i).then((function(e){e?n():n(new Error("内容重复了"))}))},checkCard:function(e,t,n,r,a){Object(i["c"])(t)||/^[1-9]([0-9]{14}|[0-9]{17})$/.test(t)?n():n(new Error(a.message?a.message:"请输入一个正确的身份证号"))},checkPhone:function(e,t,n,r,a){Object(i["c"])(t)||/^[0-9]{11}$/.test(t)?n():n(new Error(u(a.message,"请输入一个正确的手机号码")))},checkTel:function(e,t,n,r,a){Object(i["c"])(t)||/^[+]{0,1}(\d){1,4}[ ]{0,1}([-]{0,1}((\d)|[ ]){1,12})+$/.test(t)?n():n(new Error(u(a.message,"请输入正确的固定电话号码")))},checkMin:function(e,t,n,r,a){Object(i["c"])(t)&&0!==t||t>=e.value?n():n(new Error(u(a.message,"请输入不小于"+e.value+"值")))},checkMax:function(e,t,n,r,a){Object(i["c"])(t)&&0!==t||t<=e.value?n():n(new Error(u(a.message,"请输入不大于"+e.value+"值")))},checkMinlength:function(e,t,n,r,i){""==t||t.length>=e.value?n():n(new Error(u(i.message,"字符不小于"+e.value+"个字符")))},checkMaxlength:function(e,t,n,r,i){""==t||t.length<=e.value?n():n(new Error(u(i.message,"字符不大于"+e.value+"个字符")))},checkNumber:function(e,t,n,r,a){Object(i["c"])(t)||/^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(t)?n():n(new Error(a.message?a.message:"请输入一个有效数字"))},getID:function(){return a("mdHi")+Math.floor(1e4*Math.random())},date:a}},fcb6:function(e,t,n){"use strict";n("94ab")}}]);