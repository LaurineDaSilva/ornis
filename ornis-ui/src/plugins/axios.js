import axios from 'axios';

export default {
  install: (app) => {
    const http = axios.create({
      baseURL: import.meta.env.VITE_API_BASE_URL,
    });
    http.interceptors.response.use(
      (response) => {
        const { status, data } = response;
        const body = data !== '' ? data : null;
        return { status, body };
      },
      (error) => {
        const errorCodes = error?.response?.data?.errorCodes;
        if (errorCodes) {
          console.log(errorCodes);
        } else {
          console.log('errorCodes not found');
        }
        console.log(error);
        return Promise.reject(error);
      },
    );

    // eslint-disable-next-line no-param-reassign
    app.config.globalProperties.$http = http;
  },
};
