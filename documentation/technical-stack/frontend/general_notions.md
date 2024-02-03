# General front-end notions

## ESM syntax

Vite projects require the ESM syntax (it can be specified in package.json with `"type": "module`).

The term "ESM syntax" typically refers to the syntax used in ECMAScript Modules (ESM). ECMAScript is the official specification upon which JavaScript is based, and ECMAScript Modules are a way to organize and structure code in JavaScript.

In JavaScript, there are two main module systems: CommonJS and ECMAScript Modules (ESM). ESM syntax is the syntax used for ECMAScript Modules. It provides a way to define modules in JavaScript by using the import and export keywords.

ESM syntax is more modern and versatile than the older CommonJS syntax and is now the preferred way to organize code in JavaScript projects. However, it's important to note that ESM is natively supported in modern browsers and newer versions of Node.js.

## CommonJS syntax

CommonJS is a module system for JavaScript that is used primarily in server-side environments, notably in Node.js. CommonJS syntax provides a way to organize code into modules and to define how modules can be imported and exported.

CommonJS is synchronous, and the modules are loaded and executed at runtime. This is suitable for server-side applications where synchronous loading is often acceptable.

While CommonJS is still widely used in server-side JavaScript (especially in Node.js), it is not natively supported in browsers. For client-side development, ECMAScript Modules (ESM) have become the preferred syntax.

## Plugins

Plugins are self-contained code that usually add app-level functionality to Vue.

You implement a plugin by doing:

`import { createApp } from 'vue'`

`const app = createApp({})`

`app.use(myPlugin, {`
`/* optional options */`
`})`

We use plugins to extract functionalities from the main code. For instance, the configuration of Axios.
