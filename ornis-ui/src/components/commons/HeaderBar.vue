<script>
import { useAuthStore } from '@/stores/authStore';

export default {
  setup() {
    const store = useAuthStore();

    return {
      store,
    };
  },

  methods: {
    signOut() {
      this.store.logout();
      setTimeout(() => {
        this.$router.go('/');
      }, '1000');
    },
  },
};
</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5 shadow">
    <div class="container-fluid">
      <RouterLink :to="{ name: 'home' }" class="nav-link navbar-brand text-light ms-1">
        {{ $t('header.title') }}</RouterLink
      >

      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div id="navbarSupportedContent" class="collapse navbar-collapse">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <RouterLink :to="{ name: 'home' }" class="nav-link">
              {{ $t('header.home') }}</RouterLink
            >
          </li>
          <li v-if="store.isAdmin" class="nav-item">
            <RouterLink :to="{ name: 'add-bird' }" class="nav-link">
              {{ $t('header.addBird') }}
            </RouterLink>
          </li>
        </ul>

        <div v-if="!store.isAuthenticated" class="col-md-3 text-end">
          <button
            type="button"
            class="btn btn-outline-secondary cstm-btn-text-secondary link-secondary me-2"
          >
            <RouterLink id="sign-in" :to="{ name: 'sign-in' }" class="cstm-btn-text-secondary">
              {{ $t('signIn.title') }}
            </RouterLink>
          </button>

          <button type="button" class="btn btn-primary">
            <RouterLink :to="{ name: 'sign-up' }" class="text-light navbar-links">
              {{ $t('signUp.title') }}
            </RouterLink>
          </button>
        </div>

        <div v-else class="col-md-3 text-end text-secondary">
          <button
            type="button"
            class="btn btn-outline-secondary cstm-btn-text-secondary link-secondary me-2"
            @click="signOut"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-box-arrow-left"
              viewBox="0 0 16 16"
            >
              <path
                fill-rule="evenodd"
                d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z"
              />
              <path
                fill-rule="evenodd"
                d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708z"
              />
            </svg>

            {{ $t('signOut') }}
          </button>
        </div>
      </div>
    </div>
  </nav>
</template>

<style>
.navbar-links {
  text-decoration: none;
}
</style>
