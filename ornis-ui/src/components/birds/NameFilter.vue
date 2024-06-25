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

<template>
  <form class="input-group mb-3" role="search" novalidate @submit.prevent="filterBirdsByName">
    <input
      v-model.trim="searchText"
      type="search"
      class="form-control shadow-sm"
      :placeholder="$t('birds.nameFilter.placeholder')"
      @keyup.enter="submit"
    />
    <button class="btn btn-outline-secondary shadow-sm" type="submit">
      {{ $t('birds.nameFilter.submit') }}
    </button>
  </form>
</template>
