package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import customException.NoDataRegisteredException;
import javafx.util.converter.LocalDateStringConverter;

public class PPE {
	
	Hashtable<String, List<Asset>> depreciableAssetsActive;
	Hashtable<String, List<Asset>> nonDepreciableAssetsActive;
	Hashtable<String, List<Asset>> removedAssets;
	
	
	public PPE() {
		depreciableAssetsActive = new Hashtable<String, List<Asset>>();
		nonDepreciableAssetsActive = new Hashtable<String, List<Asset>>();
		removedAssets = new Hashtable<String, List<Asset>>();
		
		depreciableAssetsActive.put("Edificio", new ArrayList<Asset>());
		depreciableAssetsActive.put("Maquinaria y Equipo", new ArrayList<Asset>());
		depreciableAssetsActive.put("Equipo de Computo", new ArrayList<Asset>());
		depreciableAssetsActive.put("Equipo de Comunicación", new ArrayList<Asset>());
		depreciableAssetsActive.put("Vehículos", new ArrayList<Asset>());
		depreciableAssetsActive.put("Muebles", new ArrayList<Asset>());
		
		nonDepreciableAssetsActive.put("Terreno", new ArrayList<Asset>());
		nonDepreciableAssetsActive.put("Construcciones en curso", new ArrayList<Asset>());
		nonDepreciableAssetsActive.put("Maquinaria y Equipo en montaje", new ArrayList<Asset>());
		
		proof();
	}
	
	private void proof() {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.parse("2020-01-21");
		LocalDate date3 = LocalDate.parse("2020-06-21");
		LocalDate date4 = LocalDate.parse("2019-11-21");
		
		
		addNewDepreciableAsset("Camisetas Marca S", 100000, "Prendas de Vestir", date1, 3, "Años", "", true, 20);
		addNewDepreciableAsset("Camisetas Marca S", 100000, "Prendas de Vestir", date2, 3, "Años", "", false, 20);
		addNewDepreciableAsset("Camisetas Marca S", 100000, "Prendas de Vestir", date3, 3, "Años", "", false, 20);
		addNewDepreciableAsset("Camisetas Marca S", 100000, "Prendas de Vestir", date4, 3, "Años", "", false, 20);
		
		addNewDepreciableAsset("Vehiculos de Carga", 10000000, "Vehículos", date1, 20, "Años", "", false, 2);
		addNewDepreciableAsset("Vehiculos de Carga", 10000000, "Vehículos", date2, 20, "Años", "", false, 2);
		addNewDepreciableAsset("Vehiculos de Carga", 10000000, "Vehículos", date3, 20, "Años", "", false, 2);
		addNewDepreciableAsset("Vehiculos de Carga", 10000000, "Vehículos", date4, 20, "Años", "", false, 2);
		
		addNewDepreciableAsset("Computadores Marca Dell", 2000000, "Equipo de Computo", date1, 5, "Años", "", false, 10);
		addNewDepreciableAsset("Computadores Marca Dell", 2000000, "Equipo de Computo", date2, 5, "Años", "", false, 10);
		addNewDepreciableAsset("Computadores Marca Dell", 2000000, "Equipo de Computo", date3, 5, "Años", "", false, 10);
		addNewDepreciableAsset("Computadores Marca Dell", 2000000, "Equipo de Computo", date4, 5, "Años", "", false, 10);
		
		
		
	}
	
	
	
	
	public Hashtable<String, List<Asset>> getDerpeciableAssets() {
		return depreciableAssetsActive;
	}
	
	public Hashtable<String, List<Asset>> getNonDepreciableAsset(){
		return nonDepreciableAssetsActive;
	}

	public Hashtable<String, List<Asset>> getRemovedAssets() {
		return removedAssets;
	}
	
	
	
	
	public void checkAvailableDepreciableAssets(String category) throws NoDataRegisteredException{
		if(depreciableAssetsActive.get(category).isEmpty()) {
			throw new NoDataRegisteredException();
		}
	}
	
	public void checkAvailableNonDepreciableAssets(String category) throws NoDataRegisteredException{
		if(nonDepreciableAssetsActive.get(category).isEmpty()) {
			throw new NoDataRegisteredException();
		}
	}
	
	public void checkAvailableRemovedAssets(String category) throws NoDataRegisteredException{
		if(removedAssets.isEmpty() || removedAssets.get(category).isEmpty()) {
			throw new NoDataRegisteredException();
		}
	}
	
	
	
	
	private void createNewDepreciableCategory(String category) {
		depreciableAssetsActive.put(category, new ArrayList<Asset>());
	}
	
	private void createNewNonDepreciableCategory(String category) {
		nonDepreciableAssetsActive.put(category, new ArrayList<Asset>());
	}
	
	private void createNewRemovedCategory(String category) {
		removedAssets.put(category, new ArrayList<Asset>());
	}
	
	
	
	
	private void createNewDepreciableAsset(String name, double value, String category, LocalDate registrationDate, double usefulLife, String usefulLifeMedition, String description) {
		Asset depreciableAsset = new DepreciableAsset(name, value, category, registrationDate, description, usefulLife, usefulLifeMedition);
		depreciableAssetsActive.get(category).add(depreciableAsset);
	}
	
	private void createNewNonDepreciableAsset(String name, double value, String category, LocalDate registrationDate, String description) {
		Asset nonDepreciableAsset = new NonDepreciableAsset(name, value, category, registrationDate, description);
		nonDepreciableAssetsActive.get(category).add(nonDepreciableAsset);
	}
	
	
	
	
	public void addNewDepreciableAsset(String name, double value, String category, LocalDate registrationDate, double usefulLife, String usefulLifeMedition, String description, boolean otherCategory, int n) {
		if(otherCategory) {
			createNewDepreciableCategory(category);
		}
		
		for (int i = 0; i < n; i++) {
			createNewDepreciableAsset(name, value, category, registrationDate, usefulLife, usefulLifeMedition, description);
		}
	}
	
	public void addNewNonDepreciableAsset(String name, double value, String category, LocalDate registrationDate, String description, boolean otherCategory, int n) {
		if(otherCategory) {
			createNewNonDepreciableCategory(category);
		}
		
		for (int i = 0; i < n; i++) {
			createNewNonDepreciableAsset(name, value, category, registrationDate, description);
		}
	}
	
	public void addNewRemovedAsset(Asset asset) {
		if(!removedAssets.containsKey(asset.getCategory())) {
			createNewRemovedCategory(asset.getCategory());
		}
		
		removedAssets.get(asset.getCategory()).add(asset);
	}
}
