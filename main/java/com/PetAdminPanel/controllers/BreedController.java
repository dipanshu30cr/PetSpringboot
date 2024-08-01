package com.PetAdminPanel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import com.PetAdminPanel.entities.Breed;
import com.PetAdminPanel.entities.Category;
import com.PetAdminPanel.services.BreedService;
import com.PetAdminPanel.services.CategoryService;





@Controller
@RequestMapping("/breed")
public class BreedController 
{	
	@Autowired BreedService bs;
	@Autowired CategoryService cs;

	
	
	 @GetMapping
	    public ModelAndView availableBreed() {
	        List<Breed> breedList = bs.allBreed(); // Fetch all items, including soft-deleted ones
	        return new ModelAndView("BreedList", "breeds", breedList);
	    }


	@GetMapping("/register")
    public String BreedRegister(Model model) {
        List<Category> clist = cs.findAllCategory();
        model.addAttribute("categories", clist);
        return "BreedRegister";
    }
	
	@PostMapping("/save")
    public String saveCategory(@ModelAttribute Breed breed, Model model) 
	{
        bs.saveBreed(breed);
        return "redirect:/breed"; // Redirect to the category list page
    }
	
	@PostMapping("/delete/{id}")
    public String deleteBreed(@PathVariable Long id) {
        //cs.DeleteCategoryById(id);
		bs.deleteBreedById(id);
        return "redirect:/breed"; // Redirect to the category list page after deletion
    }
	
//	@RequestMapping("/edit/{id}")
//	public String editBreed(@PathVariable("id") long id, Model model)
//	{	
//		Breed l3=bs.findBreed(id);
//		model.addAttribute("breeds", l3);
//		return "BreedEdit";
//			
//	}
	@GetMapping("/edit/{id}")
	public String editBreed(@PathVariable Long id, Model model) {
	    Breed breed = bs.findBreed(id);
	    List<Category> categories = cs.findAllCategory();
	    model.addAttribute("breed", breed);
	    model.addAttribute("categories", categories);
	    return "BreedEdit";
	}

	@PostMapping("/update")
	public String updateBreed(@ModelAttribute Breed breed) {
	    Category category = cs.findCategoryById(breed.getCid().getId());
	    breed.setCid(category);
	    bs.saveBreed(breed);
	    return "redirect:/breed";
	}

}
