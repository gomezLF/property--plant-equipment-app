package controller;

import java.time.LocalDate;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.DepreciableAsset;
import model.NonDepreciableAsset;

public class GeneralDetailsMenuController {
	
	private DepreciableAsset assetD;
	private NonDepreciableAsset assetN;
	private boolean isDepreciateAsset;
	
    @FXML
    private Label assetName_label;

    @FXML
    private JFXTextField value_textField;

    @FXML
    private VBox residualValue_VBox;

    @FXML
    private JFXTextField residualValue_textBox;

    @FXML
    private VBox usefulLife_VBox;

    @FXML
    private JFXTextField usefulLife_textField;

    @FXML
    private JFXTextField usefulLifeMedition_textField;

    @FXML
    private VBox category_vBox;

    @FXML
    private JFXTextField category_textBox;
    
    
    
    
    @FXML
    void initialize() {
    	
    	configureTable();
    }
    
    
    
    
	public void setDerpeciableAsset(DepreciableAsset assetD) {
		this.assetD = assetD;
	}
	
	public void setDepreciateAsset(boolean isDepreciateAsset) {
		this.isDepreciateAsset = isDepreciateAsset;
	}
	public void setNonDepreciableAsset(NonDepreciableAsset asetN) {
		this.assetN = asetN;
	}
	
	
	
	private void configureTable() {
		if(isDepreciateAsset) {
			value_textField.setText(assetD.getValue());
			residualValue_textBox.setText("" + assetD.getResidualValue());
			usefulLife_textField.setText( "" + assetD.getUsefulLyfe());
			usefulLifeMedition_textField.setText(assetD.getUsefulLifeMedition());
			category_textBox.setText(assetD.getCategory());
			
		}else {
			value_textField.setText(assetN.getValue());
			category_textBox.setText(assetN.getCategory());
		}
    }
 
}

