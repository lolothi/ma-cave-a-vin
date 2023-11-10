<template>
    <div class="flex flex-row items-center bg-blue-3 rounded-lg p-4 my-1 shadow-md mx-2">
      <div class="text-lg font-semibold mr-4">{{ bottle?.name }}</div>
      <div class="text-base text-gray-600">{{ bottle?.year }}</div>
    </div>
  </template>
<script setup lang="ts">
defineProps({
    bottle:Object
})
</script>