import { defineStore } from 'pinia';

// eslint-disable-next-line import/prefer-default-export
export const useAuthStore = defineStore('auth', {
  state: () => {
    return {
      token: '',
      nickname: '',
      emailAddress: '',
      role: '',
    };
  },
});
