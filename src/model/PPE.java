package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PPE {
	
	Hashtable<String, List<Asset>> activeAssets;
	Hashtable<String, List<Asset>> removedAssets;
	
	
	public PPE() {
		activeAssets = new Hashtable<String, List<Asset>>();
		removedAssets = new Hashtable<String, List<Asset>>();
		
		activeAssets.put("Terreno", new ArrayList<Asset>());
		activeAssets.put("Edificio", new ArrayList<Asset>());
		activeAssets.put("Maquinaria y Equipo", new ArrayList<Asset>());
		activeAssets.put("Equipo de Computo", new ArrayList<Asset>());
		activeAssets.put("Equipo de Comunicación", new ArrayList<Asset>());
		activeAssets.put("Vehículos", new ArrayList<Asset>());
		activeAssets.put("Muebles", new ArrayList<Asset>());
	}
	
	
	
	public Hashtable<String, List<Asset>> getAssets() {
		return activeAssets;
	}

	public Hashtable<String, List<Asset>> getRemovedAssets() {
		return removedAssets;
	}
	
	
	
	private void addNewCategory(String category) {
		activeAssets.put(category, new ArrayList<Asset>());
	}
	
	
	private void addNewAsset(String name, double value, String category, LocalDate registrationDate, String description) {
		Asset terrain = new Terrain(name, value, category, registrationDate, description);
		activeAssets.get(category).add(terrain);
	}
	
	private void addNewAsset(String name, double value, String category, LocalDate registrationDate, double usefulLife, String usefulLifeMedition, String description, boolean otherCategory) {
		Asset asset = null;
		
		if(otherCategory) {
			asset = new OtherAsset(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
			
		}else {
			switch (category) {
				case "Terreno":
					asset = new Terrain(name, value, category, registrationDate, description);
					break;
		
				case "Edificio":
					asset = new Building(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
					break;
					
				case "Maquinaria y Equipo":
					asset = new MachineryEquipment(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
					break;
		
				case "Equipo de Computo":
					asset = new ComputerEquipment(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
					break;
				case "Equipo de Comunicación":
					asset = new CommunicationEquipment(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
					break;
					
				case "Vehículos":
					asset = new Vehicle(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
					break;
		
				case "Muebles":
					asset = new Furniture(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
					break;
				}
		}
		activeAssets.get(category).add(asset);
	}
	
	
	public void createNewAsset(String name, double value, String category, LocalDate registrationDate, String description, int n) {
		for (int i = 0; i < n; i++) {
			addNewAsset(name, value, category, registrationDate, description);
		}
	}
	
	public void createNewAsset(String name, double value, String category, LocalDate registrationDate, double usefulLife, String usefulLifeMedition, String description, boolean otherCategory, int n) {
		for (int i = 0; i < n; i++) {
			if(otherCategory) {
				addNewCategory(category);
			}
			
			addNewAsset(name, value, category, registrationDate, usefulLife, usefulLifeMedition, description, otherCategory);
		}
	}
}
