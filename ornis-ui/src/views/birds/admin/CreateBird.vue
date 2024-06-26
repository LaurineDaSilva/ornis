<script>
import { useVuelidate } from '@vuelidate/core';
import { required, requiredIf, minLength, maxLength, numeric } from '@vuelidate/validators';
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
      initData: {
        beakShapes: null,
        feetShapes: null,
        sizes: null,
        colors: [],
      },
      inputs: {
        scientificName: null,
        commonName: null,
        description: null,
        file: undefined,
        xenoId: null,
        beakShape: null,
        feetShape: null,
        size: null,
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
        xenoId: { minLength: minLength(6), maxLength: maxLength(6), numeric },
        beakShape: { required },
        feetShape: { required },
        size: { required },
        colorIds: { required },
      },
    };
  },

  beforeMount() {
    this.initColors();
    this.initSizes();
    this.initBeakShapes();
    this.initFeetShapes();
  },

  methods: {
    async initColors() {
      await this.$http
        .get(`/colors`)
        .then((resp) => {
          this.initData.colors = resp.body;
        })
        .catch(() => {});
    },

    async initSizes() {
      await this.$http
        .get(`/sizes`)
        .then((resp) => {
          this.initData.sizes = resp.body;
        })
        .catch(() => {});
    },

    async initBeakShapes() {
      await this.$http
        .get(`/beakShapes`)
        .then((resp) => {
          this.initData.beakShapes = resp.body;
        })
        .catch(() => {});
    },

    async initFeetShapes() {
      await this.$http
        .get(`/feetShapes`)
        .then((resp) => {
          this.initData.feetShapes = resp.body;
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
            'is-invalid': validator.inputs.scientificName.$error,
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
          :class="{
            'is-invalid': validator.inputs.commonName.$error,
          }"
          @input="removeInvalidStyles('xenoId')"
        />

        <p id="xenoId-helpText" class="form-text">
          {{ $t('createBird.xenoId.helpText') }}
        </p>
      </div>

      <div class="mb-3">
        <label for="beakShape" class="form-label"
          >{{ $t('createBird.beakShape.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >
        <select id="beakShape" v-model="inputs.beakShape" class="form-select shadow-sm">
          <option
            v-for="beakShape in initData.beakShapes"
            :key="beakShape"
            :value="beakShape.id"
          >
            {{ beakShape.name }}
          </option>
        </select>
      </div>

      <div class="mb-3">
        <label for="feetShape" class="form-label"
          >{{ $t('createBird.feetShape.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >
        <select id="feetShape" v-model="inputs.feetShape" class="form-select shadow-sm">
          <option selected>FeetShape</option>
          <option
            v-for="feetShape in initData.feetShapes"
            :key="feetShape"
            :value="feetShape.id"
          >
            {{ feetShape.name }}
          </option>
        </select>
      </div>

      <div class="mb-3">
        <label for="size" class="form-label"
          >{{ $t('createBird.size.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >
        <select id="size" v-model="inputs.size" class="form-select shadow-sm">
          <option selected>Size</option>
          <option v-for="size in initData.sizes" :key="size" :value="size.id">
            {{ size.name }}
          </option>
        </select>
      </div>

      <div class="mb-3">
        <label for="colors" class="form-label"
          >{{ $t('createBird.colors.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >
        <div class="list-group mx-0 w-auto">
          <label class="list-group-item d-flex gap-2" for="colorsCheckbox">
            <div
              id="colors"
              class="form-check shadow-sm"
              v-for="color in initData.colors"
              :key="color"
            >
              <input
                v-model="inputs.colorIds"
                class="form-check-input flex-shrink=0"
                type="checkbox"
                :value="color.id"
                id="colorsCheckbox"
              />
              <span> {{ color.name }}</span>

              <div
                class="btn-group"
                role="group"
                aria-label="Basic checkbox toggle button group"
              >
                <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off" />
                <label
                  class="btn btn-outline-primary"
                  :style="{ backgroundColor: color.rgbCode, color: color.rgbCode }"
                  for="btncheck1"
                  >{{ color.rgbCode }}</label
                >
              </div>
            </div>
          </label>
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
