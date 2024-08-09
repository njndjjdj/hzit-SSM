const { defineConfig } = require('@vue/cli-service')
module.exports = {
  devServer: {
    open: process.platform === 'darwin',
    host: 'localhost',//如果是真机测试，就使用这个IP
    port: 8080,         //这里修改端口
    https: false,
    //处理跨域请求
    proxy: {
      // 下面的配置会转换路径由http://localhost:8080/api/student 转换成---->http://localhost:9000/student
      "/api": {    //当我们访问以/api开头的地址就转发到http://localhost:9000上去
        target: "http://localhost:9000", //跨域网址
        secure: false, // 如果是https接口，需要配置这个参数
        changeOrigin: true, //自动修改http header里面的host
        pathRewrite: {
          "^/api": "", //路径的替换规则,代表路径中/api开头的路径替换成''
        }
      }
    }
  },
  transpileDependencies: true,
  lintOnSave: false,
}
