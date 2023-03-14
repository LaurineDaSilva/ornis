<script>
export default {
  data() {
    return {
      baseUrl: import.meta.env.VITE_IMG_BASE_URL,
      birds: [],
    };
  },
  beforeMount() {
    this.initBirdsList();
  },
  methods: {
    async initBirdsList() {
      const resp = await this.$http.get('/birds');
      this.birds = resp.body;
    },
  },
};
</script>

<template>
  <h1>Birds of France</h1>
  <ul class="list-group list-group-flush">
    <li v-for="bird in birds" :key="bird" class="list-group-item">{{ bird.vernacularName }}</li>
  </ul>
</template>
