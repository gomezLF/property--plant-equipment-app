package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import model.PPE;


public class MainMenuController {
	
	private PPE PPE;
	
    @FXML
    private BorderPane mainMenu_BorderPane;
	
    
    @FXML
    void initialize() {
		PPE = new PPE();
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
    		
    		DeregisterMenuController deregisterMenuController = new DeregisterMenuController();
    		deregisterMenuController.setPPE(this.PPE);
    		
    		loader.setController(deregisterMenuController);
            Parent root = loader.load();
            mainMenu_BorderPane.setCenter(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void searchAssetClicked() {
    	
    }
    
    @FXML
    void listAssetsClicked() {
    	
    }
    
    @FXML
    void listDeregisteredAssetsClicked() {
    	
    }
}
