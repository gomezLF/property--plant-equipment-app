package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class NewAssetMenuController {
	
    @FXML
    private JFXTextField name_textField;

    @FXML
    private JFXComboBox<?> category_comboBox;

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
    private JFXTextArea description_textArea;
    
    
    @FXML
    void initialize() {
        
    }
    
    
    @FXML
    void addAssetClicked() {

    }

    @FXML
    void cleanFieldsClicked() {

    }
}
