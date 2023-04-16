<template>
  <el-row type="flex" justify="center">
<!--    <el-col :span="leftSpan">-->
<!--      <slot name="left"></slot>-->
<!--    </el-col>-->
    <el-col :span="span">
      <slot></slot>
    </el-col>
    <el-col :span="rightSpan">
      <slot name="right"></slot>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'MyContainer',
  props: {
    span: {
      type: Number,
      default: 18
    },
    leftSpan: {
      type: Number,
      default: 0
    },
    rightSpan: {
      type: Number,
      default: 0
    }
  }
}
</script>

<style scoped>

</style>
