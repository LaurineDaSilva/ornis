<script>
export default {
  emits: ['filterEndpoint'],

  data() {
    return {
      colors: [],
      feetShapes: [],
      beakShapes: [],
      sizes: [],
      advancedFilters: {
        inputs: {
          colors: [],
          sizeId: null,
          beakShapeId: null,
          feetShapeId: null,
        },
      },
    };
  },

  methods: {
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

    createFilterEndpoint() {
      let filterEndpoint = `/birds/filter?`;

      if (this.advancedFilters.inputs.colors != null) {
        const colorsString = this.advancedFilters.inputs.colors.join(',');
        filterEndpoint = filterEndpoint.concat('colors=', encodeURIComponent(colorsString), '&');
      }

      if (this.advancedFilters.inputs.beakShapeId) {
        const encodedBeakShapeId = encodeURIComponent(this.advancedFilters.inputs.beakShapeId);
        filterEndpoint = filterEndpoint.concat('beakShapeId=', encodedBeakShapeId, '&');
      }

      if (this.advancedFilters.inputs.feetShapeId) {
        const encodedFeetShapeId = encodeURIComponent(this.advancedFilters.inputs.feetShapeId);
        filterEndpoint = filterEndpoint.concat('feetShapeId=', encodedFeetShapeId, '&');
      }

      if (this.advancedFilters.inputs.sizeId) {
        const encodedSizeId = encodeURIComponent(this.advancedFilters.inputs.sizeId);
        filterEndpoint = filterEndpoint.concat('sizeId=', encodedSizeId);
      }

      this.$emit('filterEndpoint', filterEndpoint);
    },
  },
};
</script>

<template>
  <div class="pb-5">
    <p class="d-flex justify-content-end">
      <button
        class="btn btn-outline-tertiary shadow-sm"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#advancedFilters"
      >
        {{ $t('birds.advancedFilters.button') }}
      </button>
    </p>

    <div id="advancedFilters" class="collapse card card-body shadow-sm">
      <form novalidate @submit.prevent="createFilterEndpoint">
        <div id="searchAccordion" class="mb-3 accordion">
          <div class="accordion-item shadow-sm">
            <h2 class="accordion-header">
              <button
                class="accordion-button"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#collapseColors"
                @click.once="initColors"
              >
                <label for="colors" class="form-label">{{
                  $t('birds.advancedFilters.labels.colors')
                }}</label>
              </button>
            </h2>

            <div
              id="collapseColors"
              class="accordion-collapse collapse"
              data-bs-parent="#searchAccordion"
            >
              <div v-for="color in advancedFilters.colors" :key="color" class="accordion-body">
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
          <div class="accordion-item shadow-sm">
            <h2 class="accordion-header">
              <button
                class="accordion-button"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#collapseSizes"
                @click.once="initSizes"
              >
                <label for="size" class="form-label">{{
                  $t('birds.advancedFilters.labels.size')
                }}</label>
              </button>
            </h2>

            <div
              id="collapseSizes"
              class="accordion-collapse collapse"
              data-bs-parent="#searchAccordion"
            >
              <div v-for="size in advancedFilters.sizes" :key="size" class="accordion-body">
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
          <div class="accordion-item shadow-sm">
            <h2 class="accordion-header">
              <button
                class="accordion-button"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#collapseBeakShapes"
                @click.once="initBeakShapes"
              >
                <label for="beakShape" class="form-label">{{
                  $t('birds.advancedFilters.labels.beakShape')
                }}</label>
              </button>
            </h2>

            <div
              id="collapseBeakShapes"
              class="accordion-collapse collapse"
              data-bs-parent="#searchAccordion"
            >
              <div
                v-for="beakShape in advancedFilters.beakShapes"
                :key="beakShape"
                class="accordion-body"
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
          <div class="accordion-item shadow-sm">
            <h2 class="accordion-header">
              <button
                class="accordion-button"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#collapseFeetShapes"
                @click.once="initFeetShapes"
              >
                <label for="feetShape" class="form-label">{{
                  $t('birds.advancedFilters.labels.feetShape')
                }}</label>
              </button>
            </h2>

            <div
              id="collapseFeetShapes"
              class="accordion-collapse collapse"
              data-bs-parent="#searchAccordion"
            >
              <div
                v-for="feetShape in advancedFilters.feetShapes"
                :key="feetShape"
                class="accordion-body"
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
          <button type="submit" class="btn btn-outline-secondary shadow-sm">
            {{ $t('birds.advancedFilters.submit') }}
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
