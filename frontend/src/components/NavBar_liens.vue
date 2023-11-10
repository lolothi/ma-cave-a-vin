<template>
    <div class="hidden w-full md:block md:w-auto" id="navbar-default">
        <ul class="flex flex-row">
            <li v-for="link in navBarLinks" :key="link.to">
                <router-link :class=styleLinks(link.to) :to="link.to">{{ link.label }}</router-link>
            </li>
        </ul>
    </div>
</template>
<script setup lang="ts">
import { onMounted, ref, watch } from 'vue'; 
import { useRoute } from 'vue-router';

const route = useRoute();
const routeParams = ref(route.params)
const navBarLinks = ref([
    {to:"/ma-cave", label:"Ma cave"}, 
    {to:"/mon-vin", label:"Mes vins"},
    {to:"/vin", label:"Vin"}
])

//to do
defineProps({
    mobileDisplay: Boolean
})

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
