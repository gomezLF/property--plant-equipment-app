package controller;

import java.time.LocalDate;
import java.util.Collections;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;
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
    private JFXTreeTableView<Asset> data_treeTableView;
    
    
    
    @FXML
    void initialize() {
    	updateCategories();
    	registrationDate_VBox.setDisable(true);
    }
    
    
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	registrationDate_VBox.setDisable(false);
    	createTableTreeColumns();
    }
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    private void updateCategories() {
    	category_comboBox.getItems().clear();
    	category_comboBox.getItems().addAll(Collections.list(PPE.getAssets().keys()));
    }
    
    @SuppressWarnings("unchecked")
	private void createTableTreeColumns() {
    	data_treeTableView.getColumns().clear();
    	
    	JFXTreeTableColumn<Asset, String> nameColum = new JFXTreeTableColumn<>("Nombre");
    	JFXTreeTableColumn<Asset, Double> valueColum = new JFXTreeTableColumn<>("Costo");
    	JFXTreeTableColumn<Asset, String> categoryColum = new JFXTreeTableColumn<>("Categoría");
    	JFXTreeTableColumn<Asset, LocalDate> registrationDatecolumn = new JFXTreeTableColumn<>("Fecha de Registro");
    	
    	data_treeTableView.getColumns().addAll(nameColum, valueColum, categoryColum, registrationDatecolumn);
    	
    }
}
