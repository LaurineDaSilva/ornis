import { createRouter, createWebHistory } from 'vue-router';
import BirdList from '@/views/birds/BirdsList.vue';
import { useAuthStore } from '@/stores/authStore';

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
      path: '/search-result',
      name: 'search-result',
      component: () => import('@/views/SearchResult.vue'),
    },

    {
      path: '/sign-up',
      name: 'sign-up',
      component: () => import('@/views/users/SignUp.vue'),
      meta: {
        requiresUnauth: true,
      },
    },

    {
      path: '/sign-in',
      name: 'sign-in',
      component: () => import('@/views/users/SignIn.vue'),
      meta: {
        requiresUnauth: true,
      },
    },

    // Pages for admins:
    {
      path: '/admin/birds/add-bird',
      name: 'add-bird',
      component: () => import('@/views/birds/admin/CreateBird.vue'),
      meta: {
        requiresAuth: true,
        requiresAdminRole: true,
      },
    },

    {
      path: '/admin/birds/:id/update-bird',
      name: 'update-bird',
      component: () => import('@/views/birds/admin/UpdateBird.vue'),
      meta: {
        requiresAuth: true,
        requiresAdminRole: true,
      },
    },

    // Pages for errors:
    {
      path: '/not-found',
      name: 'not-found',
      component: () => import('@/views/errors/NotFound.vue'),
    },
  ],
});

router.beforeEach(async (to, from, next) => {
  const store = useAuthStore();

  if (to.meta.requiresAdminRole && !store.isAdmin) {
    next('/not-found');
  } else if (to.meta.requiresAuth && !store.isAuthenticated) {
    next('/sign-in');
  } else if (to.meta.requiresUnauth && store.isAuthenticated) {
    next('/');
  } else if (to.meta.requiresAuth && store.isAuthenticated) {
    next();
  } else if (!to.meta.requiresAuth) {
    next();
  }
});

export default router;
