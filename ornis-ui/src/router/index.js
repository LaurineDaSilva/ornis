import { createRouter, createWebHistory } from 'vue-router';
import BirdsList from '@/components/birds/BirdsList.vue';
import BirdDetail from '@/components/birds/BirdDetail.vue';
import CreateBird from '@/components/birds/admin/CreateBird.vue';
import UpdateBird from '@/components/birds/admin/UpdateBird.vue';
import SignUp from '@/components/users/SignUp.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // Pages accessible without authentication:
    {
      path: '/',
      name: 'home',
      component: BirdsList,
    },
    {
      path: '/birds/:id/detail',
      name: 'bird-detail',
      component: BirdDetail,
    },
    {
      path: '/sign-up',
      name: 'sign-up',
      component: SignUp,
    },
    // Pages for admins:
    {
      path: '/admin/birds/add-bird',
      name: 'add-bird',
      component: CreateBird,
    },
    {
      path: '/admin/birds/:id/update-bird',
      name: 'update-bird',
      component: UpdateBird,
    },
  ],
});

export default router;
