<template>
    <h1>ACCUEIL</h1>
    <button class="button" @click="count++">count is: {{ count }}</button>
</template>
  
<script>
  export default {
    name: 'Accueil',
    props: {
    },
    data() {
      return {
        count: 0
      }
    }
  }
</script>