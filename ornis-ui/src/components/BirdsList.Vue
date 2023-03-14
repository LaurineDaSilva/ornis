<script>
export default {
  data() {
    return {
      birds: ['Pigeon', 'Moineau', 'Pie', 'Mésange', 'Hulotte', 'Coucou'],
    };
  },
};
</script>

<template>
  <h1>Birds of France</h1>
  <ul class="list-group list-group-flush">
    <li v-for="bird in birds" :key="bird" class="list-group-item">{{ bird }}</li>
  </ul>
</template>
