package co.simplon.ornis.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.BirdCreate;
import co.simplon.ornis.dtos.BirdDetail;
import co.simplon.ornis.dtos.BirdToUpdate;
import co.simplon.ornis.dtos.BirdUpdate;
import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.services.BirdService;

@RestController
@RequestMapping("/birds")
public class BirdController {

    private final BirdService service;

    public BirdController(BirdService service) {
	this.service = service;
    }

    @GetMapping("/list")
    public Collection<BirdView> getAll(Long id) {
	return service.getAll(id);
    }

    @GetMapping("/{id}/detail")
    public BirdDetail detail(@PathVariable("id") Long id) {
	return service.getDetail(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody @Valid BirdCreate inputs) {
	service.createBird(inputs);
    }

    @GetMapping("/{id}/to-update")
    public BirdToUpdate toUpdate(
	    @PathVariable("id") Long id) {
	return service.getBirdToUpdate(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id,
	    @ModelAttribute @Valid BirdUpdate inputs) {
	service.updateBird(id, inputs);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }
}
