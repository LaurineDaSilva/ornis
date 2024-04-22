<script>
import { useVuelidate } from '@vuelidate/core';
import { required, requiredIf, maxLength } from '@vuelidate/validators';
import { removeInvalidStyles } from '@/utils/invalidStylesHandler';
import { useAuthStore } from '@/stores/authStore';

export default {
  setup() {
    const store = useAuthStore();

    return {
      validator: useVuelidate({ $autoDirty: true }),
      removeInvalidStyles,
      store,
    };
  },

  data() {
    return {
      colors: [],
      feetShapes: [],
      beakShapes: [],
      sizes: [],
      inputs: {
        scientificName: null,
        commonName: null,
        description: null,
        file: undefined,
        xenoId: null,
        beakShapeId: null,
        feetShapeId: null,
        sizeId: null,
        colorIds: [],
      },
    };
  },

  validations() {
    return {
      inputs: {
        scientificName: { required, maxLength: maxLength(100) },
        commonName: { required, maxLength: maxLength(200) },
        description: { maxLength: maxLength(5000) },
        file: {
          required: requiredIf(() => {
            return this.inputs.file === undefined;
          }),
          maxValue: (file) => {
            return file ? file.size <= 1048576 : true;
          },
        },
      },
    };
  },

  methods: {
    async initColors() {
      await this.$http
        .get(`/colors`)
        .then((resp) => {
          this.colors = resp.body;
        })
        .catch(() => {});
    },

    async initSizes() {
      await this.$http
        .get(`/sizes`)
        .then((resp) => {
          this.sizes = resp.body;
        })
        .catch(() => {});
    },

    async initBeakShapes() {
      await this.$http
        .get(`/beakShapes`)
        .then((resp) => {
          this.beakShapes = resp.body;
        })
        .catch(() => {});
    },

    async initFeetShapes() {
      await this.$http
        .get(`/feetShapes`)
        .then((resp) => {
          this.feetShapes = resp.body;
        })
        .catch(() => {});
    },

    fileSelected(event) {
      [this.inputs.file] = event.target.files;
    },

    async submit(event) {
      if (this.store.isAdmin) {
        const formData = new FormData();
        const headers = { Authorization: `Bearer ${this.store.getToken}` };

        Object.keys(this.inputs).forEach((key) => {
          const value = this.inputs[key];

          if (value) {
            formData.append(key, value);
          }
        });

        await this.$http
          .post('/birds/create', formData, { headers })
          .then(() => {
            event.target.reset();
            Object.assign(this.inputs, this.$options.data().inputs);
            this.validator.$reset();
            this.$toast.success('toast-global', this.$t('createBird.toastMessages.success'));
          })
          .catch(() => {});
      }
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('createBird.title') }}</h1>

    <form novalidate @submit.prevent="submit">
      <div class="mb-3">
        <label for="scientificName" class="form-label"
          >{{ $t('createBird.scientificName.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >

        <input
          id="scientificName"
          v-model.trim="inputs.scientificName"
          name="scientificName"
          type="text"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.commonName.$error,
          }"
          @input="removeInvalidStyles('scientificName')"
        />

        <p id="scientificName-helpText" class="form-text">
          {{ $t('createBird.scientificName.helpText') }}
        </p>
      </div>

      <div class="mb-3">
        <label for="commonName" class="form-label"
          >{{ $t('createBird.commonName.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >

        <input
          id="commonName"
          v-model.trim="inputs.commonName"
          name="commonName"
          type="text"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.commonName.$error,
          }"
          @input="removeInvalidStyles('commonName')"
        />

        <p id="commonName-helpText" class="form-text">
          {{ $t('createBird.commonName.helpText') }}
        </p>
      </div>

      <div class="mb-3">
        <label for="description" class="form-label"
          >{{ $t('createBird.description.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >

        <textarea
          id="description"
          v-model.trim="inputs.description"
          name="description"
          rows="5"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.description.$error,
          }"
          @input="removeInvalidStyles('description')"
        ></textarea>

        <p id="description-helpText" class="form-text">
          {{ $t('createBird.description.helpText') }}
        </p>
      </div>

      <div class="mb-3">
        <label for="file" class="form-label"
          >{{ $t('createBird.file.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >

        <input
          id="file"
          name="file"
          type="file"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.file.$error,
          }"
          accept="image/jpeg,image/png"
          @change="fileSelected"
        />

        <p id="file-helpText" class="form-text">
          {{ $t('createBird.file.helpText') }}
        </p>
      </div>

      <div class="mb-3">
        <label for="xenoId" class="form-label"
          >{{ $t('createBird.xenoId.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >

        <input
          id="xenoId"
          v-model.trim="inputs.xenoId"
          name="xenoId"
          type="number"
          class="form-control shadow-sm"
        />

        <p id="xenoId-helpText" class="form-text">
          {{ $t('createBird.xenoId.helpText') }}
        </p>
      </div>

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
              <label for="colors" class="form-label">{{ $t('createBird.labels.colors') }}</label>
            </button>
          </h2>

          <div
            id="collapseColors"
            class="accordion-collapse collapse"
            data-bs-parent="#searchAccordion"
          >
            <div v-for="color in colors" :key="color" class="accordion-body">
              <input
                :id="color.id"
                v-model="inputs.colorIds"
                type="checkbox"
                class="form-check-input"
                :value="color.id"
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
              <label for="size" class="form-label">{{ $t('createBird.labels.size') }}</label>
            </button>
          </h2>

          <div
            id="collapseSizes"
            class="accordion-collapse collapse"
            data-bs-parent="#searchAccordion"
          >
            <div v-for="size in sizes" :key="size" class="accordion-body">
              <input
                :id="size.id"
                v-model="inputs.sizeId"
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
                $t('createBird.labels.beakShape')
              }}</label>
            </button>
          </h2>

          <div
            id="collapseBeakShapes"
            class="accordion-collapse collapse"
            data-bs-parent="#searchAccordion"
          >
            <div v-for="beakShape in beakShapes" :key="beakShape" class="accordion-body">
              <input
                :id="beakShape.id"
                v-model="inputs.beakShapeId"
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
                $t('createBird.labels.feetShape')
              }}</label>
            </button>
          </h2>

          <div
            id="collapseFeetShapes"
            class="accordion-collapse collapse"
            data-bs-parent="#searchAccordion"
          >
            <div v-for="feetShape in feetShapes" :key="feetShape" class="accordion-body">
              <input
                :id="feetShape.id"
                v-model="inputs.feetShapeId"
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
        <button type="submit" class="btn btn-primary shadow-sm" :disabled="validator.$invalid">
          {{ $t('createBird.submit') }}
        </button>
      </div>
    </form>
  </section>
</template>
