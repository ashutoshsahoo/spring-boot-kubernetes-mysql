package com.ashu.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.practice.model.Pet;

public interface PetRepository extends JpaRepository<Pet, String> {

}
