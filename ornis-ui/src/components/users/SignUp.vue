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
        nickname: null,
        password: null,
      },
    };
  },
  validations() {
    return {
      inputs: {
        emailAddress: { required, maxLength: maxLength(100) },
        nickname: { required, maxLength: maxLength(20) },
        password: {
          required,
          minLength: minLength(8),
          maxLength: maxLength(42),
          helpers: helpers.regex(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[%*!]).{8,}$/),
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
        this.$toast.success('toast-global', this.$t('signUp.toastMessages.success'));
      } else {
        console.error(resp);
        this.$toast.error('toast-global', this.$t('signUp.toastMessages.error));
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
        <label for="nickname" class="form-label"
          >{{ $t('signUp.nickname.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >
        <input
          id="nickname"
          v-model="inputs.nickname"
          name="nickname"
          type="text"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.nickname.$error,
          }"
        />
        <p class="form-text">
          {{ $t('signUp.nickname.helpText') }}
        </p>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label"
          >{{ $t('signUp.email.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >
        <input
          id="email"
          v-model="inputs.emailAddress"
          name="email"
          type="email"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.emailAddress.$error,
          }"
        />
        <p class="form-text">{{ $t('signUp.email.helpText') }}</p>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label"
          >{{ $t('signUp.password.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >
        <input
          id="password"
          v-model="inputs.password"
          name="password"
          type="password"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.password.$error,
          }"
        />
        <p class="form-text">
          {{ $t('signUp.password.helpText') }} "<span class="fst-italic">{{
            $t('signUp.regex')
          }}</span
          >".
        </p>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary shadow-sm" :disabled="validator.$invalid">
          {{ $t('signUp.submit') }}
        </button>
      </div>
    </form>
  </section>
</template>
