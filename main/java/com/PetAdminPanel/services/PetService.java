package com.PetAdminPanel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetAdminPanel.entities.Pet;
import com.PetAdminPanel.repositories.PetRepository;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> allPets() {
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    public Pet findPet(Long id) {
        return petRepository.findById(id).orElse(null);
    }
}

