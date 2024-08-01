package com.PetAdminPanel.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Breed")
public class Breed 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String bname;
	private String specification;
	
	 @ManyToOne
	 @JoinColumn(name = "cid")
	 private Category cid;
	 
	 
	

	public Breed(long id, String bname, String specification, Category cid) {
		super();
		this.id = id;
		this.bname = bname;
		this.specification = specification;
		this.cid = cid;
	}

	public Breed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Category getCid() {
		return cid;
	}

	public void setCid(Category cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Breed [id=" + id + ", bname=" + bname + ", specification=" + specification + ", cid=" + cid + "]";
	}

	
	 

}
