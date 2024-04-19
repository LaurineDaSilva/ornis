package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.ornis.dtos.birds.BirdColorDto;
import co.simplon.ornis.entities.BirdColor;
import co.simplon.ornis.repositories.BirdColorRepository;

@Service
@Transactional(readOnly = true)
public class BirdColorServiceImpl
	implements BirdColorService {

    private BirdColorRepository birdColors;

    public BirdColorServiceImpl(
	    BirdColorRepository birdColors) {
	this.birdColors = birdColors;
    }

    @Transactional
    @Override
    public void createBirdColor(Long[] inputs) {
	BirdColor entity = new BirdColor();

	entity.setBirdId(inputs[0]);

	entity.setColorId(inputs[1]);

	birdColors.save(entity);
    }

    @Override
    public Collection<BirdColorDto> getOneBirdColors(
	    Long birdId) {
	return birdColors.findAllByBirdId(birdId);
    };
}
