package model;

import java.time.LocalDate;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public abstract class Asset extends RecursiveTreeObject<Asset>{
	
	protected String name;
	protected double value;
	protected String category;
	protected LocalDate registrationDate;
	protected String description;
	protected String descriptionForDeregister;
	protected boolean active;
	
	
	public Asset(String name, double value, String category, LocalDate registrationDate, String description) {
		this.name = name;
		this.category = category;
		this.registrationDate = registrationDate;
		this.description = description;
		this.descriptionForDeregister = "";
		this.active = true;
	}


	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public String getDescription() {
		return description;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public void setDescriptionForDeregister(String descriptionForDeregister) {
		this.descriptionForDeregister = descriptionForDeregister;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
