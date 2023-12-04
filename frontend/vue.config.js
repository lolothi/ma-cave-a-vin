import vue from "@vitejs/plugin-vue";

module.exports = {
  server: {
    proxy: {
      "/api": {
        target: "http://localhost:9000",
        //target: "http://192.168.1.37:9000",
        changeOrigin: true,
        ws: true, 
        secure: false,
        rewrite: (path) => path.replace(/^\/api/, ""),
      },
    },
  },
  plugins: [vue()],
};
