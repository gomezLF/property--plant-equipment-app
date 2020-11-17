package customException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EmptyFieldException extends Exception{
	
	public EmptyFieldException() {
        super("Para añadir un nuevo activo debe llenar todos los campos necesarios");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
