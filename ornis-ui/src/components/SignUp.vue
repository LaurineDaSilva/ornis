<script></script>

<template>
  <section>
    <h1>{{ $t('signUp.title') }}</h1>
    <form>
      <div class="mb-3">
        <label for="usernameInput" class="form-label"
          >{{ $t('signUp.username.label') }}<span class="text-secondary">*</span></label
        >
        <input id="usernameInput" class="form-control" type="text" />
        <div id="usernameInputHelpText" class="form-text">
          {{ $t('signUp.username.helpText') }}
        </div>
      </div>
      <div class="mb-3">
        <label for="emailInput" class="form-label"
          >{{ $t('signUp.email.label') }}<span class="text-secondary">*</span></label
        >
        <input id="emailInput" class="form-control" type="email" />
        <div id="emailHelpText" class="form-text">{{ $t('signUp.email.helpText') }}</div>
      </div>
      <div class="mb-3">
        <label for="passwordInput" class="form-label"
          >{{ $t('signUp.password.label') }}<span class="text-secondary">*</span></label
        >
        <input id="passwordInput" class="form-control" type="password" />
        <div id="passwordHelpText" class="form-text">
          {{ $t('signUp.password.helpText') }} "<span class="fst-italic">%*!</span>".
        </div>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-primary">{{ $t('signUp.submit') }}</button>
      </div>
    </form>
  </section>
</template>
