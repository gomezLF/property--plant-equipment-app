package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DeregisterMenuController {
	
    @FXML
    private Label assetName_label;

    @FXML
    private JFXTextField netWorth_textField;

    @FXML
    private VBox residualValue_vBox;

    @FXML
    private JFXTextField residualValue_textField;

    @FXML
    private JFXDatePicker registrationDate_TextField;

    @FXML
    private JFXComboBox<String> causeDeregister_comboBox;

    @FXML
    private JFXDatePicker retirementDate_datePicker;

    @FXML
    private VBox retirementDescription_vBox;

    @FXML
    private JFXTextArea retirementDescription_textArea;
    
    
    
    
    @FXML
    void initialize() {
    	
    }
    
    
    

    @FXML
    void comboBoxValueClicked(ActionEvent event) {

    }
    
    @FXML
    void cancelClicked() {

    }
    

    @FXML
    void removeClicked(ActionEvent event) {

    }
}
