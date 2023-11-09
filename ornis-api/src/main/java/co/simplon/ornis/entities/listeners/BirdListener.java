package co.simplon.ornis.entities.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import co.simplon.ornis.entities.Bird;
import co.simplon.ornis.repositories.BirdRepository;

public class BirdListener {

    private BirdRepository birds;

    public BirdListener(BirdRepository birds) {
	this.birds = birds;
    }

    @PrePersist
    @PreUpdate
    public void generateSpeciesCode(Bird bird) {
	String scientificName = bird.getScientificName();
	String[] words = scientificName.split(" ");
	StringBuilder speciesCodeBuilder = new StringBuilder();

	for (String word : words) {
	    if (word.length() >= 3) {
		speciesCodeBuilder
			.append(word.substring(0, 3));
	    } else {
		speciesCodeBuilder.append(word);
	    }
	}

	String speciesCode = speciesCodeBuilder.toString();
	int number = 1;

	while (birds.findBySpeciesCode(speciesCode)
		.isPresent()) {
	    speciesCode = speciesCode + number;
	    number++;
	}

	bird.setSpeciesCode(speciesCode);
    }
}
