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
        let message = '';

        if (errorCodes) {
          for (let i = 0; i < errorCodes.length; i += 1) {
            const value = errorCodes[i];
            const splitValue = value.split(': ');
            // const errorField = splitValue[0];
            const errorCode = splitValue[1];

            switch (errorCode) {
              case 'E_UNQ_EMAIL':
                message = 'This email address already exists.';
                break;
              case 'E_UNQ_NCKNM':
                message = 'This username is already taken.';
                break;
              case 'E_UNQ_SC_NM':
                message = 'A bird with this scientific name already exists.';
                break;
              case 'E_UNQ_CMN_NM':
                message = 'A bird with this common name already exists.';
                break;
              default:
                console.log(errorCodes);
                message = `Sorry, a mysterious error occured.`;
            }
          }
        } else {
          message = 'errorCodes not found';
        }
        console.log('Enter Axios');
        console.log(error);
        console.log(message);
        console.log('Exit Axios');
        return Promise.reject(error);
      },
    );

    // eslint-disable-next-line no-param-reassign
    app.config.globalProperties.$http = http;
  },
};
