<script>
import { useResultStore } from '@/stores/resultStore';

export default {
  setup() {
    const store = useResultStore();

    return {
      store,
    };
  },

  methods: {
    showResult() {
      console.log(this.store.result);
    },
  },
};
</script>

<template>
  <h1>Search results</h1>
</template>
