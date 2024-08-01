package com.PetAdminPanel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PetAdminPanel.entities.Breed;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long>{

}
