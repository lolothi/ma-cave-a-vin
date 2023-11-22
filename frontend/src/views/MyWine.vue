<template>
  <div class="w-full" v-if="wines">
    <div v-for="wine in wines" :key="wine.wine_id">
      <router-link :to="{ name: 'MyWineDetails', params: { id: wine.wine_id } }">
        <wineBottle :wine="wine" />
      </router-link>
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref, onMounted } from "vue";
import { Wine } from "../classes/WineClass";
import wineBottle from "../components/bottle.vue";
import MyWineService from "../service/MyWineService.ts";

const wines = ref<Wine[] | null>(null);

onMounted(async () => {
  try {
    wines.value = await MyWineService.getWines();
  } catch (error) {
    console.error("Erreur lors du chargement des données :", error);
  }
});
</script>
