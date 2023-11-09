<script>
export default {
  data() {
    return {
      baseUrl: import.meta.env.VITE_IMG_BASE_URL,
      birds: [],
      loaded: false,
    };
  },
  beforeMount() {
    this.initBirdsList();
  },
  methods: {
    async initBirdsList() {
      const resp = await this.$http.get(`/birds/list`);
      this.birds = await resp.body;
      this.loaded = true;
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('birdsList.title') }}</h1>
    <div class="list-group birds-list-container">
      <ul v-if="loaded" class="row justify-content-between birds-list">
        <li v-for="bird in birds" :key="bird" class="col-md-6 shadow-sm card bird-cards">
          <img
            class="col-4 bird-card-img"
            :src="`/images/bird_thumbnails/${bird.speciesCode}.jpg`"
            :alt="$t('birdsList.imageAlt', { name: bird.commonName })"
          />
          <div class="card-body col-md-8">
            <RouterLink :to="{ name: 'bird-detail', params: { id: bird.id } }" class="ms-auto">
              <h5 class="card-title">{{ bird.commonName }}</h5>
              <p class="card-text fst-italic">
                {{ bird.scientificName }}
              </p></RouterLink
            >
          </div>
        </li>
      </ul>
      <div v-else class="d-flex mx-auto my-5">
        <div class="spinner-border text-primary" role="status">
          <span class="visually-hidden">Loading...</span>
        </div>
      </div>
    </div>
  </section>
</template>

<style>
.birds-list {
  gap: 20px;
}

.bird-cards {
  max-width: 540px;

  height: 120px;
  padding: 0;
  flex-direction: row;
  overflow: hidden;
}

.bird-card-img {
  height: 100%;
  object-fit: cover;
  object-position: center center;
}

@media (min-width: 992px) {
  .birds-list-container {
    padding-left: 5%;
    padding-right: 5%;
  }
}
</style>
