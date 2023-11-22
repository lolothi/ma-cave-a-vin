<template>
    <div class="flex flex-row items-center bg-blue-3 rounded-lg p-4 my-1 shadow-md mx-2">
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