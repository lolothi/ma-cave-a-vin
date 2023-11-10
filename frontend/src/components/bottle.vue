<template>
    <div class="bg-white rounded-lg p-4 my-1 shadow-md">
      <div class="text-lg font-semibold mb-2">{{ bottle?.name }}</div>
      <div class="text-gray-600">{{ bottle?.year }}</div>
    </div>
  </template>
<script setup lang="ts">
defineProps({
    bottle:Object
})
</script>