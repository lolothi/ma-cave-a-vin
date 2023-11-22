<template>
    <h1>ACCUEIL</h1>
    <button class="button" @click="count++">count is: {{ count }}</button>
</template>
  
<script lang="ts">
import wineData from "../service/WineService.ts";


  export default {
    name: 'Accueil',
    props: {
    },
    data() {
      return {
        count: 0
      }
    },
    mounted(){
      const wines = wineData.getWines()
      for (let nbre = 0; nbre < wines.length; nbre++ )
      console.log(wines[nbre].name)
      
    }
  }
</script>