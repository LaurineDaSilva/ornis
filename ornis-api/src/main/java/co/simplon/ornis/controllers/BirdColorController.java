package co.simplon.ornis.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.birds.BirdColorDto;
import co.simplon.ornis.services.BirdColorService;

@RestController
@RequestMapping("/birdsColors")
public class BirdColorController {

    private final BirdColorService service;

    public BirdColorController(BirdColorService service) {
	this.service = service;
    }

    @GetMapping("/{birdId}/list")
    public Collection<BirdColorDto> getAll(
	    @PathVariable("birdId") Long birdId) {
	return service.getOneBirdColors(birdId);
    }

    @DeleteMapping("/{birdId}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
	    @PathVariable("birdId") Long birdId) {
	service.deleteBirdColors(birdId);
    }

}
