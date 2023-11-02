import { createRouter, createWebHistory } from 'vue-router'

import Home from './views/Home.vue'
import NotFound from './views/NotFound.vue'
import Wine from './views/Wine.vue'
import MyWine from './views/MyWine.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/vin',
    name: 'Wine',
    component: Wine
  },
  {
    path: '/mon-vin',
    name: 'MyWine',
    component: MyWine
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

