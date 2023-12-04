<template>
  <div>Ajout rapide</div>
  <form @submit.prevent="addNewBottle">
    <label for="name">Nom :</label>
    <input v-model="name" type="text" id="name" />
    <!-- <label for="bottlesNumber">Nombre bouteilles :</label>
      <input v-model="bottlesNumber" type="number" id="bottlesNumber" /> -->
    <button type="submit">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="32"
        height="32"
        version="1.1"
        viewBox="0 0 32 32"
      >
        <circle style="fill: #252a35" cx="16" cy="16" r="14" />
        <rect
          style="fill: #ffffff"
          width="4"
          height="20"
          x="-18"
          y="6"
          transform="matrix(0,-1,1,0,0,0)"
        />
        <rect style="fill: #ffffff" width="4" height="20" x="14" y="6" />
      </svg>
    </button>
  </form>
</template>
<script setup lang="ts">
import { ref } from "vue";
import MyWineService from "../service/MyWineService.ts";

const name = ref("");
// const bottlesNumber = ref(0)

const addNewBottle = async () => {
  // const bottle = { 'name': name.value, 'bottlesNumber': bottlesNumber.value};
  const bottle = { name: name.value };
  MyWineService.addWine(bottle);
};
</script>
