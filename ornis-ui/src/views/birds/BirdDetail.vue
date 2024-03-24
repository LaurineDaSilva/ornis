<script>
import { useRoute } from 'vue-router';
import XenoCantoPlayer from '../../components/birds/XenoCantoPlayer.vue';

export default {
  components: {
    XenoCantoPlayer,
  },

  setup() {
    return {
      route: useRoute(),
    };
  },

  data() {
    return {
      id: this.route.params.id,

      baseUrl: import.meta.env.VITE_IMG_BASE_URL,

      bird: {},
    };
  },

  beforeMount() {
    this.initBird();
  },

  methods: {
    async initBird() {
      await this.$http
        .get(`/birds/${this.id}/detail`)
        .then((resp) => {
          this.bird = resp.body;
        })
        .catch(() => {});
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
            :src="baseUrl + bird.imageName"
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

            <div v-if="bird.xenoId">
              <XenoCantoPlayer :bird="bird"></XenoCantoPlayer>
            </div>
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
