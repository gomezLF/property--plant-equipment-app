package model;

import java.time.LocalDate;

public class NonDepreciableAsset extends Asset{

	public NonDepreciableAsset(String name, double value, String category, LocalDate registrationDate, String description) {
		super(name, value, category, registrationDate, description);
	}
	
}
