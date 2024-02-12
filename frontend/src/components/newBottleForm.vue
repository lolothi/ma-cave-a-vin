<template>
  <form @submit.prevent="FormSubmitWine" class="max-w-lg mx-auto mt-8">
    <div class="mb-4">
      <label for="name" class="block text-sm font-semibold text-gray-700">Nom* :</label>
      <input v-model="form.name" type="text" id="name" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="available_year" class="block text-sm font-semibold text-gray-700">Année* :</label>
      <input v-model="form.available_year" type="text" id="available_year" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="type" class="block text-sm font-semibold text-gray-700">Type :</label>
      <input v-model="form.type" type="text" id="type" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="country" class="block text-sm font-semibold text-gray-700">Pays :</label>
      <input v-model="form.country" type="text" id="country" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>

    <div class="mb-4">
      <label for="producer" class="block text-sm font-semibold text-gray-700">producteur :</label>
      <input v-model="form.producer" type="text" id="producer" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="variety" class="block text-sm font-semibold text-gray-700">Cépage :</label>
      <input v-model="form.variety" type="text" id="variety" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="designation" class="block text-sm font-semibold text-gray-700">Appelation :</label>
      <input v-model="form.designation" type="text" id="designation" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="ean" class="block text-sm font-semibold text-gray-700">EAN :</label>
      <input v-model="form.ean" type="text" id="ean" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="quantity_tot" class="block text-sm font-semibold text-gray-700">Quantité :</label>
      <input v-model="form.quantity_tot" type="text" id="quantity_tot" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="with_food" class="block text-sm font-semibold text-gray-700">Accompagnements :</label>
      <input v-model="form.with_food" type="text" id="with_food" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
    </div>
    <div class="mb-4">
      <label for="image" class="block text-sm font-semibold text-gray-700">Image :</label>
      <input type="file" id="image" accept="image/*" @change="handleImageUpload" class="form-input mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
      <img v-if="imageUrl" :src="imageUrl" alt="Selected Image" class="mt-2 max-w-xs" />
    </div>

    <div class="mb-4">
      <button type="submit" class="flex items-center px-4 py-2 bg-indigo-600 border border-transparent rounded-md font-semibold text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
        <span>Envoyer</span>
        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 ml-2" viewBox="0 0 20 20" fill="currentColor">
          <path fill-rule="evenodd" d="M10 3a1 1 0 0 1 1 1v3.586l3.293-3.293a1 1 0 1 1 1.414 1.414l-5 5a1 1 0 0 1-1.414 0l-5-5a1 1 0 1 1 1.414-1.414L9 7.586V4a1 1 0 0 1 1-1z" clip-rule="evenodd" />
          <path fill-rule="evenodd" d="M4 10a1 1 0 0 1 1-1h3.586l-3.293-3.293a1 1 0 1 1 1.414-1.414l5 5a1 1 0 0 1 0 1.414l-5 5a1 1 0 1 1-1.414-1.414L7.586 11H5a1 1 0 0 1-1-1z" clip-rule="evenodd" />
        </svg>
      </button>
    </div>
  </form>
</template>
<script setup lang="ts">
import { ref } from "vue";

const form = ref({
  name: '',
  available_year: '',
  type: 'RED',
  country: '',
  producer: '',
  variety: '',
  designation: '',
  ean: '',
  picture_link: '',
  with_food: '',
  note: null,
  comments: null,
  tag: '',
  quantity_tot: '',
  quantity_in_wine_cellar: null,
  image: null, 
})

const emit = defineEmits(['form-submit']);
const imageUrl = ref('');

function FormSubmitWine() {
  emit('form-submit', form.value)
};

const handleImageUpload = (event:any) => {
  const file = event.target.files[0];
  if (file) {
    form.value.image = file;
    imageUrl.value = URL.createObjectURL(file);
  }
}
</script>
