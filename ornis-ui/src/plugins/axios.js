import axios from 'axios';

const ACCEPTED_STATUS = [200, 201, 202, 204, 400];

export default {
  install: (app) => {
    const http = axios.create({
      baseURL: import.meta.env.VITE_API_BASE_URL,
      validateStatus: (status) => {
        return ACCEPTED_STATUS.includes(status);
      },
    });
    http.interceptors.response.use(
      (response) => {
        const { status } = response.status;
        const { data } = response.data;
        const body = data !== '' ? data : null;
        return { status, body };
      },
      (error) => {
        return Promise.reject(error);
      },
    );
    /* eslint-disable no-param-reassign */
    app.config.globalProperties.$http = http;
  },
};
