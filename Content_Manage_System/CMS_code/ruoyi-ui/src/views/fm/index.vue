<template>
  <div>
    <Nav/>
    <router-view/>
  </div>
</template>

<script>
import Nav from "@/views/fm/components/Nav";

export default {
  name: 'fmIndex',
  components: { Nav },
  created() {
  },
}
</script>

<!-- 样式 -->
<style scoped>
</style>
