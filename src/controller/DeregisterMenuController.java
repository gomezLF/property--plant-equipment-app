package controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

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
    	updateCategories();
    	registrationDate_VBox.setDisable(true);
    	createTableTreeColumns();
    }
    
    
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	registrationDate_VBox.setDisable(false);
    	createTableTreeColumns();
    	addDataToTable();
    }
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    private void updateCategories() {
    	category_comboBox.getItems().clear();
    	category_comboBox.getItems().addAll(Collections.list(PPE.getAssets().keys()));
    }
    
	private void createTableTreeColumns() {
    	nameColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("name"));
    	valueColum.setCellValueFactory(new PropertyValueFactory<Asset, Double>("value"));
    	categoryColum.setCellValueFactory(new PropertyValueFactory<Asset, String>("category"));
    	registrationDatecolumn.setCellValueFactory(new PropertyValueFactory<Asset, LocalDate>("registrationDate"));
    }
	
	private void addDataToTable() {
		try {
			PPE.checkAvailableAssets();
			
			data_TableView.getItems().clear();
			Collection<Asset> data = FXCollections.observableList(PPE.getAssets().get(category_comboBox.getValue()));
			System.out.println(data);
			data_TableView.getItems().addAll(data);
			
		}catch (NoDataRegisteredException e) {
			e.message();
		}
	}
}
