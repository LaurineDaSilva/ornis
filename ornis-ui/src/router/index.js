import { createRouter, createWebHistory } from 'vue-router';
import BirdList from '@/components/birds/BirdsList.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),

  routes: [
    // Pages accessible without authentication:
    {
      path: '/',
      name: 'home',
      component: BirdList,
    },

    {
      path: '/birds/:id/detail',
      name: 'bird-detail',
      component: () => import('@/components/birds/BirdDetail.vue'),
    },

    {
      path: '/sign-up',
      name: 'sign-up',
      component: () => import('@/components/users/SignUp.vue'),
    },

    // Pages for admins:
    {
      path: '/admin/birds/add-bird',
      name: 'add-bird',
      component: () => import('@/components/birds/admin/CreateBird.vue'),
    },

    {
      path: '/admin/birds/:id/update-bird',
      name: 'update-bird',
      component: () => import('@/components/birds/admin/UpdateBird.vue'),
    },
  ],
});

export default router;
