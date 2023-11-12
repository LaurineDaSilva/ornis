import { createRouter, createWebHistory } from 'vue-router';
import BirdsList from '@/components/BirdsList.vue';
import BirdDetail from '@/components/BirdDetail.vue';
import SignUp from '@/components/SignUp.vue';
import BirdsDashboard from '@/components/admin/BirdsDashboard.vue';
import CreateBird from '@/components/admin/CreateBird.vue';
import UpdateBird from '@/components/admin/UpdateBird.vue';

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
      path: '/admin/birds/dashboard',
      name: 'birds-dashboard',
      component: BirdsDashboard,
    },
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
