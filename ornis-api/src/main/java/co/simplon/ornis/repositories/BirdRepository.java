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

    @Query("SELECT b FROM Bird b JOIN b.colors c JOIN b.size s JOIN b.beakShape bs JOIN b.feetShape fs WHERE s.id= :sizeId AND bs.id = :beakShapeId AND fs.id = :feetShapeId AND c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByHavingAllCharacteristics(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount,
	    @Param("beakShapeId") Optional<Long> beakShapeId,
	    @Param("feetShapeId") Optional<Long> feetShapeId,
	    @Param("sizeId") Optional<Long> sizeId);

    @Query("SELECT b FROM Bird b JOIN b.colors c JOIN b.beakShape bs JOIN b.feetShape fs WHERE bs.id = :beakShapeId AND fs.id = :feetShapeId AND c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByColorsBeakShapeAndFeetShape(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount,
	    @Param("beakShapeId") Optional<Long> beakShapeId,
	    @Param("feetShapeId") Optional<Long> feetShapeId);

    @Query("SELECT b FROM Bird b JOIN b.colors c JOIN b.beakShape bs JOIN b.size s WHERE bs.id = :beakShapeId AND s.id = :sizeId AND c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByColorsBeakShapeAndSize(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount,
	    @Param("beakShapeId") Optional<Long> beakShapeId,
	    @Param("sizeId") Optional<Long> sizeId);

    @Query("SELECT b FROM Bird b JOIN b.colors c JOIN b.size s JOIN b.feetShape fs WHERE b.id = :sizeId AND fs.id = :feetShapeId AND c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByColorsFeetShapeAndSize(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount,
	    @Param("feetShapeId") Optional<Long> feetShapeId,
	    @Param("sizeId") Optional<Long> sizeId);

    @Query("SELECT b FROM Bird b JOIN b.size s JOIN b.beakShape bs JOIN b.feetShape fs WHERE s.id= :sizeId AND bs.id = :beakShapeId AND fs.id = :feetShapeId")
    Collection<BirdView> findByBeakShapeFeetShapeAndSize(
	    @Param("beakShapeId") Optional<Long> beakShapeId,
	    @Param("feetShapeId") Optional<Long> feetShapeId,
	    @Param("sizeId") Optional<Long> sizeId);

    @Query("SELECT b FROM Bird b JOIN b.colors c JOIN b.beakShape bs WHERE bs.id = :beakShapeId AND c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByColorsAndBeakShape(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount,
	    @Param("beakShapeId") Optional<Long> beakShapeId);

    @Query("SELECT b FROM Bird b JOIN b.colors c JOIN b.feetShape fs WHERE fs.id = :feetShapeId AND c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByColorsAndFeetShape(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount,
	    @Param("feetShapeId") Optional<Long> feetShapeId);

    @Query("SELECT b FROM Bird b JOIN b.colors c JOIN b.size s WHERE b.id = :sizeId AND c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByColorsAndSize(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount,
	    @Param("sizeId") Optional<Long> sizeId);

    @Query("SELECT b FROM Bird b JOIN b.beakShape bs JOIN b.feetShape fs WHERE bs.id = :beakShapeId AND fs.id = :feetShapeId")
    Collection<BirdView> findByFeetShapeAndBeakShape(
	    @Param("beakShapeId") Optional<Long> beakShapeId,
	    @Param("feetShapeId") Optional<Long> feetShapeId);

    @Query("SELECT b FROM Bird b JOIN b.size s JOIN b.feetShape fs WHERE s.id = :sizeId AND fs.id = :feetShapeId")
    Collection<BirdView> findByFeetShapeAndSize(
	    @Param("sizeId") Optional<Long> sizeId,
	    @Param("feetShapeId") Optional<Long> feetShapeId);

    @Query("SELECT b FROM Bird b JOIN b.beakShape bs JOIN b.size s WHERE bs.id = :beakShapeId AND s.id = :sizeId")
    Collection<BirdView> findByBeakShapeAndSize(
	    @Param("beakShapeId") Optional<Long> beakShapeId,
	    @Param("sizeId") Optional<Long> sizeId);

    @Query("SELECT b FROM Bird b JOIN b.colors c WHERE c.name IN (:colors) GROUP BY b HAVING COUNT(DISTINCT c) >= :colorCount")
    Collection<BirdView> findByColors(
	    @Param("colors") Set<String> colors,
	    @Param("colorCount") int colorCount);

    Collection<BirdView> findByBeakShapeId(
	    Optional<Long> beakShapeId);

    Collection<BirdView> findByFeetShapeId(
	    Optional<Long> feetShapeId);

    Collection<BirdView> findBySizeId(
	    Optional<Long> sizeId);

}
