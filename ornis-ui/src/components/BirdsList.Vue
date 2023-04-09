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
      const resp = await this.$http.get('/birds/selected');
      this.birds = await resp.body;
    },
  },
};
</script>

<template>
  <section>
    <h1>Birds of France</h1>
    <div class="card bg-white">
      <ul class="list-group list-group-flush">
        <li v-for="bird in birds" :key="bird" class="list-group-item bg-white">
          {{ bird.comName }}
        </li>
      </ul>
    </div>
  </section>
</template>
