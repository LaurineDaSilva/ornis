<script>
export default {
  data() {
    return {
      searchText: null,
      birds: [],
    };
  },

  methods: {
    async submit() {
      await this.$http
        .get(`/birds/search?searchText=${this.searchText}`)
        .then((resp) => {
          this.birds = resp.body;
          console.log(resp);
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
