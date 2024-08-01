package com.PetAdminPanel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Entity
@Table(name="Pet")
public class Pet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private int quantity;
    private double price;
    private String specification;
    private String image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Breed getBreed() {
		return breed;
	}
	public void setBreed(Breed breed) {
		this.breed = breed;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Pet(long id, Breed breed, Category category, int quantity, double price, String specification,
			String image) {
		super();
		this.id = id;
		this.breed = breed;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.specification = specification;
		this.image = image;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", breed=" + breed + ", category=" + category + ", quantity=" + quantity + ", price="
				+ price + ", specification=" + specification + ", image=" + image + "]";
	}
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}

