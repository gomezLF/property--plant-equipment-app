package controller;

import java.util.Collections;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import customException.EmptyFieldException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import model.PPE;

public class NewAssetMenuController {
	
	private PPE PPE;
	
    @FXML
    private VBox leftForm_VBox;
	
    @FXML
    private JFXTextField name_textField;

    @FXML
    private JFXComboBox<String> category_comboBox;

    @FXML
    private JFXTextField usefulLife_textField;

    @FXML
    private JFXTextField usefulLifeMedition_textField;

    @FXML
    private JFXDatePicker registrationDate_TextField;

    @FXML
    private VBox otherCategory_VBox;

    @FXML
    private JFXTextField otherCategory_textField;
    
    @FXML
    private VBox usefulLife_VBox;

    @FXML
    private JFXTextArea description_textArea;
    
    
    @FXML
    void initialize() {
    	PPE = new PPE();
    	
    	otherCategory_VBox.setDisable(true);
    	usefulLife_VBox.setDisable(true);
    }
    
    
    
    @FXML
    void addAssetClicked() {
    	try {
    		
    		validateField(name_textField);
    		validateField(category_comboBox);
    		validateField(registrationDate_TextField);
    		
    		if(category_comboBox.getValue().equals("Terreno")) {
    			
    			
    		}else if(!category_comboBox.getValue().equals("Otro") && !category_comboBox.getValue().equals("Terreno")) {
    			validateField(usefulLife_textField);
    			
    		}else {
    			validateField(otherCategory_textField);
    			validateField(usefulLife_textField);
    		}
    		
    		cleanFieldsClicked();
    		updateCategories();
    		
    	}catch (EmptyFieldException e) {
			e.message();
		}
    }

    @FXML
    void cleanFieldsClicked() {
		name_textField.setText("");
		category_comboBox.setValue(null);
		otherCategory_textField.setText("");
		usefulLife_textField.setText("");
		usefulLifeMedition_textField.setText("");
		registrationDate_TextField.setValue(null);
		description_textArea.setText("");
		
		disableOptionalFields();
    }
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	disableOptionalFields();
    	
    	if(category_comboBox.getValue() != null ) {
    		String category = category_comboBox.getValue();
    		
    		usefulLife_VBox.setDisable(false);
			otherCategory_textField.setText("");
			usefulLife_textField.setText("");
    		
    		if(category.equals("Terreno")) {
    			usefulLife_VBox.setDisable(true);
    			usefulLifeMedition_textField.setText("");
    			
    		}else if(category.equals("Maquinaria y Equipo")) {
    			usefulLifeMedition_textField.setText("unidades de producción");
    			
    		}else if(category.equals("Vehículos")) {
    			usefulLifeMedition_textField.setText("kilometros");
    			
    		}else if(category.equals("Otro")) {
    			otherCategory_VBox.setDisable(false);
    			usefulLifeMedition_textField.setText("Años");
    			
    		}else {
    			usefulLifeMedition_textField.setText("Años");
    		}
    	}
    }
    
    
    
    private void updateCategories() {
    	category_comboBox.getItems().clear();
    	
    	category_comboBox.getItems().addAll(Collections.list(PPE.getAssets().keys()));
    	category_comboBox.getItems().add("Otro");
    }
    
    private void disableOptionalFields() {
    	otherCategory_VBox.setDisable(true);
    	usefulLife_VBox.setDisable(true);
    }
    
    private void validateField(Object object) throws EmptyFieldException{
    	if((object instanceof JFXTextField && ((JFXTextField) object).getText().equals("")) || (object instanceof JFXComboBox<?> && ((JFXComboBox<?>) object).getValue() == null) || (object instanceof JFXDatePicker && ((JFXDatePicker) object).getValue() == null)) {
    		throw new EmptyFieldException();
    	}
    }
}
