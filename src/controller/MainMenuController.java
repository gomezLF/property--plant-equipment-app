package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXDatePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.PPE;


public class MainMenuController {
	
	private PPE PPE;
	
    @FXML
    private BorderPane mainMenu_BorderPane;
    
    @FXML
    private VBox mainPanel_vBox;
	
    @FXML
    private JFXDatePicker cutoffDate_datePicker;
    
    
    
    
    @FXML
    void initialize() {
    	mainPanel_vBox.setDisable(true);
    }
    
    
    
    
    @FXML
    void cutoffDateClicked(ActionEvent event) {
    	if(cutoffDate_datePicker.getValue() != null) {
    		cutoffDate_datePicker.setDisable(true);
    		PPE = new PPE(cutoffDate_datePicker.getValue());
    		
    		mainPanel_vBox.setDisable(false);
    	}
    }
    
    @FXML
    void addNewAssetClicked() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/NewAssetMenu.fxml"));
    		
    		NewAssetMenuController newAssetMenuController = new NewAssetMenuController();
    		newAssetMenuController.setPPE(this.PPE);
    		
    		loader.setController(newAssetMenuController);
            Parent root = loader.load();
            mainMenu_BorderPane.setCenter(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deregisterAssetClicked() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/SearchMenu.fxml"));
    		
    		SearchMenuController searchMenuController = new SearchMenuController();
    		searchMenuController.setPPE(this.PPE);
    		searchMenuController.setRunDeregisterMenuController(true);
    		
    		loader.setController(searchMenuController);
            Parent root = loader.load();
            mainMenu_BorderPane.setCenter(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void searchAssetClicked() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/SearchMenu.fxml"));
    		
    		SearchMenuController searchMenuController = new SearchMenuController();
    		searchMenuController.setPPE(this.PPE);
    		searchMenuController.setRunDeregisterMenuController(false);
    		
    		loader.setController(searchMenuController);
            Parent root = loader.load();
            mainMenu_BorderPane.setCenter(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void listAssetsClicked() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/ListAssetsMenu.fxml"));
    		
    		ListAssetsMenuController listAssetsMenu = new ListAssetsMenuController();
    		listAssetsMenu.setPPE(this.PPE);
    		
    		loader.setController(listAssetsMenu);
            Parent root = loader.load();
            mainMenu_BorderPane.setCenter(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
