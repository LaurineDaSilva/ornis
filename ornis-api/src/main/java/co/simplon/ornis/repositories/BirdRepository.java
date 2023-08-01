package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.entities.Bird;

public interface BirdRepository
	extends JpaRepository<Bird, Long> {

    Collection<BirdView> findAllProjectedBy();

    @Query(value = "SELECT b.id as id, b.species_code as speciesCode, b.scientific_name as scientificName, en.common_name as commonName FROM birds b "
	    + "LEFT OUTER JOIN english_messages en on b.species_code = en.species_code;", nativeQuery = true)
    Collection<BirdView> findAllBirdsEnglish();

    @Query(value = "SELECT b.id as id, b.species_code as speciesCode, b.scientific_name as scientificName, fr.common_name as commonName FROM birds b "
	    + "LEFT OUTER JOIN french_messages fr on b.species_code = fr.species_code;", nativeQuery = true)
    Collection<BirdView> findAllBirdsFrench();
}
