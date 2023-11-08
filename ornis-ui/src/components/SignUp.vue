<script>
import { useVuelidate } from '@vuelidate/core';
import { required, minLength, maxLength, helpers } from '@vuelidate/validators';

export default {
  setup() {
    return {
      validator: useVuelidate({ $autoDirty: true }),
    };
  },
  data() {
    return {
      inputs: {
        emailAddress: null,
        username: null,
        password: null,
      },
    };
  },
  validations() {
    return {
      inputs: {
        emailAddress: { required, maxLength: maxLength(100) },
        username: { required, maxLength: maxLength(20) },
        password: {
          required,
          minLength: minLength(8),
          maxLength: maxLength(42),
          helpers: helpers.regex(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[%*!"]).{8,}$/),
        },
      },
    };
  },
  methods: {
    async submit() {
      const resp = await this.$http.post('/join/signup', this.inputs);
      if (resp.status === 204) {
        Object.assign(this.inputs, this.$options.data().inputs);
        this.validator.$reset();
        console.log('User created with success.');
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
    <h1>{{ $t('signUp.title') }}</h1>
    <form novalidate @submit.prevent="submit">
      <div class="mb-3">
        <label for="username" class="form-label"
          >{{ $t('signUp.labels.username') }}<span class="text-secondary">*</span></label
        >
        <input
          id="username"
          v-model="inputs.username"
          class="form-control"
          name="username"
          type="text"
          :class="{
            'is-invalid': validator.inputs.username.$error,
          }"
        />
        <div class="form-text">
          {{ $t('signUp.helpTexts.username') }}
        </div>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label"
          >{{ $t('signUp.labels.email') }}<span class="text-secondary">*</span></label
        >
        <input
          id="email"
          v-model="inputs.emailAddress"
          class="form-control"
          name="email"
          type="email"
          :class="{
            'is-invalid': validator.inputs.emailAddress.$error,
          }"
        />
        <div class="form-text">{{ $t('signUp.helpTexts.email') }}</div>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label"
          >{{ $t('signUp.labels.password') }}<span class="text-secondary">*</span></label
        >
        <input
          id="password"
          v-model="inputs.password"
          class="form-control"
          name="password"
          type="password"
          :class="{
            'is-invalid': validator.inputs.password.$error,
          }"
        />
        <div class="form-text">
          {{ $t('signUp.helpTexts.password') }} "<span class="fst-italic">%*!</span>".
        </div>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary" :disabled="validator.$invalid">
          {{ $t('signUp.submit') }}
        </button>
      </div>
    </form>
  </section>
</template>
