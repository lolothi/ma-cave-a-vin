<template>
    <header class="bg-blue-2">
        <nav class="mx-auto flex justify-between p-2" aria-label="Global">
          <div class="flex lg:flex-1">
            <router-link to="/"><div class="flex mr-10"><img src="../assets/Wine_Glass_32.png"><strong>Ma cave à Vin</strong></div></router-link>
            <NavBarLinks :mobileDisplay="mobileDisplay"/>
          </div>
          <button data-collapse-toggle="navbar-default" type="button" class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-default" aria-expanded="false">
            <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 1h15M1 7h15M1 13h15"/>
            </svg>
        </button>
          
        </nav>
      </header>
</template>
<script setup lang="ts">
import NavBarLinks from './NavBar_liens.vue'
import { ref } from 'vue'

let mobileDisplay = ref (false)

</script>