<template>
    <header class="bg-cyan-200">
        <nav class="mx-auto flex justify-between p-2" aria-label="Global">
          <div class="flex lg:flex-1">
            <div class="flex mr-10"><img src="../assets/Wine_Glass_32.png"><strong>Ma cave à Vin</strong></div>
            <router-link to="/">Accueil</router-link>
            <router-link to="/vin">Vin</router-link>
            <router-link to="/mon-vin">Mes vins</router-link>
            <router-link to="/ma-cave">Ma cave</router-link>
            <!-- <a href="#" class="mx-2 text-sm font-semibold leading-6 text-gray-900">Vin</a>
            <a href="#" class="mx-2 text-sm font-semibold leading-6 text-gray-900">Mes vins</a>
            <a href="#" class="mx-2 text-sm font-semibold leading-6 text-gray-900">Ma cave</a> -->
          </div>
        </nav>
      </header>
    </template>