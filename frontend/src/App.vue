<template>
  <div class="flex flex-col h-screen">
    <Navbar />
    <div class="flex items-center flex-grow flex-col bg-blue-4">
      <router-view />
    </div>
  </div>
</template>
<script setup lang="ts">
import Navbar from "./components/Navbar.vue";
</script>
<style scoped></style>
