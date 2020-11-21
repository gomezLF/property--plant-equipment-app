package model;

import java.time.LocalDate;

import customInterface.Depreciation;

public class DepreciableAsset extends Asset implements Depreciation{
	
	private double residualValue;
	private double depreciation;
	private double usefulLife;
	private String usefulLifeMedition;
	
	
	
	public DepreciableAsset(String name, double value, String category, LocalDate registrationDate, String description, double usefulLife, String usefulLifeMedition) {
		super(name, value, category, registrationDate, description);
		
		this.depreciation = 0.0;
		this.usefulLife = usefulLife;
		this.usefulLifeMedition = usefulLifeMedition;
	}

	
	
	public double getResidualValue() {
		return residualValue;
	}
	
	public double getDepreciation() {
		return depreciation;
	}
	
	public void setDepreciation(double depreciation) {
		this.depreciation = depreciation;
	}

	public double getUsefulLyfe() {
		return usefulLife;
	}

	public void setUsefulLife(double usefulLife) {
		this.usefulLife = usefulLife;
	}

	public String getUsefulLifeMedition() {
		return usefulLifeMedition;
	}
	
	public DepreciableAsset(String name, double value, String category, LocalDate registrationDate, String description) {
		super(name, value, category, registrationDate, description);
	}




	@Override
	public void calculateDepreciation() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void deregisterForDepreciation() {
		// TODO Auto-generated method stub
		
	}

}
