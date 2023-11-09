package co.simplon.ornis.services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import co.simplon.ornis.dtos.BirdCreate;
import co.simplon.ornis.dtos.BirdDetail;
import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.entities.Bird;
import co.simplon.ornis.repositories.BirdRepository;

@Service
public class BirdServiceImpl implements BirdService {

    private BirdRepository birds;

    public BirdServiceImpl(BirdRepository birds) {
	this.birds = birds;
    }

    @Override
    public Collection<BirdView> getAll(Long id) {
	return birds.findAllProjectedBy();
    }

    @Override
    public BirdDetail detail(Long id) {
	return birds.findProjectedDetailById(id);
    }

    @Transactional // read only = false
    @Override
    public void create(BirdCreate inputs) {
	String[] scientificName = inputs.getScientificName()
		.split(" ");
	Bird entity = new Bird();

	entity.setSpeciesCode(
		scientificName[0].substring(0, 3).concat(
			scientificName[1].substring(0, 3)));
	entity.setScientificName(
		inputs.getScientificName());
	entity.setCommonName(inputs.getCommonName());
	entity.setDescription(inputs.getDescription());
	birds.save(entity);
    }

}
