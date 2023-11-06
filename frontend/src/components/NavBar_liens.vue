<template>
    <div class="hidden w-full md:block md:w-auto" id="navbar-default">
        <ul class="flex flex-row">
            <li><router-link class="block mx-2 text-sm font-semibold leading-6 text-blue-1 hover:text-red-800" to="/ma-cave">Ma cave</router-link></li>
            <li><router-link class="block mx-2 text-sm font-semibold leading-6 text-blue-1 hover:text-red-800" to="/mon-vin">Mes vins</router-link></li>
            <li><router-link class="block mx-2 text-sm font-semibold leading-6 text-blue-1 hover:text-red-800" to="/vin">Vin</router-link></li>
        </ul>
    </div>
</template>
<script setup lang="ts">
defineProps({
    mobileDisplay: Boolean
})


</script>
