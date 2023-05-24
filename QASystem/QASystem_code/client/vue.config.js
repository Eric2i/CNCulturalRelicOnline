const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
module.export = {
  devServer: {
    proxy: {
        '^/api': {
            target: 'http://localhost:8099',
            changOrigin: true,
            pathRewrite: {
                '^/api': ''
            }
        }
    }
  }
}
