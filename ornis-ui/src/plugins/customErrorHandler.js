/* eslint-disable */

export default {
  install: (app) => {
    const customErrorHandler = (app.config.errorHandler = (error, comp) => {
      const errorCodes = error?.response?.data?.errorCodes;
      let messages = [];
      let message = '';
      let errorFields = [];

      if (errorCodes) {
        for (let i = 0; i < errorCodes.length; i += 1) {
          const value = errorCodes[i];
          const splitValue = value.split(': ');
          const errorCode = splitValue[1];
          const errorField = splitValue[0];

          switch (errorCode) {
            case 'E_UNQ_EMAIL':
              message = comp.$t('toastMessages.errors.emailAddress.unicity');
              messages.push(message);
              errorFields.push(errorField);
              break;
            case 'E_UNQ_NCKNM':
              message = comp.$t('toastMessages.errors.nickname.unicity');
              messages.push(message);
              errorFields.push(errorField);
              break;
            case 'E_UNQ_SC_NM':
              message = comp.$t('toastMessages.errors.scientificName.unicity');
              messages.push(message);
              errorFields.push(errorField);
              break;
            case 'E_UNQ_CMN_NM':
              message = comp.$t('toastMessages.errors.commonName.unicity');
              messages.push(message);
              errorFields.push(errorField);
              break;
            default:
              message = comp.$t('toastMessages.errors.undefined');
              messages.push(message);
              errorFields.push(errorField);
          }
        }
      } else {
        message = comp.$t('toastMessages.errors.commonName.global');
        messages.push(message);
      }
      console.log(errorCodes);
      setInvalidStyle(errorFields);
      comp.$toast.error('toast-global', messages);
    });

    return customErrorHandler;
  },
};

function setInvalidStyle(errorFields) {
  for (let i = 0; i < errorFields.length; i += 1) {
    const errorField = errorFields[i];
    const element = document.getElementById(errorField);
    const elementHelpText = document.getElementById(`${errorField}-helpText`);
    element.classList.add('is-invalid');
    elementHelpText.classList.add('text-danger');
  }
}
