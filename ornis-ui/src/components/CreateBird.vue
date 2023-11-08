<script></script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('createBird.title') }}</h1>
    <form>
      <div class="mb-3">
        <label for="scientificName" class="form-label"
          >{{ $t('createBird.scientificName.label')
          }}<span class="text-secondary">*</span></label
        >
        <input id="scientificName" type="text" class="form-control" />
        <p class="form-text">
          {{ $t('createBird.scientificName.helpText') }}
        </p>
      </div>
      <div class="mb-3">
        <label for="commonName" class="form-label"
          >{{ $t('createBird.commonName.label') }}<span class="text-secondary">*</span></label
        >
        <input id="commonName" type="text" class="form-control" />
        <p class="form-text">
          {{ $t('createBird.commonName.helpText') }}
        </p>
      </div>
      <div class="mb-3">
        <label for="description" class="form-label"
          >{{ $t('createBird.description.label') }}<span class="text-secondary">*</span></label
        >
        <input id="description" type="textarea" class="form-control" />
        <p class="form-text">
          {{ $t('createBird.description.helpText') }}
        </p>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary">Ajouter l'oiseau</button>
      </div>
    </form>
  </section>
</template>

<style>
#description {
  height: 100px;
}
</style>
