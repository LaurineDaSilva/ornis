package co.simplon.ornis.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.services.SizeService;

@RestController
@RequestMapping("/sizes")
public class SizeController {

    private final SizeService service;

    public SizeController(SizeService service) {
	this.service = service;
    }

    @GetMapping
    public Collection<BirdPartView> getAll() {
	return service.getAll();
    }
}