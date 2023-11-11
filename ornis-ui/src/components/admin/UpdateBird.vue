<script>
import { useRoute } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';
import { required, maxLength } from '@vuelidate/validators';

export default {
  setup() {
    return {
      route: useRoute(),
      validator: useVuelidate({ $autoDirty: true }),
    };
  },
  data() {
    return {
      id: this.route.params.id,
      birdToUpdate: {
        scientificName: null,
        commonName: null,
      },
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
        scientificName: { required, maxLength: maxLength(100) },
        commonName: { required, maxLength: maxLength(200) },
        description: { required, maxLength: maxLength(5000) },
      },
    };
  },
  beforeMount() {
    this.initInputs();
  },
  methods: {
    async initInputs() {
      const resp = await this.$http.get(`/birds/${this.id}/to-update`);
      this.inputs = resp.body;
      this.birdToUpdate.commonName = this.inputs.commonName;
      this.birdToUpdate.scientificName = this.inputs.scientificName;
    },
    async submit() {
      const formData = new FormData();
      Object.keys(this.inputs).forEach((key) => {
        const value = this.inputs[key];
        if (value) {
          formData.append(key, value);
        }
      });
      const resp = await this.$http.put(`/birds/update-bird/${this.id}`, formData);
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
    <div class="mt-5 mb-4">
      <h1>{{ $t('updateBird.title') }} :</h1>
      <h4 class="text-primary">
        {{ birdToUpdate.commonName }}
        <span class="fst-italic text-primary">({{ birdToUpdate.scientificName }})</span>
      </h4>
    </div>
    <form novalidate @submit.prevent="submit">
      <div class="mb-3">
        <label for="scientificName" class="form-label">{{
          $t('updateBird.scientificName.label')
        }}</label>
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
          v-model.trim="inputs.commonName"
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
          v-model.trim="inputs.description"
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
