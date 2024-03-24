<script>
import { useVuelidate } from '@vuelidate/core';
import { required } from '@vuelidate/validators';
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
      inputs: {
        nicknameOrEmailAddress: null,
        password: null,
      },
    };
  },

  validations() {
    return {
      inputs: {
        nicknameOrEmailAddress: { required },
        password: {
          required,
        },
      },
    };
  },

  methods: {
    async submit() {
      await this.$http
        .post('/join/sign-in', this.inputs)
        .then((resp) => {
          const response = resp.body;

          this.store.setUser(
            response.token,
            response.nickname,
            response.emailAddress,
            response.role,
          );

          console.log(this.store.role);

          Object.assign(this.inputs, this.$options.data().inputs);

          this.validator.$reset();
          this.$toast.success('toast-global', this.$t('signIn.toastMessages.success'));
          setTimeout(() => {
            this.$router.push('/');
          }, 1000);
        })
        .catch(() => {});
    },
  },
};
</script>

<template>
  <section>
    <h1>{{ $t('signIn.title') }}</h1>

    <form novalidate @submit.prevent="submit">
      <div class="mb-3">
        <label for="nicknameOrEmailAddress" class="form-label"
          >{{ $t('signIn.nicknameOrEmailAddress.label')
          }}<span class="text-secondary">{{ $t('required') }}</span></label
        >

        <input
          id="nicknameOrEmailAddress"
          v-model="inputs.nicknameOrEmailAddress"
          name="nicknameOrEmailAddress"
          type="text"
          class="form-control shadow-sm"
          :class="{
            'is-invalid': validator.inputs.nicknameOrEmailAddress.$error,
          }"
          @input="removeInvalidStyles('nicknameOrEmailAddress')"
        />
      </div>

      <div class="mb-3">
        <label for="password" class="form-label"
          >{{ $t('signIn.password.label')
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
      </div>

      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary shadow-sm" :disabled="validator.$invalid">
          {{ $t('signIn.submit') }}
        </button>
      </div>
    </form>
  </section>
</template>
