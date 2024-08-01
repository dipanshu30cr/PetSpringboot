package com.PetAdminPanel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetAdminPanel.entities.Breed;
import com.PetAdminPanel.repositories.BreedRepository;

@Service
public class BreedService 
{
	@Autowired BreedRepository br;
	
	public List<Breed> allBreed()
	{
		return br.findAll();	
	}
	
	public Breed saveBreed(Breed breed)
	{
		return br.save(breed);
	}
	
	public void deleteBreedById(Long id)
	{
		br.deleteById(id);
	}
	
	public Breed findBreed(Long id)
	{
		return br.findById(id).orElse(null);
	}
		
}
