<script>
import BirdActionsMenu from '@/components/birds/admin/BirdActionsMenu.vue';
import LoadingSpinner from '@/components/commons/LoadingSpinner.vue';
import { useAuthStore } from '@/stores/authStore';

export default {
  components: {
    BirdActionsMenu,
    LoadingSpinner,
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
      searchText: null,
      loaded: false,
      inputs: {
        colors: [],
        size: null,
        beakShape: null,
        feetShape: null,
      },
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

    async filterBirds() {
      if (!this.searchText) {
        this.displayedBirds = this.birds;
      } else {
        await this.$http
          .get(`/birds/search?searchText=${this.searchText}`)
          .then((resp) => {
            const results = resp.body;
            this.displayedBirds = results;
          })
          .catch(() => {});
      }
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('birdsList.title') }}</h1>

    <form class="input-group mb-3" role="search" novalidate @submit.prevent="filterBirds">
      <input
        v-model.trim="searchText"
        type="search"
        class="form-control"
        :placeholder="$t('birdsList.filterPlaceholder')"
        @keyup.enter="submit"
      />
      <button class="btn btn-outline-secondary" type="submit">
        {{ $t('birdsList.filterButton') }}
      </button>
    </form>

    <p>
      <button
        class="btn btn-primary"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#advancedFilters"
      >
        Recherche avancée
      </button>
    </p>

    <div id="advancedFilters" class="collapse card card-body">
      <form novalidate @submit.prevent="submit">
        <div class="mb-3">
          <label for="colors" class="form-label">{{
            $t('birdsList.advancedFilters.colors.label')
          }}</label>

          <div class="form-check">
            <input
              id="red"
              v-model="inputs.colors"
              type="checkbox"
              class="form-check-input"
              value="red"
            />
            <label class="form-check-label" for="red"> Rouge </label>
          </div>

          <div class="form-check">
            <input
              id="green"
              v-model="inputs.colors"
              type="checkbox"
              class="form-check-input"
              value="green"
            />
            <label class="form-check-label" for="green"> Green </label>
          </div>
        </div>

        <div class="mb-3">
          <label for="size" class="form-label">{{
            $t('birdsList.advancedFilters.size.label')
          }}</label>

          <input
            id="size"
            v-model="inputs.size"
            name="size"
            type="size"
            class="form-control shadow-sm"
          />

          <div class="form-check">
            <input id="size1" type="radio" name="flexRadioDefault" class="form-check-input" />
            <label class="form-check-label" for="size1"> Default radio </label>
          </div>
          <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="size2" />
            <label class="form-check-label" for="size2"> Default checked radio </label>
          </div>
        </div>

        <div class="mb-3">
          <label for="beakShape" class="form-label">{{
            $t('birdsList.advancedFilters.beakShape.label')
          }}</label>

          <input
            id="beakShape"
            v-model="inputs.beakShape"
            name="beakShape"
            type="beakShape"
            class="form-control shadow-sm"
          />
        </div>

        <div class="mb-3">
          <label for="feetShape" class="form-label">{{
            $t('birdsList.advancedFilters.feetShape.label')
          }}</label>

          <input
            id="feetShape"
            v-model="inputs.feetShape"
            name="feetShape"
            type="feetShape"
            class="form-control shadow-sm"
          />
        </div>

        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
          <button type="submit" class="btn btn-primary shadow-sm">
            {{ $t('signIn.submit') }}
          </button>
        </div>
      </form>
    </div>

    <div class="list-group birds-list-container">
      <p v-if="loaded && (!displayedBirds || displayedBirds.length === 0)">
        {{ $t('birdsList.error') }}
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
            :alt="$t('birdsList.imageAlt', { name: bird.commonName })"
          />

          <div class="card-body col-md-8">
            <RouterLink :to="{ name: 'bird-detail', params: { id: bird.id } }" class="ms-auto">
              <h5 class="card-title">{{ bird.commonName }}</h5>

              <p class="card-text fst-italic">
                {{ bird.scientificName }}
              </p></RouterLink
            >

            <div v-if="store.isAdmin" class="position-absolute top-0 end-0">
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
