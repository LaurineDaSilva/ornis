package co.simplon.ornis.repositories;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

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

    BirdDetail findProjectedDetailById(Long id);

    BirdToUpdate findProjectedById(Long id);

    boolean existsByScientificName(String string);

    boolean existsByCommonName(String string);

    @Query("SELECT b FROM Bird b WHERE "
	    + "LOWER(b.scientificName) LIKE LOWER(CONCAT('%', :searchText, '%')) OR "
	    + "LOWER(b.commonName) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    Collection<BirdView> findBirdsBySearchText(
	    @Param("searchText") String searchText);

    @Query("""
    	SELECT b FROM Bird b
    	LEFT JOIN b.colors c
    	LEFT JOIN b.beakShape bs
    	LEFT JOIN b.feetShape fs
    	LEFT JOIN b.size s
    	WHERE (:sizeId IS NULL OR s.id = :sizeId)
    	AND (:beakShapeId IS NULL OR bs.id = :beakShapeId)
    	AND (:feetShapeId IS NULL OR fs.id = :feetShapeId)
    	AND (c.name IN (:colors) OR :colors IS NULL)
    	GROUP BY b
    	HAVING COUNT(DISTINCT c) >= :colorCount OR :colors IS NULL
    	""")
    Collection<BirdView> findByHavingCharacteristics(
	    @Param("colors") Optional<Set<String>> colors,
	    @Param("colorCount") int colorCount,
	    @Param("beakShapeId") Optional<Long> beakShapeId,
	    @Param("feetShapeId") Optional<Long> feetShapeId,
	    @Param("sizeId") Optional<Long> sizeId);

}
