(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-befea5d4"],{"628c":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"lunbotu-add"},[n("el-card",{staticClass:"box-card"},[n("div",{staticClass:"clearfix updt",attrs:{slot:"header"},slot:"header"},[n("el-page-header",{attrs:{content:"编辑轮播图"},on:{back:function(t){return e.$router.go(-1)}}})],1),n("div",{staticClass:"form-database-form"},[n("el-form",{ref:"formModel",attrs:{model:e.form,"label-width":"130px","status-icon":"","validate-on-rule-change":""}},[n("el-form-item",{attrs:{label:"标题",prop:"title",required:"",rules:[{required:!0,message:"请填写标题"}]}},[n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"输入标题"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),n("el-form-item",{attrs:{label:"图片",prop:"image",required:"",rules:[{required:!0,message:"请填写图片"}]}},[n("e-upload-image",{model:{value:e.form.image,callback:function(t){e.$set(e.form,"image",t)},expression:"form.image"}})],1),n("el-form-item",{attrs:{label:"连接地址",prop:"url",required:"",rules:[{required:!0,message:"请填写连接地址"}]}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入连接地址"},model:{value:e.form.url,callback:function(t){e.$set(e.form,"url",t)},expression:"form.url"}})],1),e.btnText?n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.submit}},[e._v(e._s(e.btnText))])],1):e._e()],1)],1)])],1)},o=[],a=(n("a9e3"),n("d722")),u=n("b39c"),i=n("efff"),c={name:"lunbotu-add",data:function(){return{rule:u["a"],loading:!1,form:{title:"",image:"",url:""}}},watch:{id:{handler:function(){this.loadInfo()}}},props:{isRead:{type:Boolean,default:!0},btnText:{type:String,default:"提交"},id:{type:[String,Number],required:!0}},computed:{},methods:{submit:function(){var e=this;this.$refs.formModel.validate().then((function(t){if(!e.loading){e.loading=!0;var n=e.form;e.$post(a["a"].lunbotu.update,n).then((function(t){e.loading=!1,t.code==a["a"].code.OK?(e.$message.success("添加成功"),e.$emit("success",t.data),e.$refs.formModel.resetFields(),e.loadInfo()):e.$message.error(t.msg)})).catch((function(t){e.loading=!1,e.$message.error(t.message)}))}})).catch((function(e){console.log(e.message)}))},loadInfo:function(){var e=this;this.loading=!0;this.form;this.$post(a["a"].lunbotu.edit,{id:this.id}).then((function(t){e.loading=!1,t.code==a["a"].code.OK?(Object(i["d"])(e,t.data),e.form=t.data.mmm):(e.$message.error(t.msg),e.$router.go(-1))})).catch((function(t){e.$message.error(t.message),e.$router.go(-1)}))}},created:function(){this.loadInfo()},mounted:function(){},destroyed:function(){}},s=c,l=(n("d67a"),n("2877")),f=Object(l["a"])(s,r,o,!1,null,"9aa3d688",null);t["default"]=f.exports},"764e":function(e,t,n){},b39c:function(e,t,n){"use strict";n("ac1f"),n("00b4");var r=n("0499"),o=n("efff");n("fb6a"),n("d3b7"),n("25f0"),n("5319");function a(e,t){var n,r,o=["Sun","Mon","Tues","Wednes","Thurs","Fri","Satur","January","February","March","April","May","June","July","August","September","October","November","December"],a=/\\?(.?)/gi,u=function(e,t){return r[e]?r[e]():t},i=function(e,t){e=String(e);while(e.length<t)e="0"+e;return e};r={d:function(){return i(r.j(),2)},D:function(){return r.l().slice(0,3)},j:function(){return n.getDate()},l:function(){return o[r.w()]+"day"},N:function(){return r.w()||7},S:function(){var e=r.j(),t=e%10;return t<=3&&1==parseInt(e%100/10,10)&&(t=0),["st","nd","rd"][t-1]||"th"},w:function(){return n.getDay()},z:function(){var e=new Date(r.Y(),r.n()-1,r.j()),t=new Date(r.Y(),0,1);return Math.round((e-t)/864e5)},W:function(){var e=new Date(r.Y(),r.n()-1,r.j()-r.N()+3),t=new Date(e.getFullYear(),0,4);return i(1+Math.round((e-t)/864e5/7),2)},F:function(){return o[6+r.n()]},m:function(){return i(r.n(),2)},M:function(){return r.F().slice(0,3)},n:function(){return n.getMonth()+1},t:function(){return new Date(r.Y(),r.n(),0).getDate()},L:function(){var e=r.Y();return e%4===0&e%100!==0|e%400===0},o:function(){var e=r.n(),t=r.W(),n=r.Y();return n+(12===e&&t<9?1:1===e&&t>9?-1:0)},Y:function(){return n.getFullYear()},y:function(){return r.Y().toString().slice(-2)},a:function(){return n.getHours()>11?"pm":"am"},A:function(){return r.a().toUpperCase()},B:function(){var e=3600*n.getUTCHours(),t=60*n.getUTCMinutes(),r=n.getUTCSeconds();return i(Math.floor((e+t+r+3600)/86.4)%1e3,3)},g:function(){return r.G()%12||12},G:function(){return n.getHours()},h:function(){return i(r.g(),2)},H:function(){return i(r.G(),2)},i:function(){return i(n.getMinutes(),2)},s:function(){return i(n.getSeconds(),2)},u:function(){return i(1e3*n.getMilliseconds(),6)},e:function(){throw"Not supported (see source code of date() for timezone on how to add support)"},I:function(){var e=new Date(r.Y(),0),t=Date.UTC(r.Y(),0),n=new Date(r.Y(),6),o=Date.UTC(r.Y(),6);return e-t!==n-o?1:0},O:function(){var e=n.getTimezoneOffset(),t=Math.abs(e);return(e>0?"-":"+")+i(100*Math.floor(t/60)+t%60,4)},P:function(){var e=r.O();return e.substr(0,3)+":"+e.substr(3,2)},T:function(){return"UTC"},Z:function(){return 60*-n.getTimezoneOffset()},c:function(){return"Y-m-d\\TH:i:sP".replace(a,u)},r:function(){return"D, d M Y H:i:s O".replace(a,u)},U:function(){return n/1e3|0}};var c=function(e,t){return n=void 0===t?new Date:t instanceof Date?new Date(t):new Date(1e3*Math.floor(t)),e.replace(a,u)};return c(e,t)}var u=n("d722");function i(e,t){return e||t}t["a"]={checkRemote:function(e,t,n){var o={table:e.module,checktype:e.checktype,col:e.col};"update"==e.checktype&&(o.id=e.id),o[e.col]=t,r["a"].post(u["a"].checkField,o).then((function(e){e?n():n(new Error("内容重复了"))}))},checkCard:function(e,t,n,r,a){Object(o["c"])(t)||/^[1-9]([0-9]{14}|[0-9]{17})$/.test(t)?n():n(new Error(a.message?a.message:"请输入一个正确的身份证号"))},checkPhone:function(e,t,n,r,a){Object(o["c"])(t)||/^[0-9]{11}$/.test(t)?n():n(new Error(i(a.message,"请输入一个正确的手机号码")))},checkTel:function(e,t,n,r,a){Object(o["c"])(t)||/^[+]{0,1}(\d){1,4}[ ]{0,1}([-]{0,1}((\d)|[ ]){1,12})+$/.test(t)?n():n(new Error(i(a.message,"请输入正确的固定电话号码")))},checkMin:function(e,t,n,r,a){Object(o["c"])(t)&&0!==t||t>=e.value?n():n(new Error(i(a.message,"请输入不小于"+e.value+"值")))},checkMax:function(e,t,n,r,a){Object(o["c"])(t)&&0!==t||t<=e.value?n():n(new Error(i(a.message,"请输入不大于"+e.value+"值")))},checkMinlength:function(e,t,n,r,o){""==t||t.length>=e.value?n():n(new Error(i(o.message,"字符不小于"+e.value+"个字符")))},checkMaxlength:function(e,t,n,r,o){""==t||t.length<=e.value?n():n(new Error(i(o.message,"字符不大于"+e.value+"个字符")))},checkNumber:function(e,t,n,r,a){Object(o["c"])(t)||/^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(t)?n():n(new Error(a.message?a.message:"请输入一个有效数字"))},getID:function(){return a("mdHi")+Math.floor(1e4*Math.random())},date:a}},d67a:function(e,t,n){"use strict";n("764e")}}]);