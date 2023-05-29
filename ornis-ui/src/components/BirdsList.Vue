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
      this.birds = await resp.body;
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('birdsList.title') }}</h1>
    <div class="card shadow-sm bg-white m-5">
      <ul class="list-group list-group-flush">
        <li v-for="bird in birds" :key="bird" class="list-group-item bg-white">
          {{ $t(`birdsCommonNames.${bird.speciesCode}`) }},
          <span class="fst-italic">({{ bird.scientificName }})</span>
        </li>
      </ul>
    </div>
  </section>
</template>
