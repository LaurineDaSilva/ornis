const messages = {
  birdsList: {
    title: 'Liste des oiseaux de France',
    imageAlt: '{name} (photo)',
  },
  birdDetail: {
    description: {
      title: 'Description',
    },
  },
  createBird: {
    title: "Ajouter une espèce d'oiseau",
    scientificName: {
      label: 'Nom scientifique',
      helpText: '150 caractères maximum. Doit être unique.',
    },
    commonName: {
      label: 'Nom commun',
      helpText: '25 caractères maximum. Doit être unique.',
    },
    description: {
      label: 'Description',
      helpText: '5000 caractères maximum.',
    },
  },
  signUp: {
    title: 'Inscription',
    username: {
      label: "Nom d'utilisateur",
      helpText: '20 caractères maximum. Doit être unique.',
    },
    email: {
      label: 'Adresse email',
      helpText: 'Doit être unique.',
    },
    password: {
      label: 'Mot de passe',
      helpText:
        '8 caractères minimum. Doit inclure une lettre minuscule, une lettre majuscule et un symbole parmi',
    },
  },
  submit: "S'inscrire",
};

export default messages;
