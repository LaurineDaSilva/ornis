package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.repositories.BirdRepository;

@Service
public class BirdServiceImpl implements BirdService {

    private BirdRepository birds;
    private RestTemplate template = new RestTemplate();

    @Value("${apiUrl}")
    private String apiUrl;

    public BirdServiceImpl(BirdRepository birds) {
	this.birds = birds;
    }

    @Override
    public Collection<BirdView> getAll() {
	// TODO Auto-generated method stub
	return birds.findAllProjectedBy();
    }

    @Override
    @Autowired
    public Object[] findFrenchBirds() {
	return template.getForObject(this.apiUrl,
		Object[].class);
    }

}
