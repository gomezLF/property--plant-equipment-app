package customException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NoDataRegisteredException extends Exception{
	
	public NoDataRegisteredException() {
        super("No hay datos registrados aún");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.WARNING, super.getMessage(), ButtonType.CLOSE);
        alert.setHeaderText(null);
        alert.show();
    }
}
