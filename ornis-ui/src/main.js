import { createApp } from 'vue';
import App from '@/App.vue';
import router from '@/router';
import axios from '@/plugins/axios';
import toast from '@/plugins/toast';
import i18n from '@/i18n/i18n';

const app = createApp(App);

app.use(router);
app.use(axios);
app.use(toast);
app.use(i18n);

app.mount('#app');
