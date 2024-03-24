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

  actions: {
    setUser(token, nickname, emailAddress, role) {
      this.$patch({
        token,
        nickname,
        emailAddress,
        role,
      });
    },
  },

  getters: {
    isAuthenticated: (state) => !!state.token,

    isAdmin: (state) => state.role === 'ROLE_ADMIN',
  },
});
