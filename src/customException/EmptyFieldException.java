package customException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EmptyFieldException extends Exception{
	
	public EmptyFieldException() {
        super("Para poder realizar la acción, \n" + "debe de llenar todos los campos necesarios");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.WARNING, super.getMessage(), ButtonType.CLOSE);
        alert.setHeaderText(null);
        alert.show();
    }
}
