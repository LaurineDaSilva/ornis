<script>
export default {
  props: {
    bird: {
      type: Object,
      required: true,
    },
  },
};
</script>

<template>
  <div>
    <iframe
      :src="`https://xeno-canto.org/${bird.xenoId}/embed?simple=1`"
      scrolling="no"
      frameborder="0"
      width="340"
      height="115"
    ></iframe>
  </div>
</template>
