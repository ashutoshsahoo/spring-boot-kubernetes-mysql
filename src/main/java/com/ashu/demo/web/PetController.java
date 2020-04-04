package com.ashu.demo.web;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.demo.model.Pet;
import com.ashu.demo.repository.PetRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/pets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PetController {

	private final PetRepository petRepository;

	public PetController(final PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@PostMapping
	public void create(@RequestBody Pet pet) {
		log.info("Crete method called with data : {}", pet);
		petRepository.save(pet);
	}

	@GetMapping
	public List<Pet> view() {
		log.info("View method called");
		return petRepository.findAll();
	}

}
