<template>
    <div>{{ wines?.length }} bouteilles dans ma cave.</div>
    <newWineBottle/>
</template>
  
<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { Wine } from '../classes/WineClass.ts';
import MyWineService from '../service/MyWineService.ts';
import newWineBottle from '../components/newBottle.vue';

const wines = ref<Wine[] | null>(null);

onMounted(async () => {
  try {
    wines.value = await MyWineService.getWines();
  } catch (error) {
    console.error("Erreur lors du chargement des données :", error);
  }
});
</script>