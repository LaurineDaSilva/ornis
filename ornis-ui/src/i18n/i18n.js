import { createI18n } from 'vue-i18n';
import messages from './messages';

let lang = 'fr';

const shortDatetimeFormat = {
  year: 'numeric',
  month: 'numeric',
  day: '2-digit',
};
const longDatetimeFormat = {
  year: 'numeric',
  month: 'long',
  day: 'numeric',
};
const datetimeFormats = {
  short: shortDatetimeFormat,
  long: longDatetimeFormat,
};

const i18n = createI18n({
  locale: lang,
  fallbackLocale: lang,
  messages: messages,
  datetimeFormats,
});

export default i18n;
