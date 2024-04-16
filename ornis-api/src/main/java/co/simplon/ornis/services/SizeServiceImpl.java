package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.repositories.SizeRepository;

@Service
@Transactional(readOnly = true)
public class SizeServiceImpl implements SizeService {

    private final SizeRepository sizes;

    public SizeServiceImpl(SizeRepository sizes) {
	this.sizes = sizes;
    }

    @Override
    public Collection<BirdPartView> getAll() {
	return sizes.findAllProjectedBy();
    }

}
