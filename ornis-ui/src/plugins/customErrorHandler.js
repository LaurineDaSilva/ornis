/* eslint-disable */

export default {
  install: (app) => {
    const customErrorHandler = (app.config.errorHandler = (err, comp) => {
      console.error('Vue Global ErrorHandler', err);
      console.log('Enter customErrorHandler');
      console.log(err);
      console.log('Exit customErrorHandler');
      comp.$toast.error('toast-global', comp.$t('toastMessages.errors.global'));
    });

    return customErrorHandler;
  },
};
