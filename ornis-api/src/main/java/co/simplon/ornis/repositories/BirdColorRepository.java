package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.ornis.dtos.birds.BirdColorDto;
import co.simplon.ornis.entities.BirdColor;

public interface BirdColorRepository
	extends JpaRepository<BirdColor, Long> {

    Collection<BirdColorDto> findAllByBirdId(Long birdId);

    @Modifying
    @Query("DELETE FROM BirdColor bc WHERE bc.birdId = :birdId")
    void deleteByBirdId(@Param("birdId") Long birdId);

}
