package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import customInterface.Depreciation;

public class DepreciableAsset extends Asset implements Depreciation{
	
	private double residualValue;
	private double depreciation;
	private double depreciationRate;
	private double usefulLife;
	private String usefulLifeMedition;
	private LocalDate lastCutoffDate;
	private int countYears;
	
	
	
	public DepreciableAsset(String name, double value, double residualValue, String category, LocalDate registrationDate, String description, double usefulLife, String usefulLifeMedition) {
		super(name, value, category, registrationDate, description);
		
		this.residualValue = residualValue;
		this.depreciation = 0.0;
		this.depreciationRate = 0.0;
		this.usefulLife = usefulLife;
		this.usefulLifeMedition = usefulLifeMedition;
		this.lastCutoffDate = registrationDate;
		this.countYears = 0;
		
		calculateDepreciationRate();
	}

	
	
	public String getValue() {
		calculateDepreciation(LocalDate.now());
		return roundDouble(value - depreciation);
	}
	
	public double getResidualValue() {
		return residualValue;
	}
	
	public String getDepreciation() {
		return roundDouble(depreciation);
	}
	
	public void setDepreciation(double depreciation) {
		this.depreciation = depreciation;
	}
	
	public String getDepreciationRate() {
		return roundDouble(depreciationRate);
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
	
	public int getYears() {
		return countYears;
	}
	


	@Override
	public void calculateDepreciation(LocalDate toDate) {
		if(active) {
			long intervalMonths = ChronoUnit.MONTHS.between(lastCutoffDate, toDate);
			
			if(intervalMonths > 0 && intervalMonths >= 12) {
					while(intervalMonths >= 12) {
					
					depreciation = depreciation + depreciationRate;
					countYears++;
					
					intervalMonths = intervalMonths - 12;
				}
			}
			
			if(intervalMonths > 0 && intervalMonths < 12) {
				depreciation = depreciation +  ((depreciationRate * intervalMonths)/12);
			}
			
			lastCutoffDate = toDate;
		}
	}

	@Override
	public void deregisterForDepreciation() {
		
	}

	@Override
	public void calculateDepreciationRate() {
		depreciationRate = ((value - residualValue)/usefulLife);
		
	}

	@Override
	public void calculateNetWorth() {
		
	}
	
	
	private String roundDouble(double d) {
	    DecimalFormat df= new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	    df.setMaximumFractionDigits(2);
	    df.setMaximumIntegerDigits(100);
	    
	    return df.format(d);
	}
	
}
