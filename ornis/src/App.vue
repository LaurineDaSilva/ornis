<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <header></header>
  <!--
  <div class="wrapper">
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>
    </nav>
  </div>
-->
  <RouterView />
</template>

<style scoped></style>
