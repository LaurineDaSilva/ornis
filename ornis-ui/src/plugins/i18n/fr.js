const messages = {
  // common
  required: '*',
  toastMessages: {
    errors: {
      global: "Une erreur s'est produite.",
    },
  },
  // Pages accessible to all users:
  header: {
    title: 'Ornis',
    home: 'Accueil',
    addBird: "Ajouter une espèce d'oiseau",
    login: 'Connexion',
  },
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
    nickname: {
      label: 'Pseudonyme',
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
    regex: '%*!',
    submit: "S'inscrire",
    toastMessages: {
      success: 'Compte utilisateur créé avec succès.',
      error: 'Erreur de serveur ou de validation.',
    },
  },
  // Admin pages:
  birdActionsMenu: {
    edit: 'Mettre à jour',
    delete: 'Supprimer',
    toastMessages: {
      success: 'Espèce supprimée avec succès.',
      error: 'Erreur de serveur.',
    },
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
    file: {
      label: 'Ajouter une image',
      helpText: 'Format .jpg ou .png.',
    },
    submit: "Ajouter l'espèce",
    toastMessages: {
      success: 'Espèce créée avec succès.',
      error: 'Erreur de serveur ou de validation.',
    },
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
    file: {
      label: "Modifier l'image",
      helpText: 'Format .jpg ou .png.',
    },
    submit: 'Mettre à jour',
    toastMessages: {
      success: 'Espèce mise à jour avec succès.',
      error: 'Erreur de serveur ou de validation.',
    },
  },
};

export default messages;
