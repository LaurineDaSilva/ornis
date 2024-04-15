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
      advancedFilters: {
        colors: [],
        feetShapes: [],
        beakShapes: [],
        sizes: [],
        inputs: {
          colors: [],
          sizeId: null,
          beakShapeId: null,
          feetShapeId: null,
        },
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

    async filterBirdsByName() {
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

    async initColors() {
      await this.$http
        .get(`/colors`)
        .then((resp) => {
          this.advancedFilters.colors = resp.body;
        })
        .catch(() => {});
    },

    async initSizes() {
      await this.$http
        .get(`/sizes`)
        .then((resp) => {
          this.advancedFilters.sizes = resp.body;
        })
        .catch(() => {});
    },

    async initBeakShapes() {
      await this.$http
        .get(`/beakShapes`)
        .then((resp) => {
          this.advancedFilters.beakShapes = resp.body;
        })
        .catch(() => {});
    },

    async initFeetShapes() {
      await this.$http
        .get(`/feetShapes`)
        .then((resp) => {
          this.advancedFilters.feetShapes = resp.body;
        })
        .catch(() => {});
    },

    async filterBirdsByCharacteristics() {
      console.log(this.advancedFilters.colors);
      const filterEndpoint = this.createFilterEndpoint();
      await this.$http
        .get(filterEndpoint)
        .then((resp) => {
          console.log(filterEndpoint);
          const results = resp.body;
          this.displayedBirds = results;
        })
        .catch(() => {
          console.log(filterEndpoint);
        });
    },

    createFilterEndpoint() {
      let filterEndpoint = `/birds/filter?`;

      if (this.advancedFilters.inputs.colors != null) {
        const colorsString = this.advancedFilters.inputs.colors.join(',');
        filterEndpoint = filterEndpoint.concat('colors=', colorsString, '&');
      }

      if (this.advancedFilters.inputs.beakShapeId) {
        filterEndpoint = filterEndpoint.concat(
          'beakShapeId=',
          this.advancedFilters.inputs.beakShapeId,
          '&',
        );
      }

      if (this.advancedFilters.inputs.feetShapeId) {
        filterEndpoint = filterEndpoint.concat(
          'feetShapeId=',
          this.advancedFilters.inputs.feetShapeId,
          '&',
        );
      }

      if (this.advancedFilters.inputs.sizeId) {
        filterEndpoint = filterEndpoint.concat('sizeId=', this.advancedFilters.inputs.sizeId);
      }

      return filterEndpoint;
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('birdsList.title') }}</h1>

    <form class="input-group mb-3" role="search" novalidate @submit.prevent="filterBirdsByName">
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

    <div>
      <p>
        <button
          class="btn btn-primary"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#advancedFilters"
        >
          {{ $t('birdsList.advancedFilters.title') }}
        </button>
      </p>

      <div id="advancedFilters" class="collapse card card-body">
        <form novalidate @submit.prevent="filterBirdsByCharacteristics">
          <div id="searchAccordion" class="mb-3 accordion">
            <div class="accordion-item">
              <h2 class="accordion-header">
                <button
                  class="accordion-button"
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#collapseColors"
                  @click.once="initColors"
                >
                  <label for="colors" class="form-label">{{
                    $t('birdsList.advancedFilters.colors.label')
                  }}</label>
                </button>
              </h2>

              <div
                id="collapseColors"
                class="accordion-collapse collapse"
                data-bs-parent="#searchAccordion"
              >
                <div
                  :key="color"
                  class="form-check accordion-body"
                  v-for="color in advancedFilters.colors"
                >
                  <input
                    :id="color.id"
                    v-model="advancedFilters.inputs.colors"
                    type="checkbox"
                    class="form-check-input"
                    :value="color.name"
                  />
                  <label :for="color.id" class="form-check-label"> {{ color.name }} </label>
                </div>
              </div>
            </div>
          </div>

          <div class="mb-3 accordion">
            <div class="accordion-item">
              <h2 class="accordion-header">
                <button
                  class="accordion-button"
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#collapseSizes"
                  @click.once="initSizes"
                >
                  <label for="size" class="form-label">{{
                    $t('birdsList.advancedFilters.size.label')
                  }}</label>
                </button>
              </h2>

              <div
                id="collapseSizes"
                class="accordion-collapse collapse"
                data-bs-parent="#searchAccordion"
              >
                <div
                  :key="size"
                  class="form-check accordion-body"
                  v-for="size in advancedFilters.sizes"
                >
                  <input
                    :id="size.id"
                    v-model="advancedFilters.inputs.sizeId"
                    type="radio"
                    name="flexRadioDefault"
                    class="form-check-input"
                    :value="size.id"
                  />
                  <label class="form-check-label" for="size.id"> {{ size.name }} </label>
                </div>
              </div>
            </div>
          </div>

          <div class="mb-3 accordion">
            <div class="accordion-item">
              <h2 class="accordion-header">
                <button
                  class="accordion-button"
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#collapseBeakShapes"
                  @click.once="initBeakShapes"
                >
                  <label for="beakShape" class="form-label">{{
                    $t('birdsList.advancedFilters.beakShape.label')
                  }}</label>
                </button>
              </h2>

              <div
                id="collapseBeakShapes"
                class="accordion-collapse collapse"
                data-bs-parent="#searchAccordion"
              >
                <div
                  :key="beakShape"
                  class="form-check accordion-body"
                  v-for="beakShape in advancedFilters.beakShapes"
                >
                  <input
                    :id="beakShape.id"
                    v-model="advancedFilters.inputs.beakShapeId"
                    type="radio"
                    name="flexRadioDefault"
                    class="form-check-input"
                    :value="beakShape.id"
                  />
                  <label class="form-check-label" :for="beakShape.id">
                    {{ beakShape.name }}
                  </label>
                </div>
              </div>
            </div>
          </div>

          <div class="mb-3 accordion">
            <div class="accordion-item">
              <h2 class="accordion-header">
                <button
                  class="accordion-button"
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#collapseFeetShapes"
                  @click.once="initFeetShapes"
                >
                  <label for="feetShape" class="form-label">{{
                    $t('birdsList.advancedFilters.feetShape.label')
                  }}</label>
                </button>
              </h2>

              <div
                id="collapseFeetShapes"
                class="accordion-collapse collapse"
                data-bs-parent="#searchAccordion"
              >
                <div
                  :key="feetShape"
                  class="form-check accordion-body"
                  v-for="feetShape in advancedFilters.feetShapes"
                >
                  <input
                    :id="feetShape.id"
                    v-model="advancedFilters.inputs.feetShapeId"
                    type="radio"
                    name="flexRadioDefault"
                    class="form-check-input"
                    :value="feetShape.id"
                  />
                  <label class="form-check-label" :for="feetShape.id">
                    {{ feetShape.name }}
                  </label>
                </div>
              </div>
            </div>
          </div>

          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button type="submit" class="btn btn-primary shadow-sm">
              {{ $t('birdsList.advancedFilters.submit') }}
            </button>
          </div>
        </form>
      </div>
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
