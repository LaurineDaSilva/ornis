<script>
import { useVuelidate } from '@vuelidate/core';
import { maxLength } from '@vuelidate/validators';

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
      },
    };
  },
  validations() {
    return {
      inputs: {
        scientificName: { maxLength: maxLength(100) },
        commonName: { maxLength: maxLength(200) },
        description: { maxLength: maxLength(5000) },
      },
    };
  },
  methods: {
    async submit() {
      const resp = await this.$http.post('/birds/update-bird', this.inputs);
      if (resp.status === 204) {
        Object.assign(this.inputs, this.$options.data().inputs);
        this.validator.$reset();
        console.log('Bird updated with success.');
      } else {
        console.error(resp);
        console.log('Server conversion or validation error.');
      }
    },
  },
};
</script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('updateBird.title') }}</h1>
    <form novalidate @submit.prevent="submit">
      <div class="mb-3">
        <label for="scientificName" class="form-label">{{
          $t('updateBird.scientificName.label')
        }}</label>
        <input
          id="scientificName"
          v-model="inputs.scientificName"
          name="scientificName"
          type="text"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.commonName.$error,
          }"
        />
        <p class="form-text">
          {{ $t('updateBird.scientificName.helpText') }}
        </p>
      </div>
      <div class="mb-3">
        <label for="commonName" class="form-label">{{
          $t('updateBird.commonName.label')
        }}</label>
        <input
          id="commonName"
          v-model="inputs.commonName"
          name="commonName"
          type="text"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.commonName.$error,
          }"
        />
        <p class="form-text">
          {{ $t('updateBird.commonName.helpText') }}
        </p>
      </div>
      <div class="mb-3">
        <label for="description" class="form-label">{{
          $t('updateBird.description.label')
        }}</label>
        <input
          id="description"
          v-model="inputs.description"
          name="commonName"
          type="textarea"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.description.$error,
          }"
        />
        <p class="form-text">
          {{ $t('updateBird.description.helpText') }}
        </p>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary shadow-sm" :disabled="validator.$invalid">
          {{ $t('updateBird.submit') }}
        </button>
      </div>
    </form>
  </section>
</template>

<style>
#description {
  height: 100px;
}
</style>
