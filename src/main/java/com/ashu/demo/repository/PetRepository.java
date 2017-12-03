package com.ashu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.demo.model.Pet;

public interface PetRepository extends JpaRepository<Pet, String> {

}
