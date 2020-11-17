package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;


public class MainMenuController {
	
    @FXML
    private BorderPane mainMenu_BorderPane;
	
    
    @FXML
    void initialize() {
		
    }
    
    
    @FXML
    void addNewAssetClicked() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/NewAssetMenu.fxml"));
    		loader.setController(new NewAssetMenuController());
            Parent root = loader.load();
            mainMenu_BorderPane.setCenter(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deregisterAssetClicked() {
    	
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
