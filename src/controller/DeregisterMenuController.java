package controller;

import java.util.Collections;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
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
    void initialize() {
    	updateCategories();
    	registrationDate_VBox.setDisable(true);
    }
    
    
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	registrationDate_VBox.setDisable(false);
    	
    }
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    private void updateCategories() {
    	category_comboBox.getItems().clear();
    	category_comboBox.getItems().addAll(Collections.list(PPE.getAssets().keys()));
    }
    
    private void createTableTreeColumns() {
    	
    }
}
