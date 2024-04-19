package co.simplon.ornis.services;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import co.simplon.ornis.dtos.birds.BirdCreate;
import co.simplon.ornis.dtos.birds.BirdDetail;
import co.simplon.ornis.dtos.birds.BirdToUpdate;
import co.simplon.ornis.dtos.birds.BirdUpdate;
import co.simplon.ornis.dtos.birds.BirdView;

public interface BirdService {

    Collection<BirdView> getAll(Long id);

    Collection<BirdView> searchBirds(String searchText);

    Collection<BirdView> filterBirds(
	    Optional<Set<String>> colors,
	    Optional<Long> beakShapeId,
	    Optional<Long> feetShapeId,
	    Optional<Long> sizeId);

    BirdDetail getDetail(Long id);

    void createBird(BirdCreate inputs);

    BirdToUpdate getBirdToUpdate(Long id);

    void updateBird(Long id, BirdUpdate inputs);

    void delete(Long id);

    public boolean scientificNameExists(
	    String scientificName);

    public boolean commonNameExists(String commonName);

    public boolean xenoIdExists(int xenoId);

}
