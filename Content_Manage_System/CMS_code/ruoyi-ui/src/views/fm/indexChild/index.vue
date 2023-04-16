<template>
<div>
  <Banner/>
  <Search/>
  <IndexMain/>
  <Footer/>
</div>
</template>

<script>
import Search from '@/views/fm/components/Search'
import Banner from '@/views/fm/components/Banner'
import IndexMain from '@/views/fm/indexChild/main'
import Footer from '@/views/fm/components/Footer'

export default {
  name: 'Index',
  components: { Footer, IndexMain, Banner, Search },
}
</script>

<style scoped>

</style>
