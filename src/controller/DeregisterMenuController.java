package controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import customException.NoDataRegisteredException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Asset;
import model.PPE;


public class DeregisterMenuController {
	
	private PPE PPE;
	
    @FXML
    private JFXCheckBox depreciableAsset_checkBox;

    @FXML
    private JFXCheckBox nonDepreciableAsset_checkBox;
    
    @FXML
    private JFXComboBox<String> category_comboBox;

    @FXML
    private VBox registrationDate_VBox;
    
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
    	createTableColumns();
    }
    
    
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	if(category_comboBox.getValue() != null) {
    		registrationDate_VBox.setDisable(false);
        	
        	try {
    			if(depreciableAsset_checkBox.isSelected()) {
    				PPE.checkAvailableDepreciableAssets(category_comboBox.getValue());
    				addDataToTable(PPE.getDerpeciableAssets().get(category_comboBox.getValue()));
    				
    			}else {
    				PPE.checkAvailableNonDepreciableAssets(category_comboBox.getValue());
    				addDataToTable(PPE.getNonDepreciableAsset().get(category_comboBox.getValue()));
    			}
    			
    		}catch (NoDataRegisteredException e) {
    			e.message();
    		}
    	}
    }
    
    @FXML
    void depreciableAssetClicked() {
    	depreciableAsset_checkBox.setSelected(true);
    	nonDepreciableAsset_checkBox.setSelected(false);
    	
    	data_TableView.getItems().clear();
    	updateDepreciableCategories();
    }

    @FXML
    void nonDepreciableAssetClicked() {
    	nonDepreciableAsset_checkBox.setSelected(true);
    	depreciableAsset_checkBox.setSelected(false);
    	
    	data_TableView.getItems().clear();
    	updateNonDepreciableCategories();
    }
    
    
    
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    
    
    
    private void updateDepreciableCategories() {
    	category_comboBox.setValue(null);
    	registrationDate_VBox.setDisable(true);
    	
    	category_comboBox.getItems().clear();
    	category_comboBox.getItems().addAll(Collections.list(PPE.getDerpeciableAssets().keys()));
    }
    
    private void updateNonDepreciableCategories() {
    	category_comboBox.setValue(null);
    	registrationDate_VBox.setDisable(true);
    	
    	category_comboBox.getItems().clear();
    	category_comboBox.getItems().addAll(Collections.list(PPE.getNonDepreciableAsset().keys()));
    }
    
    
    
    
	private void createTableColumns() {
    	nameColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("name"));
    	valueColum.setCellValueFactory(new PropertyValueFactory<Asset, Double>("value"));
    	categoryColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("category"));
    	registrationDatecolumn.setCellValueFactory(new PropertyValueFactory<Asset, LocalDate>("registrationDate"));
    }
	
	private void addDataToTable(List<Asset> list) {
		data_TableView.getItems().clear();
		Collection<Asset> data = FXCollections.observableList(list);
		data_TableView.getItems().addAll(data);
	}
}
