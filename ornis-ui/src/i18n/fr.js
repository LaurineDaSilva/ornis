const messages = {
  // Pages accessible to all users:
  birdsList: {
    title: 'Liste des oiseaux de France',
    imageAlt: '{name} (photo)',
  },
  birdDetail: {
    description: {
      title: 'Description',
    },
  },
  // Authentication pages:
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
    submit: "S'inscrire",
  },
  // Admin pages:
  birdActionsMenu: {
    edit: 'Mettre à jour',
    delete: 'Supprimer',
  },
  createBird: {
    title: "Ajouter une espèce d'oiseau",
    scientificName: {
      label: 'Nom scientifique',
      helpText: '100 caractères maximum. Doit être unique.',
    },
    commonName: {
      label: 'Nom commun',
      helpText: '200 caractères maximum. Doit être unique.',
    },
    description: {
      label: 'Description',
      helpText: '5000 caractères maximum.',
    },
    submit: "Ajouter l'oiseau",
  },
  updateBird: {
    title: "Mettre à jour l'espèce",
    scientificName: {
      label: 'Nom scientifique',
      helpText: '100 caractères maximum. Doit être unique.',
    },
    commonName: {
      label: 'Nom commun',
      helpText: '200 caractères maximum. Doit être unique.',
    },
    description: {
      label: 'Description',
      helpText: '5000 caractères maximum.',
    },
    submit: 'Mettre à jour',
  },
};

export default messages;
