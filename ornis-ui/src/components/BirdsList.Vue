<script>
export default {
  data() {
    return {
      baseUrl: import.meta.env.VITE_IMG_BASE_URL,
      birds: [],
    };
  },
  beforeMount() {
    this.initBirdsList();
  },
  methods: {
    async initBirdsList() {
      const resp = await this.$http.get('/birds');
      this.birds = await resp.body;
    },
  },
};
</script>

<template>
  <section>
    <div class="locale-changer">
      <select v-model="$i18n.locale" class="rounded">
        <option
          v-for="locale in $i18n.availableLocales"
          :key="`locale-${locale}`"
          :value="locale"
        >
          {{ locale }}
        </option>
      </select>
    </div>
    <h1 class="mt-5 mb-4">{{ $t('birdsList.title') }}</h1>
    <div class="card shadow-sm bg-white m-5">
      <ul class="list-group list-group-flush">
        <li v-for="bird in birds" :key="bird" class="list-group-item bg-white">
          {{ bird.vernacularName }}, <span class="fst-italic">({{ bird.scientificName }})</span>
        </li>
      </ul>
    </div>
  </section>
</template>
