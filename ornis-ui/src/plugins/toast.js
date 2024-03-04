const showToast = (id, cls, message) => {
  const container = document.querySelector(`#${id}>.toast`);
  const classes = container.classList;
  classes.add(cls);
  const body = container.querySelector('.toast-body');
  body.textContent = message;
  container.addEventListener(
    'hidden.bs.toast',
    () => {
      classes.remove(cls);
      body.textContent = '';
    },
    { once: true },
  );
  // eslint-disable-next-line no-undef
  const toast = bootstrap.Toast.getOrCreateInstance(container);
  toast.show();
};

const toast = {
  success: (id, msg) => {
    showToast(id, 'text-bg-success', msg);
  },
  error: (id, msg) => {
    showToast(id, 'text-bg-danger', msg);
  },
};

const useToast = {
  install: (app) => {
    // eslint-disable-next-line no-param-reassign
    app.config.globalProperties.$toast = toast;
  },
};

export { toast, useToast };
