<script setup>
import HeaderBar from '@/components/commons/HeaderBar.vue';
import ToastNotification from '../components/commons/ToastNotification.vue';
</script>

<template>
  <HeaderBar />
  <main class="container-xl">
    <RouterView />
  </main>
  <ToastNotification id="toast-global" />
</template>

<style lang="scss">
.toast-container .toast-body {
  white-space: pre;
}
</style>
