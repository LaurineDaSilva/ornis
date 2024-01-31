/* eslint-disable */

import axios from 'axios';

const ALLOWED_STATUS_CODES = [200, 201, 202, 204, 400];

export default {
  install: (app) => {
    const http = axios.create(
      {
        baseURL: import.meta.env.VITE_API_BASE_URL,
      },
      /* validateStatus: (status) => {
        return ALLOWED_STATUS_CODES.includes(status);
      },
    });
    http.interceptors.response.use(
      (response) => {
        const status = response.status;
        const data = response.data;
        const body = data != '' ? data : null;
        return { status: status, body: body };
      },
      (error) => {
        return Promise.reject(error);
      },*/
    );

    app.config.globalProperties.$http = http;
  },
};
