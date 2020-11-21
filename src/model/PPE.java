package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import customException.NoDataRegisteredException;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	
	public void checkAvailableAssets() throws NoDataRegisteredException{
		if(activeAssets.isEmpty()) {
			throw new NoDataRegisteredException();
		}
	}
	
	private void addNewCategory(String category) {
		activeAssets.put(category, new ArrayList<Asset>());
	}
	
	
	private void addNewAsset(String name, double value, String category, LocalDate registrationDate, String description) {
		Asset terrain = new NonDepreciableAsset(name, value, category, registrationDate, description);
		activeAssets.get(category).add(terrain);
		
		System.out.println(activeAssets.get(category).size());
		System.out.println(activeAssets.get(category));
	}
	
	private void addNewAsset(String name, double value, String category, LocalDate registrationDate, double usefulLife, String usefulLifeMedition, String description) {
		Asset asset = new DepreciableAsset(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
		activeAssets.get(category).add(asset);
		
		System.out.println(activeAssets.get(category).size());
		System.out.println(activeAssets.get(category));
		
	}
	
	
	
	public void createNewAsset(String name, double value, String category, LocalDate registrationDate, String description, int n) {
		for (int i = 0; i < n; i++) {
			addNewAsset(name, value, category, registrationDate, description);
		}
	}
	
	public void createNewAsset(String name, double value, String category, LocalDate registrationDate, double usefulLife, String usefulLifeMedition, String description, boolean otherCategory, int n) {
		if(otherCategory) {
			addNewCategory(category);
		}
		
		for (int i = 0; i < n; i++) {
			addNewAsset(name, value, category, registrationDate, usefulLife, usefulLifeMedition, description);
		}
	}
}
