package controller;

import java.time.LocalDate;
import java.util.Collections;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import customException.EmptyFieldException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import model.PPE;

public class NewAssetMenuController {
	
	private PPE PPE;
	private boolean otherCategory;
	
    @FXML
    private VBox leftForm_VBox;
	
    @FXML
    private JFXTextField name_textField;
    
    @FXML
    private JFXTextField value_textField;
    
    @FXML
    private JFXTextField amount_textField;
    
    @FXML
    private JFXCheckBox depreciableAsset_checkBox;

    @FXML
    private JFXCheckBox nonDepreciableAsset_checkBox;
    
    @FXML
    private VBox residualValue_VBox;

    @FXML
    private JFXTextField residualValue_textBox;

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
    	updateDepreciableCategories();
    	depreciableAsset_checkBox.setSelected(true);
    	
    	otherCategory_VBox.setDisable(true);
    }
    
    
    
    @FXML
    void addAssetClicked() {
    	try {
    		validateField(name_textField);
    		validateField(value_textField);
    		validateField(amount_textField);
    		validateField(category_comboBox);
    		validateField(registrationDate_TextField);
    		
    		String name = name_textField.getText();
    		double value = Double.parseDouble(value_textField.getText());
    		int amount = Integer.parseInt(amount_textField.getText());
    		String category = category_comboBox.getValue();
    		LocalDate registrationDate = registrationDate_TextField.getValue();
    		String description = description_textArea.getText();
    		
    		if(category_comboBox.getValue().equals("Otro")) {
    			validateField(otherCategory_textField);
    			category = otherCategory_textField.getText();
    		}
    		
    		if(depreciableAsset_checkBox.isSelected()) {
    			validateField(residualValue_textBox);
    			validateField(usefulLife_textField);
    			
    			PPE.addNewDepreciableAsset(name, value, category, registrationDate, Double.parseDouble(usefulLife_textField.getText()), usefulLifeMedition_textField.getText(), description, otherCategory, amount);
    			
    		}else {
    			PPE.addNewNonDepreciableAsset(name, value, category, registrationDate, description, otherCategory, amount);
    		}
    		
    		cleanFieldsClicked();
    		updateDepreciableCategories();
    		
    	}catch (EmptyFieldException e) {
			e.message();
		}catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "En los campos en que se deben de ingresar numeros, \n" + "verificar que no hallan carácteres diferentes de números", ButtonType.CLOSE);
	        alert.setHeaderText(null);
	        alert.show();
		}
    }

    @FXML
    void cleanFieldsClicked() {
		name_textField.setText("");
		value_textField.setText("");
		amount_textField.setText("");
		residualValue_textBox.setText("");
		category_comboBox.setValue(null);
		otherCategory_textField.setText("");
		usefulLife_textField.setText("");
		usefulLifeMedition_textField.setText("");
		registrationDate_TextField.setValue(null);
		description_textArea.setText("");
		
		
		depreciableAssetClicked();
		otherCategory_VBox.setDisable(true);
    }
    
    @FXML
    void depreciableAssetClicked() {
    	depreciableAsset_checkBox.setSelected(true);
    	nonDepreciableAsset_checkBox.setSelected(false);
    	
    	disableOptionalFields(false);
    	updateDepreciableCategories();
    }

    @FXML
    void nonDepreciableAssetClicked() {
    	nonDepreciableAsset_checkBox.setSelected(true);
    	depreciableAsset_checkBox.setSelected(false);
    	
    	disableOptionalFields(true);
    	updateNonDepreciableCategories();
    }
    
    @FXML
    void comboBoxValueClicked(ActionEvent event) {
    	if(category_comboBox.getValue() != null) {
    		if(category_comboBox.getValue().equals("Otro")) {
        		otherCategory_VBox.setDisable(false);
        		otherCategory = true;
        	}else {
        		otherCategory_VBox.setDisable(true);
        		otherCategory = false;
        	}
    	}
    }
    
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
    private void updateDepreciableCategories() {
    	category_comboBox.getItems().clear();
    	
    	category_comboBox.getItems().addAll(Collections.list(PPE.getDerpeciableAssets().keys()));
    	category_comboBox.getItems().add("Otro");
    }
    
    private void updateNonDepreciableCategories() {
    	category_comboBox.getItems().clear();
    	
    	category_comboBox.getItems().addAll(Collections.list(PPE.getNonDepreciableAsset().keys()));
    	category_comboBox.getItems().add("Otro");
    }
    
    private void disableOptionalFields(boolean disable) {
    	usefulLife_VBox.setDisable(disable);
    	residualValue_VBox.setDisable(disable);
    }
    
    private void validateField(Object object) throws EmptyFieldException{
    	if((object instanceof JFXTextField && ((JFXTextField) object).getText().equals("")) || (object instanceof JFXComboBox<?> && ((JFXComboBox<?>) object).getValue() == null) || (object instanceof JFXDatePicker && ((JFXDatePicker) object).getValue() == null)) {
    		throw new EmptyFieldException();
    	}
    }
}
