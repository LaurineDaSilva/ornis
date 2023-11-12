<script>
import { useRoute } from 'vue-router';

export default {
  setup() {
    return {
      route: useRoute(),
    };
  },
  data() {
    return {
      id: this.route.params.id,
      bird: {},
    };
  },
  beforeMount() {
    this.initBird();
  },
  methods: {
    async initBird() {
      const resp = await this.$http.get(`/birds/${this.id}/detail`);
      this.bird = resp.body;
    },
  },
};
</script>

<template>
  <section>
    <h1>{{ bird.commonName }}</h1>
    <p class="fw-light fst-italic">{{ bird.scientificName }}</p>
    <div class="card mb-3">
      <div class="row g-0">
        <div class="col-md-4">
          <img
            :src="`/images/bird_pictures/${bird.imageName}`"
            class="img-fluid rounded-start bird-detail"
            :alt="$t('birdsList.imageAlt', { name: bird.commonName })"
          />
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">{{ $t('birdDetail.description.title') }}</h5>
            <p class="card-text">
              {{ bird.description }}
            </p>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-play-circle"
              viewBox="0 0 16 16"
            >
              <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
              <path
                d="M6.271 5.055a.5.5 0 0 1 .52.038l3.5 2.5a.5.5 0 0 1 0 .814l-3.5 2.5A.5.5 0 0 1 6 10.5v-5a.5.5 0 0 1 .271-.445z"
              />
            </svg>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-pause-circle"
              viewBox="0 0 16 16"
            >
              <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
              <path
                d="M5 6.25a1.25 1.25 0 1 1 2.5 0v3.5a1.25 1.25 0 1 1-2.5 0v-3.5zm3.5 0a1.25 1.25 0 1 1 2.5 0v3.5a1.25 1.25 0 1 1-2.5 0v-3.5z"
              />
            </svg>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<style>
.bird-detail {
  width: 60rem;
  height: 20rem;
}
</style>
