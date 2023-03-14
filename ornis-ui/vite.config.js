import { fileURLToPath, URL } from 'node:url';
import { defineConfig } from 'vite';
import eslintPlugin from 'vite-plugin-eslint';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), eslintPlugin()],
  resolve: {
    // alias provides us an absolute path from src to whichever file, instead of a relative path from whichever file upwards the working tree. This system allows us to move the file without changing the imports.
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
});
