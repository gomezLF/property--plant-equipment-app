package customException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EmptyFieldException extends Exception{
	
	public EmptyFieldException() {
        super("Para añadir un nuevo activo \n" + "debe llenar todos los campos necesarios");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.WARNING, super.getMessage(), ButtonType.CLOSE);
        alert.setHeaderText(null);
        alert.show();
    }
}
