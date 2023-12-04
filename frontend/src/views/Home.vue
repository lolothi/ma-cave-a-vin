<template>
  <div>{{ wines?.length }} bouteilles dans ma cave.</div>
  <router-link to="/vin/nouveau">
    <div class="flex mr-10">
      <strong>Ajouter du vin</strong>
    </div>
  </router-link>
</template>
  
<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { Wine } from '../classes/WineClass.ts';
import MyWineService from '../service/MyWineService.ts';

const wines = ref<Wine[] | null>(null);

onMounted(async () => {
  try {
    wines.value = await MyWineService.getWines();
  } catch (error) {
    console.error("Erreur lors du chargement des données :", error);
  }
});

</script>