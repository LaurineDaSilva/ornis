import { createApp } from 'vue';
import App from '@/App.vue';
import router from '@/router';
import { useToast, toast } from '@/plugins/toast';
import i18n from '@/plugins/i18n/i18n';
import axios from '@/plugins/axios';

const app = createApp(App);

app.use(router);
app.use(useToast);
app.use(i18n);
app.use(axios, i18n, toast);

app.mount('#app');
