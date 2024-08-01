package com.PetAdminPanel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PetAdminPanel.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}

