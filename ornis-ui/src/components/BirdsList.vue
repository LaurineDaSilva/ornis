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
    <ul class="list-group">
      <div v-for="bird in birds" :key="bird" class="card mb-3 mx-auto" style="max-width: 540px">
        <div class="row g-0">
          <div class="col-md-4">
            <img
              :src="'/images/bird_pictures/' + bird.speciesCode + '.jpg'"
              class="img-fluid rounded-start"
              :alt="$t(`birdsCommonNames.${bird.speciesCode}`) + ' ' + $t(`birdsList.imageAlt`)"
            />
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="card-title">{{ $t(`birdsCommonNames.${bird.speciesCode}`) }}</h5>
              <p class="card-text fst-italic">
                {{ bird.scientificName }}
              </p>
            </div>
          </div>
        </div>
      </div>
    </ul>
  </section>
</template>
