package com.PetAdminPanel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PetAdminPanel.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}