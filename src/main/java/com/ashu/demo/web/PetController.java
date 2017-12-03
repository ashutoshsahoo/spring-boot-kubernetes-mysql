package com.ashu.demo.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.demo.model.Pet;
import com.ashu.demo.repository.PetRepository;

@RestController
@RequestMapping(value = "/api/pets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PetController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);

	private final PetRepository petRepository;

	public PetController(final PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@PostMapping
	public void create(@RequestBody Pet pet) {
		LOGGER.info("Crete method called with data : {}", pet);
		petRepository.save(pet);
	}

	@GetMapping
	public List<Pet> view() {
		LOGGER.info("View method called");
		return petRepository.findAll();
	}

}
