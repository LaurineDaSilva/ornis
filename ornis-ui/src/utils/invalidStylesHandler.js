const setInvalidStyle = (errorFields) => {
  for (let i = 0; i < errorFields.length; i += 1) {
    const errorField = errorFields[i];
    const element = document.getElementById(errorField);
    const elementHelpText = document.getElementById(`${errorField}-helpText`);

    element.classList.add('is-invalid');
    elementHelpText.classList.add('text-danger');
  }
};

const removeInvalidStyles = (inputId) => {
  const element = document.getElementById(inputId);
  const elementHelpText = document.getElementById(`${inputId}-helpText`);

  element.classList.remove('is-invalid');
  elementHelpText.classList.remove('text-danger');
};

export { setInvalidStyle, removeInvalidStyles };
