package model;

import java.time.LocalDate;

import customInterface.Depreciation;

public class CommunicationEquipment extends Asset implements Depreciation{
	
	private double depreciation;
	private double usefulLife;
	private String usefulLifeMedition;
	
	
	
	public CommunicationEquipment(String name, double value, String category, LocalDate registrationDate, String description, double usefulLife, String usefulLifeMedition) {
		super(name, value, category, registrationDate, description);
		
		this.depreciation = 0.0;
		this.usefulLife = usefulLife;
		this.usefulLifeMedition = usefulLifeMedition;
	}

	
	
	public double getDepreciation() {
		return depreciation;
	}
	
	public void setDepreciation(double depreciation) {
		this.depreciation = depreciation;
	}

	public double getUsefulLife() {
		return usefulLife;
	}

	public void setUsefulLife(double usefulLyfe) {
		this.usefulLife = usefulLyfe;
	}

	public String getUsefulLifeMedition() {
		return usefulLifeMedition;
	}



	@Override
	public void calculateDepreciation() {
		
		
	}

	@Override
	public void deregisterForDepreciation() {
		
		
	}
}