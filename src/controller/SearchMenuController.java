package controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Asset;
import model.PPE;


public class SearchMenuController {
	
	private PPE PPE;
	
	private List<Asset> listedAssets;
	private Asset assetSelected;
	private boolean runDeregisterMenuController;
	
    @FXML
    private JFXCheckBox depreciableAsset_checkBox;

    @FXML
    private JFXCheckBox nonDepreciableAsset_checkBox;
    
    @FXML
    private JFXComboBox<String> category_comboBox;

    @FXML
    private VBox registrationDate_VBox;
    
    @FXML
    private JFXButton showCategory_button;
    
    @FXML
    private JFXButton showDetails_button;
    
    @FXML
    private JFXDatePicker registrationDate_TextField;

    @FXML
    private TableView<Asset> data_TableView;
    
    @FXML
    private TableColumn<Asset, String> nameColum;

    @FXML
    private TableColumn<Asset, Double> valueColum;

    @FXML
    private TableColumn<Asset, String> categoryColum;

    @FXML
    private TableColumn<Asset, LocalDate> registrationDatecolumn;
    
    
    
    @FXML
    void initialize() {
    	depreciableAssetClicked();
    	registrationDate_VBox.setDisable(true);
    	showCategory_button.setDisable(true);
    	showDetails_button.setDisable(true);
    	configureTable();
    }
    
    
    
    
    @FXML
    void cleanFieldsClicked() {
    	depreciableAssetClicked();
    }
    
    @FXML
    void showCategoryClicked() {
    	showCategory_button.setDisable(true);
    	addDataToTable(listedAssets);
    }
    
    @FXML
    void showDetailsClicked() {
    	
    	if(runDeregisterMenuController) {
    		
    		
    		
    	}else {
    		
    	}
    	
    	showDetails_button.setDisable(true);
    }
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	if(category_comboBox.getValue() != null) {
    		registrationDate_VBox.setDisable(false);
        	
			if(depreciableAsset_checkBox.isSelected()) {
				addDataToTable(PPE.getDerpeciableAssets().get(category_comboBox.getValue()));
				
			}else {
				addDataToTable(PPE.getNonDepreciableAsset().get(category_comboBox.getValue()));
			}
    	}
    }
    
    @FXML
    void depreciableAssetClicked() {
    	depreciableAsset_checkBox.setSelected(true);
    	nonDepreciableAsset_checkBox.setSelected(false);
    	
    	registrationDate_TextField.setValue(null);
    	registrationDate_VBox.setDisable(true);
    	
    	data_TableView.getItems().clear();
    	updateDepreciableCategories();
    	
    	showCategory_button.setDisable(true);
    }

    @FXML
    void nonDepreciableAssetClicked() {
    	nonDepreciableAsset_checkBox.setSelected(true);
    	depreciableAsset_checkBox.setSelected(false);
    	
    	registrationDate_TextField.setValue(null);
    	registrationDate_VBox.setDisable(true);
    	
    	data_TableView.getItems().clear();
    	updateNonDepreciableCategories();
    	
    	showCategory_button.setDisable(true);
    }
    
    @FXML
    void registrationDateClicked(ActionEvent event) {
    	if(registrationDate_TextField.getValue() != null) {
    		data_TableView.getItems().clear();
        	showCategory_button.setDisable(false);
        	
    		List<Asset> data = filterAssets();
    		data_TableView.getItems().addAll(data);
    	}
    }
    
    
    
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    public void setRunDeregisterMenuController(boolean runDeregisterMenuController) {
    	this.runDeregisterMenuController = runDeregisterMenuController;
    }
    
    
    
    
    private void updateDepreciableCategories() {
    	category_comboBox.setValue(null);
    	
    	category_comboBox.getItems().clear();
    	
    	Hashtable<String, List<Asset>> hash = PPE.getDerpeciableAssets();
    	List<String> list = Collections.list(hash.keys());
    	
    	for (int i = 0; i < hash.size(); i++) {
			if(!hash.get(list.get(i)).isEmpty()) {
				category_comboBox.getItems().add(list.get(i));
			}
		}
    }
    
    private void updateNonDepreciableCategories() {
    	category_comboBox.setValue(null);
    	
    	category_comboBox.getItems().clear();
    	
    	Hashtable<String, List<Asset>> hash = PPE.getNonDepreciableAsset();
    	List<String> list = Collections.list(hash.keys());
    	
    	for (int i = 0; i < hash.size(); i++) {
			if(!hash.get(list.get(i)).isEmpty()) {
				category_comboBox.getItems().add(list.get(i));
			}
		}
    }
    
    
    
    
	private void configureTable() {
    	nameColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("name"));
    	valueColum.setCellValueFactory(new PropertyValueFactory<Asset, Double>("value"));
    	categoryColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("category"));
    	registrationDatecolumn.setCellValueFactory(new PropertyValueFactory<Asset, LocalDate>("registrationDate"));
    	
    	data_TableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Asset>() {

			@Override
			public void changed(ObservableValue<? extends Asset> observable, Asset oldValue, Asset newValue) {
				if(data_TableView.getSelectionModel().getSelectedItem() != null) {
					assetSelected = data_TableView.getSelectionModel().getSelectedItem();
					
					showDetails_button.setDisable(false);
				}
			}
    		
		});
    }
	
	private void addDataToTable(List<Asset> list) {
		data_TableView.getItems().clear();
		listedAssets = list;
		data_TableView.getItems().addAll(list);
	}
	
	private List<Asset> filterAssets(){
		List<Asset> data = new ArrayList<Asset>();
		
		for (Asset asset : listedAssets) {
			if(asset.getRegistrationDate().compareTo(registrationDate_TextField.getValue()) == 0) {
				data.add(asset);
			}
		}
		
		return data;
	}
}
