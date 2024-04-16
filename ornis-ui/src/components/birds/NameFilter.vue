<template>
  <form class="input-group mb-3" role="search" novalidate @submit.prevent="filterBirdsByName">
    <input
      v-model.trim="searchText"
      type="search"
      class="form-control"
      :placeholder="$t('birdNameFilter.placeholder')"
      @keyup.enter="submit"
    />
    <button class="btn btn-outline-secondary" type="submit">
      {{ $t('birdNameFilter.submit') }}
    </button>
  </form>
</template>

<script>
export default {
  emits: ['search'],
  data() {
    return {
      searchText: null,
    };
  },
  methods: {
    async filterBirdsByName() {
      this.$emit('search', this.searchText);
    },
  },
};
</script>
