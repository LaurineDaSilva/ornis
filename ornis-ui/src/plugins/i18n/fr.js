const messages = {
  // common
  required: '*',

  // errors
  toastMessages: {
    errors: {
      global: "Une erreur s'est produite.",
      undefined: 'Erreur de serveur ou de validation',
      emailAddress: {
        unicity: 'Un compte avec cette adresse email existe déjà.',
      },
      nickname: {
        unicity: "Un compte avec ce nom d'utilisateur existe déjà.",
      },
      scientificName: {
        unicity: 'Ce nom scientifique est déjà enregistré.',
      },
      commonName: {
        unicity: 'Ce nom commun est déjà enregistré.',
      },
      xenoId: {
        unicity: 'Ce Xeno Id est déjà utilisé',
      },
    },
  },

  // Components accessible to all users:
  header: {
    title: 'Ornis',
    home: 'Accueil',
    addBird: "Ajouter une espèce d'oiseau",
    login: 'Connexion',
  },

  birds: {
    list: {
      title: 'Oiseaux de France',
      imageAlt: '{name} (photo)',
      error: "La liste des oiseaux n'a pu être chargée.",
    },

    nameFilter: {
      placeholder: 'Rechercher des oiseaux',
      submit: 'Rechercher',
    },

    advancedFilters: {
      button: 'Recherche avancée',
      labels: {
        colors: 'Couleurs',
        size: 'Gabarit',
        beakShape: 'Forme de bec',
        feetShape: 'Forme de patte',
      },
      submit: 'Rechercher',
    },

    detail: {
      description: {
        title: 'Description',
      },
    },
  },

  // Authentication components:
  signUp: {
    title: 'Inscription',
    username: {
      label: 'Pseudonyme',
      helpText: '20 caractères maximum. Doit être unique.',
    },
    emailAddress: {
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
    },
  },

  signIn: {
    title: 'Connexion',
    usernameOrEmailAddress: {
      label: "Nom d'utilisateur ou adresse email",
    },
    password: {
      label: 'Mot de passe',
    },
    submit: 'Se connecter',
    toastMessages: {
      success: 'Bienvenue !',
    },
  },

  signOut: 'Déconnexion',

  // Admin components:
  birdActionsMenu: {
    edit: 'Mettre à jour',
    delete: 'Supprimer',
    toastMessages: {
      success: 'Espèce supprimée avec succès.',
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
    },
  },
};

export default messages;
