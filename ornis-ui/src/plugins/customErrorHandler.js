/* eslint-disable */

export default {
  install: (app) => {
    const customErrorHandler = (app.config.errorHandler = (error, comp) => {
      const errorCodes = error?.response?.data?.errorCodes;
      let messages = [];
      let message = '';

      if (errorCodes) {
        for (let i = 0; i < errorCodes.length; i += 1) {
          const value = errorCodes[i];
          const splitValue = value.split(': ');
          // const errorField = splitValue[0];
          const errorCode = splitValue[1];

          switch (errorCode) {
            case 'E_UNQ_EMAIL':
              message = comp.$t('toastMessages.errors.email.unicity');
              messages.push(message);
              break;
            case 'E_UNQ_NCKNM':
              message = comp.$t('toastMessages.errors.nickname.unicity');
              messages.push(message);
              break;
            case 'E_UNQ_SC_NM':
              message = comp.$t('toastMessages.errors.scientificName.unicity');
              messages.push(message);
              break;
            case 'E_UNQ_CMN_NM':
              message = comp.$t('toastMessages.errors.commonName.unicity');
              messages.push(message);
              break;
            default:
              message = comp.$t('toastMessages.errors.undefined');
              messages.push(message);
          }
        }
      } else {
        message = comp.$t('toastMessages.errors.commonName.global');
        messages.push(message);
      }
      console.log(errorCodes);

      comp.$toast.error('toast-global', messages);
    });

    return customErrorHandler;
  },
};
