package co.simplon.ornis.services;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.ornis.dtos.BirdCreate;
import co.simplon.ornis.dtos.BirdDetail;
import co.simplon.ornis.dtos.BirdToUpdate;
import co.simplon.ornis.dtos.BirdUpdate;
import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.entities.Bird;
import co.simplon.ornis.repositories.BirdRepository;

@Service
@Transactional(readOnly = true)
public class BirdServiceImpl implements BirdService {

    private final FileStorage storage;

    private BirdRepository birds;

    public BirdServiceImpl(FileStorage storage,
	    BirdRepository birds) {
	this.storage = storage;
	this.birds = birds;
    }

    @Override
    public Collection<BirdView> getAll(Long id) {
	return birds.findAllProjectedBy();
    }

    @Override
    public BirdDetail getDetail(Long id) {
	return birds.findProjectedDetailById(id);
    }

    @Transactional
    @Override
    public void createBird(BirdCreate inputs) {
	Bird entity = new Bird();
	entity.setCommonName(inputs.getCommonName());
	entity.setScientificName(
		inputs.getScientificName());
	entity.setDescription(inputs.getDescription());
	MultipartFile file = inputs.getFile();
	String baseName = UUID.randomUUID().toString();
	String fileName = storage.store(file, baseName);
	entity.setImageName(fileName);
	birds.save(entity);
    }

    @Override
    public BirdToUpdate getBirdToUpdate(Long id) {
	return birds.findProjectedById(id);
    }

    @Transactional
    @Override
    public void updateBird(Long id, BirdUpdate inputs) {
	Bird entity = birds.findById(id).get();
	entity.setScientificName(
		inputs.getScientificName());
	entity.setCommonName(inputs.getCommonName());
	entity.setDescription(inputs.getDescription());
    }

    @Transactional
    @Override
    public void delete(Long id) {
	Bird entity = birds.findById(id).get();
	birds.delete(entity);
    }

}
