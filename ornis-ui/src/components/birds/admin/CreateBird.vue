<script>
import { useVuelidate } from '@vuelidate/core';
import { required, requiredIf, maxLength } from '@vuelidate/validators';

export default {
  setup() {
    return {
      validator: useVuelidate({ $autoDirty: true }),
    };
  },
  data() {
    return {
      inputs: {
        scientificName: null,
        commonName: null,
        description: null,
        file: undefined,
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
    fileSelected(event) {
      [this.inputs.file] = event.target.files;
    },
    async submit(event) {
      const formData = new FormData();
      Object.keys(this.inputs).forEach((key) => {
        const value = this.inputs[key];
        if (value) {
          formData.append(key, value);
        }
      });
      await this.$http
        .post('/birds/create', formData)
        .then((resp) => {
          if (resp.status === 204) {
            event.target.reset();
            Object.assign(this.inputs, this.$options.data().inputs);
            this.validator.$reset();
            this.$toast.success('toast-global', this.$t('createBird.toastMessages.success'));
          }
        })
        .catch(() => {
          console.log('extra error management');
        });
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

      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary shadow-sm" :disabled="validator.$invalid">
          {{ $t('createBird.submit') }}
        </button>
      </div>
    </form>
  </section>
</template>
