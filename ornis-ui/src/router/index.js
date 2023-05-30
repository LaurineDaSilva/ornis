import { createRouter, createWebHistory } from 'vue-router';
import BirdsList from '@/components/BirdsList.vue';
import SignUp from '@/components/SignUp.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: BirdsList,
    },
    {
      path: '/sign-up',
      name: 'sign-up',
      component: SignUp,
    },
    /*
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    } 
    */
  ],
});

export default router;
