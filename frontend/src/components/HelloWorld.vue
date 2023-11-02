<template>
  <h1>ACCUEIL:</h1>
  <h2>{{ msg }}</h2>
  <button class="button" @click="count++">count is: {{ count }}</button>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      count: 0
    }
  }
}
</script>
