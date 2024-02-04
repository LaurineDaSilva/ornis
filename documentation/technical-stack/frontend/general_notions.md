# General front-end notions

## `package.json`

In a package.json file for a Node.js project, the dependencies section is used to list the packages that your project depends on. These dependencies are typically external libraries or frameworks that your project requires to run. The version number specified alongside each dependency is used to indicate the version of the package that your project is compatible with.

For example, if you see "vue": "^2.6.14" in the dependencies section, it means that your project depends on Vue.js (a JavaScript framework for building user interfaces), and the caret (^) symbol indicates that your project is compatible with any version of Vue.js that is compatible with 2.6.14 but does not include breaking changes. The ^ symbol is part of Semantic Versioning (SemVer) and means that your project can automatically use newer patch and minor releases (e.g., 2.6.15, 2.7.0) but not major releases that might include breaking changes (e.g., 3.0.0).

Here's a breakdown of the version specification:

- ^: Compatible with the specified version but allows patch and minor version updates.
- 2.6.14: The specific version of Vue.js that your project is compatible with.
  This ensures that when someone else tries to set up your project or when you deploy it in different environments, the correct versions of dependencies are installed to maintain compatibility.

When you or someone else installs or updates the project's dependencies using a package manager like npm or yarn, the specified versions are used to fetch and install the appropriate versions of the dependencies.

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
