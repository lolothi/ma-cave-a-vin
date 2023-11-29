<template>
  <div class="container mx-auto my-1">
    <div class="bg-blue-3 rounded-lg p-4 shadow-md flex justify-between">
      <div v-if="!editMode" class="flex justify-between">
        <div>
          <h1 class="text-3xl font-semibold mb-4">{{ wine?.name }}</h1>
          <div>
            <div>
              <img :src="`/wines/${wine?.picture_link}`" class="w-32">
            </div>
            <p><strong>Année :</strong> {{ wine?.available_year }}</p>
            <p><strong>Type :</strong> {{ wine?.type }}</p>
            <p><strong>Pays :</strong> {{ wine?.country }}</p>
            <p><strong>producteur :</strong> {{ wine?.producer }}</p>
            <p><strong>Cépage :</strong> {{ wine?.variety }}</p>
            <p><strong>Appelation :</strong> {{ wine?.designation }}</p>
            <p><strong>EAN :</strong> {{ wine?.ean }}</p>

            <p><strong>Quantité :</strong> {{ wine?.quantity_tot }}</p>

            <p><strong>Accompagnements :</strong> {{ wine?.with_food }}</p>
            
            <p><strong>Note :</strong> {{ wine?.note }}/100</p>
            <p><strong>Commentaires :</strong> {{ wine?.comments }}</p>
          </div>
        </div>

        <div>
          <button @click="enterEditMode">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              class="w-6 h-6"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10"
              />
            </svg>
          </button>
        </div>
      </div>
      <div v-else>
        <!-- la suite : a faire sous forme de formulaire -->
        <!-- <input class="text-3xl font-semibold mb-4" v-model="wineForm.name" />
        <div>
          <p>
            <strong>Année :</strong><input v-model="wineForm.available_year" />
          </p>
          <p><strong>Type :</strong><input v-model="wineForm.type" /></p>
          <p><strong>Pays :</strong><input v-model="wineForm.country" /></p>
          <p><strong>EAN :</strong><input v-model="wineForm.ean" /></p>
          <p>
            <strong>Commentaires :</strong><input v-model="wineForm.comments" />
          </p>
        </div> -->
        <div class="flex flex-end">
          <button
            @click="saveChanges"
            class="bg-blue-2 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"
          >
            Sauvegarder
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import MyWineService from "../service/MyWineService.ts";
import { Wine } from "../classes/WineClass.ts";

const route = useRoute();
const wineId = ref(Number(route.params.id));
const wine = ref<Wine | null>(null);

const editMode = ref(false);
// const wineForm = ref<Wine>();

const enterEditMode = () => {
  // editMode.value = true;
  console.log("EditMode: ", editMode.value);
  // wineForm.name = { ...wine.value };
};

onMounted(async () => {
  try {
    wine.value = await MyWineService.getOneWine(wineId.value);
  } catch (error) {
    console.error("Erreur lors de la récupération des détails du vin", error);
  }
});

const saveChanges = async () => {
  try {
    // await MyWineService.updateWine(id, { newField: wine.value });
    wine.value = await MyWineService.getOneWine(wineId.value);
    editMode.value = false;
  } catch (error) {
    console.error("Erreur lors de la sauvegarde", error);
  }
};
</script>
<style scoped>
svg:hover {
  stroke: grey;
}
.diamond {
  width: 0;
  height: 0;
  border: 10px solid transparent;
  border-bottom-color: currentColor;
  display: inline-block;
  transform: rotate(45deg);
}
</style>
