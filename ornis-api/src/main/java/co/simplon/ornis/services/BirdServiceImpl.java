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

    private final BirdRepository birds;

    private final BirdColorService birdColorService;

    public BirdServiceImpl(FileStorage storage,
	    BirdRepository birds,
	    BirdColorService birdColorService) {
	this.storage = storage;
	this.birds = birds;
	this.birdColorService = birdColorService;
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
	    Optional<Set<String>> colors,
	    Optional<Long> beakShapeId,
	    Optional<Long> feetShapeId,
	    Optional<Long> sizeId) {

	int colorCount = colors.map(Set::size).orElse(0);
	return birds.findByHavingCharacteristics(colors,
		colorCount, beakShapeId, feetShapeId,
		sizeId);

    }

    @Override
    public BirdDetail getDetail(Long id) {
	return birds.findProjectedDetailById(id);
    }

    @Transactional
    @Override
    public void createBird(BirdCreate inputs) {
	Bird entity = new Bird();

	String scientificName = inputs.getScientificName();

	entity.setCommonName(inputs.getCommonName());

	entity.setScientificName(scientificName);

	entity.setDescription(inputs.getDescription());

	MultipartFile file = inputs.getFile();
	String baseName = UUID.randomUUID().toString();
	String fileName = storage.store(file, baseName);
	entity.setImage(fileName);

	entity.setXenoId(inputs.getXenoId());

	entity.setBeakShape(inputs.getBeakShape());

	entity.setFeetShape(inputs.getFeetShape());

	entity.setSize(inputs.getSize());

	birds.save(entity);

	if (inputs.getColorIds() != null) {
	    BirdToUpdate bird = birds
		    .findProjectedByScientificName(
			    scientificName);

	    Long birdId = bird.getId();

	    Set<Long> colorIds = inputs.getColorIds();

	    for (Long colorId : colorIds) {

		Long[] birdColorInputs = { birdId,
			colorId };
		birdColorService
			.createBirdColor(birdColorInputs);

	    }
	}

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

	entity.setXenoId(inputs.getXenoId());

	entity.setBeakShape(inputs.getBeakShape());

	entity.setFeetShape(inputs.getFeetShape());

	entity.setSize(inputs.getSize());

	if (inputs.getColorIds() != null) {

	    Set<Long> colorIds = inputs.getColorIds();

	    birdColorService.deleteBirdColors(id);

	    for (Long colorId : colorIds) {

		Long[] birdColorInputs = { id, colorId };

		birdColorService
			.createBirdColor(birdColorInputs);

	    }

	}

    }

    @Transactional
    @Override
    public void delete(Long id) {
	Bird entity = birds.findById(id).get();

	String imageName = entity.getImage();

	birdColorService.deleteBirdColors(id);

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

    @Override
    public boolean xenoIdExists(int xenoId)
	    throws UnsupportedOperationException {

	return this.birds.existsByXenoId(xenoId);
    }

}
