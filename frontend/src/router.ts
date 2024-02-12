import { createRouter, createWebHistory } from 'vue-router'

import Home from './views/Home.vue';
import NotFound from './views/NotFound.vue';
import MyWine from './views/MyWine.vue';
import WineDetails from './views/WineDetails.vue';
import MyWineDetails from './views/MyWineDetails.vue';
import AddWine from './views/AddWine.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/vin/:id',
    name: 'WineDetails',
    component: WineDetails,
    props:true
  },
  {
    path: '/vin/nouveau',
    name: 'AddWine',
    component: AddWine
  },
  {
    path: '/mon-vin',
    name: 'MyWine',
    component: MyWine
  },
  {
    path: '/mon-vin/:id',
    name: 'MyWineDetails',
    component: MyWineDetails,
    props:true
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFound
  }
]

export default createRouter({
  history: createWebHistory(),
  routes
});

