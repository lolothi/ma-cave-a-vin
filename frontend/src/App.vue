<script setup lang="ts">
import Navbar from './components/Navbar.vue'

</script>

<template>
      <div class="flex flex-col h-screen">
      <Navbar class="mb-1"/>
      <!-- <div class="flex justify-center items-center flex-grow flex-col bg-blue-4"> -->
      <div class="flex items-center flex-grow flex-col bg-blue-4">
        <router-view/>
      </div>
    </div>  
</template>

<style scoped>

</style>
