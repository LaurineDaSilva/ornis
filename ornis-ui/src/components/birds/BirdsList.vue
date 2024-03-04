<script>
import BirdActionsMenu from '@/components/birds/admin/BirdActionsMenu.vue';
import LoadingSpinner from '@/components/commons/LoadingSpinner.vue';

export default {
  components: {
    BirdActionsMenu,
    LoadingSpinner,
  },

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
      await this.$http

        .get(`/birds/list`)

        .then((resp) => {
          this.birds = resp.body;
          this.loaded = true;
        })

        .catch(() => {});
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('birdsList.title') }}</h1>

    <div class="list-group birds-list-container">
      <p v-if="loaded && (!birds || birds.length === 0)">{{ $t('birdsList.error') }}</p>

      <ul
        v-else-if="loaded && birds && birds.length > 0"
        class="row justify-content-between birds-list"
      >
        <li v-for="bird in birds" :key="bird" class="col-md-6 shadow-sm card bird-cards">
          <img
            class="col-4 bird-card-img"
            :src="`src/assets/images/bird_pictures/${bird.imageName}`"
            :alt="$t('birdsList.imageAlt', { name: bird.commonName })"
          />

          <div class="card-body col-md-8">
            <RouterLink :to="{ name: 'bird-detail', params: { id: bird.id } }" class="ms-auto">
              <h5 class="card-title">{{ bird.commonName }}</h5>

              <p class="card-text fst-italic">
                {{ bird.scientificName }}
              </p></RouterLink
            >

            <div class="position-absolute top-0 end-0">
              <BirdActionsMenu :bird="bird"></BirdActionsMenu>
            </div>
          </div>
        </li>
      </ul>

      <div v-else class="d-flex mx-auto my-5">
        <LoadingSpinner></LoadingSpinner>
      </div>
    </div>
  </section>
</template>

<style scoped>
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
