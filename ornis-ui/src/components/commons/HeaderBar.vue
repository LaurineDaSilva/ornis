<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary text-light mb-5 shadow">
    <div class="container-fluid">
      <a class="navbar-brand text-light ms-1" href="/">Ornis</a>
      <div class="col-md-3 text-end">
        <button type="button" class="btn btn-outline-secondary me-2">Login</button>
        <button type="button" class="btn btn-primary">
          <a href="/sign-up" class="text-light navbar-links">{{ $t('signUp.title') }}</a>
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
