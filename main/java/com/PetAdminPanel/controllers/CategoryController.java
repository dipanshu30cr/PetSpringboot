package com.PetAdminPanel.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PetAdminPanel.entities.Breed;
import com.PetAdminPanel.entities.Category;
import com.PetAdminPanel.services.CategoryService;


@Controller
@RequestMapping("/Categories")
public class CategoryController {

    @Autowired 
    private CategoryService cs;
    
    @PostMapping("/register")
    public Category createCategory(@RequestBody Category category) {
        return cs.saveCategory(category);
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        cs.saveCategory(category);
        return "redirect:/Categories"; // Redirect to the category list page
    }

    @GetMapping
    public ModelAndView AllCategory() {
        List<Category> cl = cs.findAllCategory();
        return new ModelAndView("CategoryList", "categories", cl);
    }

    @GetMapping("/{id}")
    public Category getOne(@PathVariable Long id) {
        return cs.findCategoryById(id);
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        cs.DeleteCategoryById(id);
        return "redirect:/Categories"; // Redirect to the category list page after deletion
    }
    
    @RequestMapping("/edit/{id}")
	public String editLaptop(@PathVariable("id") long id, Model model)
	{	
		Category l3= cs.findCategoryById(id);
		model.addAttribute("categories", l3);
		return "CategoryEdit";
		
	}
    
    @PostMapping("/update")
	public String updateBreed(@ModelAttribute Category category) {
	   cs.saveCategory(category);
	    return "redirect:/Categories";
	}
    
    
    
    
}
