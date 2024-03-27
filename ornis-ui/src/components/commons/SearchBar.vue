<script>
import { useResultStore } from '@/stores/resultStore';

export default {
  setup() {
    const store = useResultStore();

    return {
      store,
    };
  },

  data() {
    return {
      searchText: null,
    };
  },

  methods: {
    async submit() {
      await this.$http
        .get(`/birds/search?searchText=${this.searchText}`)
        .then((resp) => {
          const results = resp.body;
          console.log('search bar');
          console.log(results);
          this.store.setResults(results);
          this.$router.push('/search-result');
        })
        .catch(() => {});
    },
  },
};
</script>

<template>
  <form role="search" novalidate @submit.prevent="submit">
    <input
      v-model.trim="searchText"
      class="form-control"
      type="search"
      :placeholder="$t('header.search')"
      @keyup.enter="submit"
    />
  </form>
</template>
