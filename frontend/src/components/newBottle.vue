<template>
    <div>Ajout rapide</div>
    <form @submit.prevent="addNewBottle">
      <label for="name">Nom :</label>
      <input v-model="name" type="text" id="name" />
      <!-- <label for="bottlesNumber">Nombre bouteilles :</label>
      <input v-model="bottlesNumber" type="number" id="bottlesNumber" /> -->
      <button type="submit">Ajouter</button>
    </form>
</template>
<script setup lang="ts">
import { ref } from 'vue';
import MyWineService from '../service/MyWineService.ts';

const name = ref('');
// const bottlesNumber = ref(0)

const addNewBottle = async () => {
    // const bottle = { 'name': name.value, 'bottlesNumber': bottlesNumber.value};
    const bottle = { 'name': name.value};
    MyWineService.addWine(bottle);
 }
</script>