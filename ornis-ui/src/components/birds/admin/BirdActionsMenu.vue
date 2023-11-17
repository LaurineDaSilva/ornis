<script>
export default {
  props: {
    bird: {
      type: Object,
      required: true,
    },
  },
  methods: {
    async deleteBird(id) {
      const resp = await this.$http.delete(`/birds/delete/${id}`);
      if (resp.status === 204) {
        this.$toast.success('toast-global', 'Espèce supprimée avec succès.');
        setTimeout(() => {
          this.$router.go();
        }, '1000');
      } else {
        console.error(resp);
        this.$toast.error('toast-global', 'Erreur de serveur.');
      }
    },
  },
};
</script>

<template>
  <button class="btn text-secondary" type="button" data-bs-toggle="dropdown">
    <svg
      xmlns="http://www.w3.org/2000/svg"
      width="16"
      height="16"
      fill="currentColor"
      class="bi bi-three-dots"
      viewBox="0 0 16 16"
    >
      <path
        d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z"
      />
    </svg>
  </button>
  <ul class="dropdown-menu">
    <li class="dropdown-item">
      <RouterLink :to="{ name: 'update-bird', params: { id: bird.id } }" class="ms-auto">{{
        $t('birdActionsMenu.edit')
      }}</RouterLink>
    </li>
    <li class="dropdown-item text-danger" @click="deleteBird(bird.id)">
      {{ $t('birdActionsMenu.delete') }}
    </li>
  </ul>
</template>
