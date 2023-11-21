<template>
    <header class="bg-blue-2">
        <nav class="flex justify-between p-2" aria-label="Global">
          <div class="flex justify-between">
            <router-link to="/"><div class="flex mr-10"><img src="../assets/Wine_Glass_32.png"><strong>Ma cave à Vin</strong></div></router-link>
            <div class="hidden md:block" id="navbar-default">
              <ul class="flex flex-row">
                <li v-for="link in navBarLinks" :key="link.to">
                  <router-link :class=styleLinks(link.to) :to="link.to">{{ link.label }}</router-link>
                </li>
              </ul>
            </div>
          </div>
          <button @click="toggleMenu()" type="button" class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
            <svg class="w-5 h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 1h15M1 7h15M1 13h15"/>
            </svg>
        </button>        
        </nav>
        <!-- hamburger Menu -->
        <nav v-if="isMobile && isMenuOpen">
          <div class="md:hidden" id="navbar-default">
              <ul class="flex flex-col">
                <li v-for="link in navBarLinks" :key="link.to">
                  <router-link :class=styleLinks(link.to) :to="link.to">{{ link.label }}</router-link>
                </li>
              </ul>
            </div>
        </nav>

      </header>
</template>
<script setup lang="ts">
import { onMounted, ref, watch } from 'vue'; 
import { useRoute } from 'vue-router';

const route = useRoute();
const routeParams = ref(route.params)
const navBarLinks = ref([
    {to:"/ma-cave", label:"Ma cave"}, 
    {to:"/mon-vin", label:"Mes vins"},
    // {to:"/vin", label:"Vin"}
])

const isMobile = ref(window.innerWidth <= 768);
let isMenuOpen = ref(false);

function toggleMenu() {
    isMenuOpen.value = !isMenuOpen.value
}

// const handleMouseLeave = () => {
//   isMenuOpen.value = false
//     };

watch(
  () => route.params,
  (newParams) => {
    routeParams.value = newParams;
  }
);
onMounted(() => {
    routeParams.value = route.params;
})

//to change the link style when the page of the link is displayed
const styleLinks = (linkTo: any) => {
    if (linkTo == route.path) {
        return `block mx-2 text-sm font-bold leading-6 text-white hover:text-red-800`;
    }
    return `block mx-2 text-sm font-semibold leading-6 text-blue-1 hover:text-red-800`;
}

</script>