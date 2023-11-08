<script></script>

<template>
  <section>
    <h1 class="mt-5 mb-4">{{ $t('createBird.title') }}</h1>
    <form>
      <div class="mb-3">
        <label for="scientificName" class="form-label"
          >{{ $t('createBird.labels.scientificName')
          }}<span class="text-secondary">*</span></label
        >
        <input id="scientificName" type="text" class="form-control" />
        <p class="form-text">
          {{ $t('createBird.helpTexts.scientificName') }}
        </p>
      </div>
      <div class="mb-3">
        <label for="commonName" class="form-label"
          >{{ $t('createBird.labels.commonName') }}<span class="text-secondary">*</span></label
        >
        <input id="commonName" type="text" class="form-control" />
        <p class="form-text">
          {{ $t('createBird.helpTexts.commonName') }}
        </p>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary">Ajouter l'oiseau</button>
      </div>
    </form>
  </section>
</template>
