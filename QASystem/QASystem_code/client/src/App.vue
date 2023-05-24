<template>
  <ChatGPT/>
</template>

<script>
import ChatGPT from './components/ChatGPT.vue'
export default {
  name: 'App',
  components: {
    ChatGPT
  }
}
</script>

<style>
.ChatGPT {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
#building{
  background:url("D:\2023\CNCulturalRelicOnline\QASystem\QASystem_code\client\public\index.html");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}

</style>
