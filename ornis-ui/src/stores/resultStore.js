import { defineStore } from 'pinia';

// eslint-disable-next-line import/prefer-default-export
export const useResultStore = defineStore('result', {
  state: () => {
    return {
      searchResults: [],
    };
  },

  actions: {
    setResults(searchResults) {
      this.$patch({
        searchResults,
      });
    },
  },
});
