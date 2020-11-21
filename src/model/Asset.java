package model;

import java.time.LocalDate;


public abstract class Asset {
	
	protected String name;
	protected double value;
	protected String category;
	protected LocalDate registrationDate;
	protected String description;
	protected String descriptionForDeregister;
	protected boolean active;
	
	
	public Asset(String name, double value, String category, LocalDate registrationDate, String description) {
		this.name = name;
		this.value = value;
		this.category = category;
		this.registrationDate = registrationDate;
		this.description = description;
		this.descriptionForDeregister = "";
		this.active = true;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public LocalDate getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDescriptionForDeregister() {
		return descriptionForDeregister;
	}


	public void setDescriptionForDeregister(String descriptionForDeregister) {
		this.descriptionForDeregister = descriptionForDeregister;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	
	
	
	
}
