package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import customInterface.Depreciation;

public class DepreciableAsset extends Asset implements Depreciation{
	
	private double residualValue;
	private double depreciation;
	private double depreciationRate;
	private double usefulLife;
	private String usefulLifeMedition;
	
	
	
	public DepreciableAsset(String name, double value, String category, LocalDate registrationDate, String description, double usefulLife, String usefulLifeMedition) {
		super(name, value, category, registrationDate, description);
		
		this.depreciation = 0.0;
		this.depreciationRate = 0.0;
		this.usefulLife = usefulLife;
		this.usefulLifeMedition = usefulLifeMedition;
		
		calculateDepreciationRate();
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
	
	public double getDepreciationRate() {
		return depreciationRate;
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
	public void calculateDepreciation(LocalDate toDate) {
		long intervalMonths = ChronoUnit.MONTHS.between(registrationDate, toDate);
		
		depreciation = (depreciationRate * intervalMonths)/12;
	}




	@Override
	public void deregisterForDepreciation() {
		
	}



	@Override
	public void calculateDepreciationRate() {
		depreciationRate = (value - residualValue)/usefulLife;
	}

}
