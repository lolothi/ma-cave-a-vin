<template>
  <form @submit.prevent="FormSubmitWine">
    <p><label for="name"><strong>Nom* :</strong></label>
      <input v-model="form.name" type="text" id="name" />
    </p>
    <!-- <label for="bottlesNumber">Nombre bouteilles :</label>
      <input v-model="bottlesNumber" type="number" id="bottlesNumber" /> -->
    <p><label for="available_year"><strong>Année :</strong></label> <input v-model="form.available_year" type="text"
        id="available_year" /></p>
    <p><label for="type"><strong>Type :</strong></label><input v-model="form.type" type="text" id="type" /></p>
    <p><label for="country"><strong>Pays :</strong></label><input v-model="form.country" type="text" id="country" /></p>
    <p><label for="producer"><strong>producteur :</strong></label><input v-model="form.producer" type="text"
        id="producer" /></p>
    <p><label for="variety"><strong>Cépage :</strong></label><input v-model="form.variety" type="text" id="variety" /></p>
    <p><label for="designation"><strong>Appelation :</strong></label><input v-model="form.designation" type="text"
        id="designation" /></p>
    <p><label for="ean"><strong>EAN :</strong></label><input v-model="form.ean" type="text" id="ean" /></p>
    <p><label for="quantity_tot"><strong>Quantité :</strong></label><input v-model="form.quantity_tot" type="text"
        id="quantity_tot" /></p>
    <p><label for="with_food"><strong>Accompagnements :</strong></label><input v-model="form.with_food" type="text"
        id="with_food" /></p>
    <p><strong>Lien img :</strong></p>


    <button type="submit">
      <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" version="1.1" viewBox="0 0 32 32">
        <circle style="fill: #252a35" cx="16" cy="16" r="14" />
        <rect style="fill: #ffffff" width="4" height="20" x="-18" y="6" transform="matrix(0,-1,1,0,0,0)" />
        <rect style="fill: #ffffff" width="4" height="20" x="14" y="6" />
      </svg>
    </button>
  </form>
</template>
<script setup lang="ts">
import { ref } from "vue";

const form = ref({
  name: '',
  available_year: '',
  type: '1',
  country: '',
  producer: '',
  variety: '',
  designation: '',
  ean: '',
  picture_link: '',
  with_food: '',
  note: null,
  comments: null,
  tag: '',
  quantity_tot: '',
  quantity_in_wine_cellar: null,

})

const emit = defineEmits(['form-submit'])

function FormSubmitWine() {
  emit('form-submit', form.value)
};
</script>
