package com.PetAdminPanel.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetAdminPanel.entities.Category;
import com.PetAdminPanel.repositories.CategoryRepository;



@Service
public class CategoryService 
{
	@Autowired CategoryRepository cr;
	
	
	public Category saveCategory(Category c)
	{
		return cr.save(c);
	}
	
	public List<Category> findAllCategory()
	{
		return cr.findAll();
	}
	
	public Category findCategoryById(long id)
	{
		return cr.findById(id).orElse(null);
	}
	
	public void DeleteCategoryById(long id)
	{
		cr.deleteById(id);
	}
	
	public Category getCategoryById(long id) {
        return cr.findById(id).orElse(null);
    }

}
