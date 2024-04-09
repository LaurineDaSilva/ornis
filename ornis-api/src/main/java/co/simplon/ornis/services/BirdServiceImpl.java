package co.simplon.ornis.services;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.ornis.dtos.birds.BirdCreate;
import co.simplon.ornis.dtos.birds.BirdDetail;
import co.simplon.ornis.dtos.birds.BirdToUpdate;
import co.simplon.ornis.dtos.birds.BirdUpdate;
import co.simplon.ornis.dtos.birds.BirdView;
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
    public Collection<BirdView> searchBirds(
	    String searchText) {
	return birds.findBirdsBySearchText(searchText);
    }

    @Override
    public Collection<BirdView> filterBirds(
	    Set<String> colors, Optional<Long> beakShapeId,
	    Optional<Long> feetShapeId) {

	int colorCount = colors.size();
	Collection<BirdView> filteredBirds = null;

	// no parameters
	if (colors.isEmpty() && beakShapeId.isEmpty()
		&& feetShapeId.isEmpty()) {

	    filteredBirds = birds.findAllProjectedBy();

	    // all parameters
	} else if (!colors.isEmpty()
		&& beakShapeId.isPresent()
		&& feetShapeId.isPresent()) {

	    filteredBirds = birds
		    .findByHavingAllCharacteristics(colors,
			    colorCount, beakShapeId,
			    feetShapeId);

	    // only beakShape and feetShape
	} else if (colors.isEmpty()
		&& beakShapeId.isPresent()
		&& feetShapeId.isPresent()) {

	    filteredBirds = birds
		    .findByFeetShapeAndBeakShape(
			    beakShapeId, feetShapeId);

	    // only colors and feetShape
	} else if (!colors.isEmpty()
		&& beakShapeId.isEmpty()
		&& feetShapeId.isPresent()) {

	    filteredBirds = birds.findByColorsAndFeetShape(
		    colors, colorCount, feetShapeId);

	    // only colors and beakShape
	} else if (!colors.isEmpty()
		&& beakShapeId.isPresent()
		&& feetShapeId.isEmpty()) {

	    filteredBirds = birds.findByColorsAndBeakShape(
		    colors, colorCount, beakShapeId);

	    // only colors
	} else if (!colors.isEmpty()
		&& beakShapeId.isEmpty()
		&& feetShapeId.isEmpty()) {

	    filteredBirds = birds.findByColors(colors,
		    colorCount);

	    // only beakShape
	} else if (colors.isEmpty()
		&& beakShapeId.isPresent()
		&& feetShapeId.isEmpty()) {

	    filteredBirds = birds
		    .findByBeakShapeId(beakShapeId);

	    // only feetShape
	} else if (colors.isEmpty() && beakShapeId.isEmpty()
		&& feetShapeId.isPresent()) {

	    filteredBirds = birds
		    .findByFeetShapeId(feetShapeId);
	}

	return filteredBirds;

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
	entity.setImage(fileName);
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
	MultipartFile file = inputs.getFile();
	if (file != null) {
	    String original = entity.getImage();
	    String baseName = UUID.randomUUID().toString();
	    String newFullName = storage.replace(file,
		    baseName, original);
	    entity.setImage(newFullName);
	}
    }

    @Transactional
    @Override
    public void delete(Long id) {
	Bird entity = birds.findById(id).get();
	String imageName = entity.getImage();
	birds.delete(entity);
	storage.delete(imageName);
    }

    @Override
    public boolean scientificNameExists(
	    String scientificName)
	    throws UnsupportedOperationException {

	return this.birds.existsByScientificName(
		scientificName.toString());
    }

    @Override
    public boolean commonNameExists(String commonName)
	    throws UnsupportedOperationException {

	return this.birds
		.existsByCommonName(commonName.toString());
    }

}
