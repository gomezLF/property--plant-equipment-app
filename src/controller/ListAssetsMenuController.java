package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import com.jfoenix.controls.JFXCheckBox;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Asset;
import model.PPE;

public class ListAssetsMenuController {
	
	private PPE PPE;
	
    @FXML
    private JFXCheckBox depreciableAsset_checkBox;

    @FXML
    private JFXCheckBox nonDepreciableAsset_checkBox;

    @FXML
    private TableView<Asset> assetData_tableView;

    @FXML
    private TableColumn<Asset, LocalDate> registerDate_tableColumn;

    @FXML
    private TableColumn<Asset, String> name_tableColumn;

    @FXML
    private TableColumn<Asset, Double> residualValue_tableColumn;

    @FXML
    private TableColumn<Asset, Double> netWorth_tableColumn;

    @FXML
    private TableColumn<Asset, Double> derpreciateRate_tableColumn;

    @FXML
    private TableColumn<Asset, Double> derpeciation_tableColumn;

    @FXML
    private TableColumn<Asset, Boolean> deregister_tableColumn;
    
    
    
    
    @FXML
    void initialize() {
    	configureTable();
    	depreciableAssetClicked();
    }
    
    
    
    
    @FXML
    void depreciableAssetClicked() {
    	depreciableAsset_checkBox.setSelected(true);
    	nonDepreciableAsset_checkBox.setSelected(false);
    	
    	assetData_tableView.getItems().clear();
    	createDepreciableAssetsData();
    }

    @FXML
    void nonDepreciableAssetClicked() {
    	nonDepreciableAsset_checkBox.setSelected(true);
    	depreciableAsset_checkBox.setSelected(false);
    	
    	assetData_tableView.getItems().clear();
    	createNonDepreciableAssetsData();
    }
    
    
    
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    
    
    
    private void configureTable() {
    	name_tableColumn.setCellValueFactory(new PropertyValueFactory<Asset, String>("name"));
    	registerDate_tableColumn.setCellValueFactory(new PropertyValueFactory<Asset, LocalDate>("registrationDate"));
    	residualValue_tableColumn.setCellValueFactory(new PropertyValueFactory<Asset, Double>("residualValue"));
    	netWorth_tableColumn.setCellValueFactory(new PropertyValueFactory<Asset, Double>("value"));
    	derpreciateRate_tableColumn.setCellValueFactory(new PropertyValueFactory<Asset, Double>("depreciationRate"));
    	derpeciation_tableColumn.setCellValueFactory(new PropertyValueFactory<Asset, Double>("depreciation"));
    	deregister_tableColumn.setCellValueFactory(new PropertyValueFactory<Asset, Boolean>("active"));
    }
    
    private void createDepreciableAssetsData() {
    	Hashtable<String, List<Asset>> hash = PPE.getDerpeciableAssets();
    	List<String> listKeys = updateDepreciableCategories(hash);
    	
    	List<Asset> data = new ArrayList<Asset>();
    	
    	for (int i = 0; i < listKeys.size(); i++) {
			for (int j = 0; j < hash.get(listKeys.get(i)).size(); j++) {
				data.add(hash.get(listKeys.get(i)).get(j));
			}
		}
    	
    	addDataToTable(data);
    }
    
    private void createNonDepreciableAssetsData() {
    	Hashtable<String, List<Asset>> hash = PPE.getNonDepreciableAsset();
    	List<String> listKeys = updateNonDepreciableCategories(hash);
    	
    	List<Asset> data = new ArrayList<Asset>();
    	
    	for (int i = 0; i < listKeys.size(); i++) {
			for (int j = 0; j < hash.get(listKeys.get(i)).size(); j++) {
				data.add(hash.get(listKeys.get(i)).get(j));
			}
		}
    	
    	addDataToTable(data);
    }
    
    private List<String> updateDepreciableCategories(Hashtable<String, List<Asset>> hash) {
    	List<String> list = Collections.list(hash.keys());
    	List<String> data = new ArrayList<String>();
    	
    	for (int i = 0; i < hash.size(); i++) {
			if(!hash.get(list.get(i)).isEmpty()) {
				data.add(list.get(i));
			}
		}
    	
    	return data;
    }
    
    private List<String> updateNonDepreciableCategories(Hashtable<String, List<Asset>> hash) {
    	List<String> list = Collections.list(hash.keys());
    	List<String> data = new ArrayList<String>();
    	
    	for (int i = 0; i < hash.size(); i++) {
			if(!hash.get(list.get(i)).isEmpty()) {
				data.add(list.get(i));
			}
		}
    	
    	return data;
    }
    
    private void addDataToTable(List<Asset> list) {
    	assetData_tableView.getItems().addAll(list);
    }
    
    
    
    
    
}
