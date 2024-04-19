package co.simplon.ornis.services;

import java.util.Collection;

import co.simplon.ornis.dtos.birds.BirdColorDto;

public interface BirdColorService {

    Collection<BirdColorDto> getOneBirdColors(Long birdId);

    void createBirdColor(Long[] inputs);

    void deleteBirdColors(Long birdId);

}
