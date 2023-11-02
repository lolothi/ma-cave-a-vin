<template>
    <Ban/>
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <HelloWorld msg="Hello" />
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Ban from './components/ban.vue';

export default {
  name: 'App',
  components: {
    HelloWorld,
    Ban
}
}
</script>
