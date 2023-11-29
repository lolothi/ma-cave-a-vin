<template>
    <div class="flex flex-row items-center bg-blue-3 rounded-lg p-2 my-1 shadow-md mx-2">
      <div v-if="wine?.type=='RED'" class="circle mx-1" :style="{ background: '#900C3F' }"></div>
      <div v-if="wine?.type=='WHITE'" class="circle mx-1" :style="{ background: '#fffad9' }"></div>
      <div class="text-lg font-semibold mr-4">{{ wine?.name }}</div>
      <div class="text-base text-gray-600">{{ wine?.available_year }}</div>
    </div>
  </template>
<script setup lang="ts">
import { Wine } from '../classes/WineClass';

defineProps({
    wine:Wine
})

</script>
<style scoped>
.circle {
  width: 7px;
  height: 7px;
  border-radius: 50%;
  display: inline-block;
}
</style>