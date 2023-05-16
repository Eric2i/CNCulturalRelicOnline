(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-50461d67"],{"33de":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"lvyouxianlu-add"},[n("el-card",{staticClass:"box-card"},[n("div",{staticClass:"clearfix updt",attrs:{slot:"header"},slot:"header"},[n("el-page-header",{attrs:{content:"编辑旅游线路"},on:{back:function(t){return e.$router.go(-1)}}})],1),n("div",{staticClass:"form-database-form"},[n("el-form",{ref:"formModel",attrs:{model:e.form,"label-width":"130px","status-icon":"","validate-on-rule-change":""}},[n("el-form-item",{attrs:{label:"线路编号",prop:"xianlubianhao",rules:[{required:!0,message:"请填写线路编号"}]}},[n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"输入线路编号"},model:{value:e.form.xianlubianhao,callback:function(t){e.$set(e.form,"xianlubianhao",t)},expression:"form.xianlubianhao"}})],1),n("el-form-item",{attrs:{label:"线路名称",prop:"xianlumingcheng",required:"",rules:[{required:!0,message:"请填写线路名称"}]}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入线路名称"},model:{value:e.form.xianlumingcheng,callback:function(t){e.$set(e.form,"xianlumingcheng",t)},expression:"form.xianlumingcheng"}})],1),n("el-form-item",{attrs:{label:"图片",prop:"tupian"}},[n("e-upload-images",{model:{value:e.form.tupian,callback:function(t){e.$set(e.form,"tupian",t)},expression:"form.tupian"}})],1),n("el-form-item",{attrs:{label:"出发地",prop:"chufadi"}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入出发地"},model:{value:e.form.chufadi,callback:function(t){e.$set(e.form,"chufadi",t)},expression:"form.chufadi"}})],1),n("el-form-item",{attrs:{label:"途经地",prop:"tujingdi"}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入途经地"},model:{value:e.form.tujingdi,callback:function(t){e.$set(e.form,"tujingdi",t)},expression:"form.tujingdi"}})],1),n("el-form-item",{attrs:{label:"终点",prop:"zhongdian"}},[n("el-input",{staticStyle:{width:"450px"},attrs:{placeholder:"输入终点"},model:{value:e.form.zhongdian,callback:function(t){e.$set(e.form,"zhongdian",t)},expression:"form.zhongdian"}})],1),n("el-form-item",{attrs:{label:"价格",prop:"jiage",required:"",rules:[{required:!0,message:"请填写价格"},{validator:e.rule.checkNumber,message:"输入一个有效数字"}]}},[n("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"输入价格"},model:{value:e.form.jiage,callback:function(t){e.$set(e.form,"jiage",t)},expression:"form.jiage"}})],1),n("el-form-item",{attrs:{label:"线路特色",prop:"xianlutese"}},[n("e-editor",{model:{value:e.form.xianlutese,callback:function(t){e.$set(e.form,"xianlutese",t)},expression:"form.xianlutese"}})],1),n("el-form-item",{attrs:{label:"线路简介",prop:"xianlujianjie"}},[n("e-editor",{model:{value:e.form.xianlujianjie,callback:function(t){e.$set(e.form,"xianlujianjie",t)},expression:"form.xianlujianjie"}})],1),e.btnText?n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.submit}},[e._v(e._s(e.btnText))])],1):e._e()],1)],1)])],1)},a=[],o=(n("a9e3"),n("d722")),i=n("b39c"),u=n("efff"),c={name:"lvyouxianlu-add",data:function(){return{rule:i["a"],loading:!1,form:{xianlubianhao:i["a"].getID(),xianlumingcheng:"",tupian:"",chufadi:"",tujingdi:"",zhongdian:"",jiage:"",xianlutese:"",xianlujianjie:""}}},watch:{id:{handler:function(){this.loadInfo()}}},props:{isRead:{type:Boolean,default:!0},btnText:{type:String,default:"提交"},id:{type:[String,Number],required:!0}},computed:{},methods:{submit:function(){var e=this;this.$refs.formModel.validate().then((function(t){if(!e.loading){e.loading=!0;var n=e.form;e.$post(o["a"].lvyouxianlu.update,n).then((function(t){e.loading=!1,t.code==o["a"].code.OK?(e.$message.success("添加成功"),e.$emit("success",t.data),e.$refs.formModel.resetFields(),e.loadInfo()):e.$message.error(t.msg)})).catch((function(t){e.loading=!1,e.$message.error(t.message)}))}})).catch((function(e){console.log(e.message)}))},loadInfo:function(){var e=this;this.loading=!0;this.form;this.$post(o["a"].lvyouxianlu.edit,{id:this.id}).then((function(t){e.loading=!1,t.code==o["a"].code.OK?(Object(u["d"])(e,t.data),e.form=t.data.mmm):(e.$message.error(t.msg),e.$router.go(-1))})).catch((function(t){e.$message.error(t.message),e.$router.go(-1)}))}},created:function(){this.loadInfo()},mounted:function(){},destroyed:function(){}},l=c,s=(n("c6de"),n("2877")),f=Object(s["a"])(l,r,a,!1,null,"e6106012",null);t["default"]=f.exports},b39c:function(e,t,n){"use strict";n("ac1f"),n("00b4");var r=n("0499"),a=n("efff");n("fb6a"),n("d3b7"),n("25f0"),n("5319");function o(e,t){var n,r,a=["Sun","Mon","Tues","Wednes","Thurs","Fri","Satur","January","February","March","April","May","June","July","August","September","October","November","December"],o=/\\?(.?)/gi,i=function(e,t){return r[e]?r[e]():t},u=function(e,t){e=String(e);while(e.length<t)e="0"+e;return e};r={d:function(){return u(r.j(),2)},D:function(){return r.l().slice(0,3)},j:function(){return n.getDate()},l:function(){return a[r.w()]+"day"},N:function(){return r.w()||7},S:function(){var e=r.j(),t=e%10;return t<=3&&1==parseInt(e%100/10,10)&&(t=0),["st","nd","rd"][t-1]||"th"},w:function(){return n.getDay()},z:function(){var e=new Date(r.Y(),r.n()-1,r.j()),t=new Date(r.Y(),0,1);return Math.round((e-t)/864e5)},W:function(){var e=new Date(r.Y(),r.n()-1,r.j()-r.N()+3),t=new Date(e.getFullYear(),0,4);return u(1+Math.round((e-t)/864e5/7),2)},F:function(){return a[6+r.n()]},m:function(){return u(r.n(),2)},M:function(){return r.F().slice(0,3)},n:function(){return n.getMonth()+1},t:function(){return new Date(r.Y(),r.n(),0).getDate()},L:function(){var e=r.Y();return e%4===0&e%100!==0|e%400===0},o:function(){var e=r.n(),t=r.W(),n=r.Y();return n+(12===e&&t<9?1:1===e&&t>9?-1:0)},Y:function(){return n.getFullYear()},y:function(){return r.Y().toString().slice(-2)},a:function(){return n.getHours()>11?"pm":"am"},A:function(){return r.a().toUpperCase()},B:function(){var e=3600*n.getUTCHours(),t=60*n.getUTCMinutes(),r=n.getUTCSeconds();return u(Math.floor((e+t+r+3600)/86.4)%1e3,3)},g:function(){return r.G()%12||12},G:function(){return n.getHours()},h:function(){return u(r.g(),2)},H:function(){return u(r.G(),2)},i:function(){return u(n.getMinutes(),2)},s:function(){return u(n.getSeconds(),2)},u:function(){return u(1e3*n.getMilliseconds(),6)},e:function(){throw"Not supported (see source code of date() for timezone on how to add support)"},I:function(){var e=new Date(r.Y(),0),t=Date.UTC(r.Y(),0),n=new Date(r.Y(),6),a=Date.UTC(r.Y(),6);return e-t!==n-a?1:0},O:function(){var e=n.getTimezoneOffset(),t=Math.abs(e);return(e>0?"-":"+")+u(100*Math.floor(t/60)+t%60,4)},P:function(){var e=r.O();return e.substr(0,3)+":"+e.substr(3,2)},T:function(){return"UTC"},Z:function(){return 60*-n.getTimezoneOffset()},c:function(){return"Y-m-d\\TH:i:sP".replace(o,i)},r:function(){return"D, d M Y H:i:s O".replace(o,i)},U:function(){return n/1e3|0}};var c=function(e,t){return n=void 0===t?new Date:t instanceof Date?new Date(t):new Date(1e3*Math.floor(t)),e.replace(o,i)};return c(e,t)}var i=n("d722");function u(e,t){return e||t}t["a"]={checkRemote:function(e,t,n){var a={table:e.module,checktype:e.checktype,col:e.col};"update"==e.checktype&&(a.id=e.id),a[e.col]=t,r["a"].post(i["a"].checkField,a).then((function(e){e?n():n(new Error("内容重复了"))}))},checkCard:function(e,t,n,r,o){Object(a["c"])(t)||/^[1-9]([0-9]{14}|[0-9]{17})$/.test(t)?n():n(new Error(o.message?o.message:"请输入一个正确的身份证号"))},checkPhone:function(e,t,n,r,o){Object(a["c"])(t)||/^[0-9]{11}$/.test(t)?n():n(new Error(u(o.message,"请输入一个正确的手机号码")))},checkTel:function(e,t,n,r,o){Object(a["c"])(t)||/^[+]{0,1}(\d){1,4}[ ]{0,1}([-]{0,1}((\d)|[ ]){1,12})+$/.test(t)?n():n(new Error(u(o.message,"请输入正确的固定电话号码")))},checkMin:function(e,t,n,r,o){Object(a["c"])(t)&&0!==t||t>=e.value?n():n(new Error(u(o.message,"请输入不小于"+e.value+"值")))},checkMax:function(e,t,n,r,o){Object(a["c"])(t)&&0!==t||t<=e.value?n():n(new Error(u(o.message,"请输入不大于"+e.value+"值")))},checkMinlength:function(e,t,n,r,a){""==t||t.length>=e.value?n():n(new Error(u(a.message,"字符不小于"+e.value+"个字符")))},checkMaxlength:function(e,t,n,r,a){""==t||t.length<=e.value?n():n(new Error(u(a.message,"字符不大于"+e.value+"个字符")))},checkNumber:function(e,t,n,r,o){Object(a["c"])(t)||/^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(t)?n():n(new Error(o.message?o.message:"请输入一个有效数字"))},getID:function(){return o("mdHi")+Math.floor(1e4*Math.random())},date:o}},c6de:function(e,t,n){"use strict";n("cb77")},cb77:function(e,t,n){}}]);