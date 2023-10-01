package co.simplon.ornis.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.BirdDetail;
import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.services.BirdService;

@RestController
@RequestMapping("/birds")
public class BirdController {

    private final BirdService service;

    public BirdController(BirdService service) {
	this.service = service;
    }

    @GetMapping("/en")
    public Collection<BirdView> getAllEn() {
	return service.getAllEn();
    }

    @GetMapping("/fr")
    public Collection<BirdView> getAllFr() {
	return service.getAllFr();
    }

    @GetMapping("/{id}/detail")
    public BirdDetail detail(@PathVariable("id") Long id) {
	return service.detail(id);
    }
}
