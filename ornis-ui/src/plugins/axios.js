import axios from 'axios';
import { setInvalidStyle } from '@/utils/invalidStylesHandler';

const handleGlobalErrors = (error, i18n, toast) => {
  const errorCodes = error?.response?.data?.errorCodes;
  const messages = [];
  const errorFields = [];
  const { t } = i18n.global;

  if (errorCodes) {
    for (let i = 0; i < errorCodes.length; i += 1) {
      const value = errorCodes[i];
      const splitValue = value.split(': ');
      const errorField = splitValue[0];
      const errorCode = splitValue[1];

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
        case 'E_UNQ_XN_ID':
          messages.push(t('toastMessages.errors.xenoId.unicity'));
          errorFields.push(errorField);
          break;
        default:
          messages.push(t('toastMessages.errors.undefined'));
          errorFields.push(errorField);
      }

      if (messages.length > 0) {
        setInvalidStyle(errorFields);
        toast.error('toast-global', messages.join('\n'));
      }
    }
  } else {
    const form = document.querySelector('form');
    // eslint-disable-next-line prefer-destructuring
    const elements = form.elements;

    for (let i = 0; i < elements.length; i += 1) {
      const element = elements[i];
      if (element.tagName !== 'button') {
        element.classList.add('is-invalid');
      }
    }

    messages.push(t('toastMessages.errors.undefined'));
  }

  if (messages.length > 0) {
    toast.error('toast-global', messages.join('\n'));
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
