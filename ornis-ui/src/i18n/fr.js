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
    labels: {
      scientificName: 'Nom scientifique',
    },
    helpTexts: {
      scientificName: '150 caractères maximum. Doit être unique.',
    },
  },
  signUp: {
    title: 'Inscription',
    labels: {
      username: "Nom d'utilisateur",
      email: 'Adresse email',
      password: 'Mot de passe',
    },
    helpTexts: {
      username: '20 caractères maximum. Doit être unique.',
      email: 'Doit être unique.',
      password:
        '8 caractères minimum. Doit inclure une lettre minuscule, une lettre majuscule et un symbole parmi',
    },
    submit: "S'inscrire",
  },
};

export default messages;
