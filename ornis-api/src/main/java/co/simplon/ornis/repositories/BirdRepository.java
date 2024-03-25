package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.ornis.dtos.birds.BirdDetail;
import co.simplon.ornis.dtos.birds.BirdToUpdate;
import co.simplon.ornis.dtos.birds.BirdView;
import co.simplon.ornis.entities.Bird;

public interface BirdRepository
	extends JpaRepository<Bird, Long> {

    Collection<BirdView> findAllProjectedBy();

    @Query("SELECT b FROM Bird b WHERE "
	    + "LOWER(b.scientificName) LIKE LOWER(CONCAT('%', :searchText, '%')) OR "
	    + "LOWER(b.commonName) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    Collection<BirdView> findBirdsBySearchText(
	    @Param("searchText") String searchText);

    BirdDetail findProjectedDetailById(Long id);

    BirdToUpdate findProjectedById(Long id);

    boolean existsByScientificName(String string);

    boolean existsByCommonName(String string);

}
