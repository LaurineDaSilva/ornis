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
      const resp = await this.$http.get(`/birds/${this.$i18n.locale}`);
      this.birds = await resp.body;
      this.loaded = true;
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('birdsList.title') }}</h1>
    <ul class="list-group birds-list">
      <div v-if="loaded" class="row justify-content-between">
        <div v-for="bird in birds" :key="bird" class="col-md-6 mb-4" style="max-width: 540px">
          <div class="card h-100 shadow-sm">
            <div class="row g-0">
              <div class="col-md-4">
                <img
                  :src="`/images/bird_pictures/${bird.speciesCode}.jpg`"
                  class="img-fluid h-100 rounded-start"
                  :alt="$t('birdsList.imageAlt', { name: bird.commonName })"
                />
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">{{ bird.commonName }}</h5>
                  <p class="card-text fst-italic">
                    {{ bird.scientificName }}
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div v-else class="d-flex mx-auto my-5">
        <div class="spinner-border text-primary" role="status">
          <span class="visually-hidden">Loading...</span>
        </div>
      </div>
    </ul>
  </section>
</template>

<style>
@media (min-width: 992px) {
  .birds-list {
    padding-left: 5%;
    padding-right: 5%;
  }
}
</style>
