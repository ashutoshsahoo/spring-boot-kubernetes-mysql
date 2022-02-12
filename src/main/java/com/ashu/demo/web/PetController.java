package com.ashu.demo.web;

import com.ashu.demo.model.Pet;
import com.ashu.demo.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(value = "/pets",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PetController {

    private final PetRepository petRepository;

    @PostMapping
    public void create(@RequestBody Pet pet) {
        log.info("Crete method called with data : {}", pet);
        petRepository.save(pet);
    }

    @GetMapping
    public List<Pet> view() {
        log.info("View method called");
        List<Pet> pets = petRepository.findAll();
        log.info("Pet list :{}", pets);
        return pets;
    }

}
