<template>
    <div class="w-full" v-for="bottle in bottles" key="bottle.id">
      <router-link :to="{ name: 'WineDetails', params:{ id: bottle.id}}">
        <wineBottle :bottle="bottle"/>
      </router-link>
      
    </div>
</template>
<script setup lang="ts">
// import { ref } from 'vue';
import wineBottle from '../components/bottle.vue';
import wineData from '../service/WineService.ts';

const bottles = wineData.getWines();

</script>