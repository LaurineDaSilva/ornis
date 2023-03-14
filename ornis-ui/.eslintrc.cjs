/* eslint-env node */
require('@rushstack/eslint-patch/modern-module-resolution');

const path = require('path');

module.exports = {
  root: true,
  extends: ['plugin:vue/vue3-recommended', 'airbnb-base', '@vue/eslint-config-prettier/'],
  parserOptions: {
    ecmaVersion: 'latest',
  },
  settings: {
    'import/resolver': {
      node: {
        extensions: ['.js'],
      },
      alias: {
        map: [['@', path.join(__dirname, './src')]],
        extensions: ['.js'],
      },
    },
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
    'function-paren-newline': 'off',
    'import/no-extraneous-dependencies': ['error', { devDependencies: true }],
  },
};
