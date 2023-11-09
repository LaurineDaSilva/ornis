package co.simplon.ornis.entities.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import co.simplon.ornis.entities.Bird;

public class BirdListener {

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

	bird.setSpeciesCode(speciesCodeBuilder.toString());
    }
}
