<template>
    <div><h1>Ajouter du vin</h1></div>
    <newBottleForm @form-submit="addNewBottleForm"/>
</template>
  
<script setup lang="ts">
import { ref } from 'vue';
import newBottleForm from '../components/newBottleForm.vue';
import axios from 'axios';
import {Wine} from '../classes/WineClass.ts';

const submittedData = ref(null)

const addNewBottleForm = async (formData:Wine) => {
  // submittedData.value = formData
  console.log("TOP", JSON.stringify(submittedData.value));

  //fonctionnel !!
  try {
      console.log("TRY");
      const response = await axios.post("/api/wine", JSON.stringify(formData), {
        headers: {
          'Content-Type': 'application/json'
        }});
        console.log("TRY-ok", response.data);
    } catch (error: unknown) {
      console.log("EEERRRRRROOOORR");
        throw error;
    }

};

</script>