import { createI18n } from 'vue-i18n';
import enMessages from './en';
import frMessages from './fr';

const browserLanguage = window.navigator.language;

let lang = '';

if (browserLanguage.startsWith('fr')) {
  lang = 'fr';
} else {
  lang = 'en';
}

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
  en: {
    short: shortDatetimeFormat,
    long: longDatetimeFormat,
  },
  fr: {
    short: shortDatetimeFormat,
    long: longDatetimeFormat,
  },
};

const i18n = createI18n({
  locale: lang,
  fallbackLocale: lang,
  messages: {
    en: enMessages,
    fr: frMessages,
  },
  datetimeFormats,
});

export default i18n;
