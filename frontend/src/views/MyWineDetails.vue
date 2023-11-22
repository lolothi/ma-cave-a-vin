<template>
    <div class="container mx-auto my-1">
      <div class="bg-blue-3 rounded-lg p-8 shadow-md">

        <h1 class="text-3xl font-semibold mb-4">{{ wine?.name }}</h1>
        <div>
          <p><strong>Année :</strong> {{ wine?.available_year }}</p>
          <p><strong>Type :</strong> {{ wine?.type }}</p>
          <p><strong>Pays :</strong> {{ wine?.country }}</p>
          <p><strong>EAN :</strong> {{ wine?.ean }}</p>
          <p><strong>Commentaires :</strong> {{ wine?.comments }}</p>
        </div>
      </div>
    </div>
  </template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import MyWineService from '../service/MyWineService.ts';
import { Wine } from '../classes/WineClass.ts'

const route = useRoute();
const wineId = ref(Number(route.params.id));
const wine = ref<Wine | null>(null);

onMounted(async () => {
  try {
      wine.value = await MyWineService.getOneWine(wineId.value); 
  } catch (error) {
    console.error('Erreur lors de la récupération des détails du vin', error);
  }
});


</script>