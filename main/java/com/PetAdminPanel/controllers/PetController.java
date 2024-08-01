package com.PetAdminPanel.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.PetAdminPanel.entities.Breed;
import com.PetAdminPanel.entities.Category;
import com.PetAdminPanel.entities.Pet;
import com.PetAdminPanel.services.BreedService;
import com.PetAdminPanel.services.CategoryService;
import com.PetAdminPanel.services.PetService;
@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;
    
    @Autowired
    private BreedService breedService;
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView availablePets() {
        List<Pet> petList = petService.allPets();
        return new ModelAndView("PetList", "pets", petList);
    }

    @GetMapping("/register")
    public String showPetRegisterForm(Model model) {
        model.addAttribute("breeds", breedService.allBreed());
        model.addAttribute("pet", new Pet());
        return "PetRegister";
    }

    @PostMapping("/save")
    public String savePet(@RequestParam("breed.id") Long breedId, 
    		@RequestParam("breed.Cid.name") String breedCategoryName,
    		@RequestParam int quantity,
    		@RequestParam double price,
    		@RequestParam String specification,
    		@RequestParam("image") MultipartFile imageFile
    		) {

    	
//    	Pet pet = new Pet(); 
//    	pet.setId(breedId);
//    	pet.setCategory(breedCategoryName);
//    	pet.setQuantity(quantity);
//    	pet.setPrice(price);
//    	pet.setSpecification(specification);
//    	pet.setImage(imageFile);
    	
    	//pet.setBreed(null)
    	System.out.println("\n\nBreed Id : "+breedId);
//    	petService.savePet(pet);
        return "redirect:/pet";
    }

    @PostMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return "redirect:/pet";
    }

    @GetMapping("/edit/{id}")
    public String editPet(@PathVariable Long id, Model model) {
        Pet pet = petService.findPet(id);
        List<Breed> breeds = breedService.allBreed();
        model.addAttribute("pet", pet);
        model.addAttribute("breeds", breeds);
        return "PetEdit";
    }

    @PostMapping("/update")
    public String updatePet(@ModelAttribute Pet pet, @RequestParam("imageFile") MultipartFile imageFile, Model model) {
        // Handle the file upload
        if (!imageFile.isEmpty()) {
            try {
                // Convert the image file to a String (base64 encoded string or store it as a file)
                String imageString = new String(imageFile.getBytes());
                pet.setImage(imageString);  // Assuming setImage accepts a String
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the error
                model.addAttribute("error", "Failed to upload image");
                return "PetEdit";
            }
        }

        // Set the category based on the breed
        pet.setCategory(breedService.findBreed(pet.getBreed().getId()).getCid());
        petService.savePet(pet);
        return "redirect:/pet";
    }

    @GetMapping("/getCategoryByBreed/{breedId}")
    @ResponseBody
    public Category getCategoryByBreed(@PathVariable Long breedId) {
        Breed breed = breedService.findBreed(breedId);
        return breed.getCid();
    }
}

