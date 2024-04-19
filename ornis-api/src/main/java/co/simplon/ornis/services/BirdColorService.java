package co.simplon.ornis.services;

import java.util.Collection;

import co.simplon.ornis.dtos.birds.BirdColorDto;

public interface BirdColorService {

    void createBirdColor(Long[] birdColorInputs);

    Collection<BirdColorDto> getOneBirdColors(Long birdId);

}
