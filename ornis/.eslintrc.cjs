/* eslint-env node */
require('@rushstack/eslint-patch/modern-module-resolution');

module.exports = {
  root: true,
  extends: ['plugin:vue/vue3-recommended', 'airbnb-base', '@vue/eslint-config-prettier/'],
  parserOptions: {
    ecmaVersion: 'latest',
  },
  rules: {
    indent: [
      'error',
      2,
      {
        SwitchCase: 1,
      },
    ],
    'no-empty': [
      'error',
      {
        allowEmptyCatch: true,
      },
    ],
    'no-unused-vars': [
      'error',
      {
        argsIgnorePattern: '^ignored',
      },
    ],
    'object-curly-newline': [
      'error',
      {
        ImportDeclaration: {
          multiline: true,
        },
      },
    ],
    'operator-linebreak': [
      'error',
      'after',
      {
        overrides: {
          '?': 'before',
          ':': 'before',
        },
      },
    ],
    'no-underscore-dangle': 'off',
    'implicit-arrow-linebreak': 'off',
    'function-paren-newline': off,
  },
};
