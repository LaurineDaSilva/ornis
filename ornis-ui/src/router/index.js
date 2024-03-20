import { createRouter, createWebHistory } from 'vue-router';
import BirdList from '@/views/birds/BirdsList.vue';

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
      component: () => import('@/views/birds/BirdDetail.vue'),
    },

    {
      path: '/sign-up',
      name: 'sign-up',
      component: () => import('@/views/users/SignUp.vue'),
    },

    {
      path: '/sign-in',
      name: 'sign-in',
      component: () => import('@/views/users/SignIn.vue'),
    },

    // Pages for admins:
    {
      path: '/admin/birds/add-bird',
      name: 'add-bird',
      component: () => import('@/views/birds/admin/CreateBird.vue'),
    },

    {
      path: '/admin/birds/:id/update-bird',
      name: 'update-bird',
      component: () => import('@/views/birds/admin/UpdateBird.vue'),
    },
  ],
});

export default router;
