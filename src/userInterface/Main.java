package userInterface;

import controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/MainMenu.fxml"));
		
		MainMenuController mainMenuController = new MainMenuController();
		loader.setController(mainMenuController);
        Parent root = loader.load();
        
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Menu Principal");
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
