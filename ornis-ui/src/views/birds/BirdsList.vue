<script>
import ActionsMenu from '@/components/birds/admin/ActionsMenu.vue';
import LoadingSpinner from '@/components/commons/LoadingSpinner.vue';
import NameFilter from '@/components/birds/NameFilter.vue';
import AdvancedFilter from '@/components/birds/AdvancedFilter.vue';
import { useAuthStore } from '@/stores/authStore';

export default {
  components: {
    ActionsMenu,
    LoadingSpinner,
    NameFilter,
    AdvancedFilter,
  },

  setup() {
    const store = useAuthStore();

    return {
      store,
    };
  },

  data() {
    return {
      baseUrl: import.meta.env.VITE_IMG_BASE_URL,
      birds: [],
      displayedBirds: [],
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
          this.displayedBirds = this.birds;
          this.loaded = true;
        })
        .catch(() => {});
    },

    async filterBirdsByName(searchText) {
      if (!searchText) {
        this.displayedBirds = this.birds;
      } else {
        await this.$http
          .get(`/birds/search?searchText=${encodeURIComponent(searchText)}`)
          .then((resp) => {
            const results = resp.body;
            this.displayedBirds = results;
          })
          .catch(() => {});
      }
    },

    async filterBirdsByCharacteristics(filterEndpoint) {
      await this.$http
        .get(filterEndpoint)
        .then((resp) => {
          const results = resp.body;
          this.displayedBirds = results;
        })
        .catch(() => {});
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('birds.list.title') }}</h1>

    <div>
      <NameFilter @search="filterBirdsByName" />

      <AdvancedFilter @filter-endpoint="filterBirdsByCharacteristics" />
    </div>

    <div class="list-group birds-list-container">
      <p v-if="loaded && (!displayedBirds || displayedBirds.length === 0)">
        {{ $t('birds.list.error') }}
      </p>

      <ul
        v-else-if="loaded && displayedBirds && displayedBirds.length > 0"
        class="row justify-content-between birds-list"
      >
        <li
          v-for="bird in displayedBirds"
          :key="bird"
          class="col-md-6 shadow-sm card bird-cards"
        >
          <img
            class="col-4 bird-card-img"
            :src="`src/assets/images/bird_pictures/${bird.image}`"
            :alt="$t('birds.list.imageAlt', { name: bird.commonName })"
          />

          <div class="card-body col-md-8">
            <RouterLink :to="{ name: 'bird-detail', params: { id: bird.id } }" class="ms-auto">
              <h5 class="card-title">{{ bird.commonName }}</h5>

              <p class="card-text fst-italic">
                {{ bird.scientificName }}
              </p></RouterLink
            >

            <div v-if="store.isAdmin" class="position-absolute top-0 end-0">
              <ActionsMenu :bird="bird"></ActionsMenu>
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
