# Prettier and ESLint

## Prettier

Prettier is a code formatter. Code is formatted on save.

## ESLint

ESLint is a tool to analyse JavaScript code and identify errors.

For the Ornis project, I configured ESLint following the Vue3 recommandations and the Airbnb style guide, which is known to be strict. I adapted its rules to make it compatible with my Prettier configuration.

By default, ESLint can fix code errors automatically. I disabled this option and made the linter run on each `npm run dev`. Hence, each time I start my app in dev mode, the linter analyzes my code and returns the problems with my code. I then have to fix these errors manually. It helps me learn to write better code and learn best practices. It also helps me to get training in error solving.

Some interesting errors I found with ESLint:

- by default my editor was in CRLF. It means that on each line return, there was a carriage return: an invisible character was present. There is not this issue with LF. By default Git replaces LF with CRLF so I had to configure Git too.
- there is an attribute order in Vue's best practices, v-bind attribute must be before class attribute. It makes sense because what we want to see as developers is the logic. It's better if it is one of the first thing we read.
- Vue components cannot have a single word as a name. The rule is named multi-word-component-names. [The EsLint documentation](https://eslint.vuejs.org/rules/multi-word-component-names.html) states: "This rule require component names to be always multi-word, except for root App components, and built-in components provided by Vue, such as <transition> or <component>. This prevents conflicts with existing and future HTML elements, since all HTML elements are single words.""
