<template>
    <div v-for="bottle in bottles">
      <wineBottle :bottle="bottle"/>
    </div>
</template>
<script setup lang="ts">
// import { ref } from 'vue';
import wineBottle from '../components/bottle.vue';
import { getWineData } from '../service/fonctions.ts';

const bottles = getWineData();

</script>