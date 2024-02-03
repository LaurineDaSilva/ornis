# Vite

Vite is a front-end build tool.

## Aliases

Vite allows developer to set aliases.

For instance:
`alias: {'@': fileURLToPath(new URL('./src', import.meta.url)),},`

This alias provides an absolute path from src to whichever file, instead of a relative path from whichever file upwards the working tree. This system allows us to move the file without changing the imports.

## Setting up environment variables with Vite

Vite exposes env variables on the special import.meta.env object.

With the file `.env.local`, we can set up local environment variables. With the case of the base URL, we can define it in our .env.local this way:

`VITE_API_BASE_URL=http://localhost:8080`

Then we can access it to set up Axios this way:

`const http = axios.create({`
`baseURL: import.meta.env.VITE_API_BASE_URL,`
`});`

## Sourcemap

Sourcemaps are useful for developers to see in which file a style has been defined when inspecting an element in the browser.

![viteconfig-sourcemap01](../../../images/technical-stack/frontend/frontend-dependencies/vite_01.jpg)

![viteconfig-sourcemap02](../../../images/technical-stack/frontend/frontend-dependencies/vite_02.jpg)
