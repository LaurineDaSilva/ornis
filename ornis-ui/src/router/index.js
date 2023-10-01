import { createRouter, createWebHistory } from 'vue-router';
import BirdsList from '@/components/BirdsList.vue';
import SignUp from '@/components/SignUp.vue';
import BirdDetails from '@/components/BirdDetails.vue';

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
    {
      path: '/bird/:id/detail',
      name: 'bird-detail',
      component: BirdDetails,
    },
  ],
});

export default router;
