import { defineStore } from 'pinia';

// eslint-disable-next-line import/prefer-default-export
export const useAuthStore = defineStore('auth', {
  state: () => {
    const storedToken = localStorage.getItem('token');
    const storedUsername = localStorage.getItem('username');
    const storedEmailAddress = localStorage.getItem('emailAddress');
    const storedRole = localStorage.getItem('role');

    return {
      token: storedToken || '',
      nickname: storedUsername || '',
      emailAddress: storedEmailAddress || '',
      role: storedRole || '',
    };
  },

  actions: {
    setUser(token, username, emailAddress, role) {
      this.$patch({
        token,
        username,
        emailAddress,
        role,
      });

      localStorage.setItem('token', token);
      localStorage.setItem('username', username);
      localStorage.setItem('emailAddress', emailAddress);
      localStorage.setItem('role', role);
    },

    logout() {
      this.$reset();
      // Clear local storage
      localStorage.removeItem('token');
      localStorage.removeItem('username');
      localStorage.removeItem('emailAddress');
      localStorage.removeItem('role');
    },
  },

  getters: {
    isAuthenticated: (state) => !!state.token,

    isAdmin: (state) => state.role === 'ROLE_ADMIN',
  },
});
