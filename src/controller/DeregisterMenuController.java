package controller;

import java.time.LocalDate;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import customException.EmptyFieldException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Asset;
import model.PPE;

public class DeregisterMenuController {
	
	private PPE PPE;
	private Asset asset;
	private boolean isDepreciableAsset;
	
    @FXML
    private Label assetName_label;

    @FXML
    private JFXTextField netWorth_textField;

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
    	initialActions();
    	updateCauseDeregisterValues();
    }




	@FXML
    void comboBoxValueClicked(ActionEvent event) {
		retirementDescription_vBox.setDisable(true);	
		
    	if(!causeDeregister_comboBox.getValue().equals("Depreciado")) {
    		retirementDescription_vBox.setDisable(false);	
    	}
    }
    
    @FXML
    void cancelClicked(ActionEvent event) {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }
    

    @FXML
    void removeClicked(ActionEvent event) {
    	try {
    		validateField(causeDeregister_comboBox);
    		validateField(retirementDate_datePicker);
    		
    		if(!causeDeregister_comboBox.getValue().equals("Depreciado")) {
    			validateField(retirementDescription_textArea);
    		}
    		
    		PPE.addNewRemovedAsset(asset);
    		asset.setActive(false);
    		cancelClicked(event);
    		
    	}catch (EmptyFieldException e) {
			e.message();
		}
    	
    	
    }
    
    
    
	
    public void setPPE(PPE PPE) {
    	this.PPE = PPE;
    }
    
	public void setDepreciableAsset(boolean isDepreciableAsset) {
		this.isDepreciableAsset = isDepreciableAsset;
	}
    
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
    
    
    
	private void initialActions() {
		retirementDescription_vBox.setDisable(true);	
		
		assetName_label.setText("  " + asset.getName() + "  ");
		netWorth_textField.setText(asset.getValue());
		registrationDate_TextField.setValue(asset.getRegistrationDate());
		retirementDate_datePicker.setValue(LocalDate.now());
	}
	
	private void updateCauseDeregisterValues() {
		if(isDepreciableAsset) {
			causeDeregister_comboBox.getItems().add("Depreciado");
		}
		
		causeDeregister_comboBox.getItems().add("Vendido");
		causeDeregister_comboBox.getItems().add("Siniestro");
	}
	
    private void validateField(Object object) throws EmptyFieldException{
    	if((object instanceof JFXTextArea && ((JFXTextArea) object).getText().equals("")) || (object instanceof JFXComboBox<?> && ((JFXComboBox<?>) object).getValue() == null) || (object instanceof JFXDatePicker && ((JFXDatePicker) object).getValue() == null)) {
    		throw new EmptyFieldException();
    	}
    }
}
