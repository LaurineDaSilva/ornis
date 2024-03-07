<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5 shadow">
    <div class="container-fluid">
      <RouterLink :to="{ name: 'home' }" class="nav-link navbar-brand text-light ms-1">
        {{ $t('header.title') }}
      </RouterLink>

      <div id="navbarSupportedContent" class="collapse navbar-collapse">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <RouterLink :to="{ name: 'home' }" class="nav-link active">
              {{ $t('header.home') }}
            </RouterLink>
          </li>

          <li class="nav-item">
            <RouterLink :to="{ name: 'add-bird' }" class="nav-link">
              {{ $t('header.addBird') }}
            </RouterLink>
          </li>
        </ul>
      </div>

      <div class="col-md-3 text-end">
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

      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </nav>
</template>

<style>
.navbar-links {
  text-decoration: none;
}
</style>
