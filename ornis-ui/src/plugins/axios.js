import axios from 'axios';

const setInvalidStyle = (errorFields) => {
  for (let i = 0; i < errorFields.length; i += 1) {
    const errorField = errorFields[i];
    const element = document.getElementById(errorField);
    const elementHelpText = document.getElementById(`${errorField}-helpText`);
    element.classList.add('is-invalid');
    elementHelpText.classList.add('text-danger');
  }
};

const handleGlobalErrors = (error, i18n, toast) => {
  const errorCodes = error?.response?.data?.errorCodes;
  const messages = [];
  const errorFields = [];
  const { t } = i18n.global;

  if (errorCodes) {
    for (let i = 0; i < errorCodes.length; i += 1) {
      const value = errorCodes[i];
      const splitValue = value.split(': ');
      const errorCode = splitValue[1];
      const errorField = splitValue[0];

      switch (errorCode) {
        case 'E_UNQ_EMAIL':
          messages.push(t('toastMessages.errors.emailAddress.unicity'));
          errorFields.push(errorField);
          break;
        case 'E_UNQ_NCKNM':
          messages.push(t('toastMessages.errors.nickname.unicity'));
          errorFields.push(errorField);
          break;
        case 'E_UNQ_SC_NM':
          messages.push(t('toastMessages.errors.scientificName.unicity'));
          errorFields.push(errorField);
          break;
        case 'E_UNQ_CMN_NM':
          messages.push(t('toastMessages.errors.commonName.unicity'));
          errorFields.push(errorField);
          break;
        default:
          messages.push(t('toastMessages.errors.undefined'));
          errorFields.push(errorField);
      }
    }

    if (messages.length > 0) {
      setInvalidStyle(errorFields);
      toast.error('toast-global', messages.join('\n'));
    }
  }
};

export default {
  install: (app, i18n, toast) => {
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
        handleGlobalErrors(error, i18n, toast);

        return Promise.reject(error);
      },
    );

    // eslint-disable-next-line no-param-reassign
    app.config.globalProperties.$http = http;
  },
};
