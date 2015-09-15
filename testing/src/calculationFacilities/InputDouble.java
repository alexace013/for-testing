package calculationFacilities;

import javafx.scene.control.TextField;

/**
 * Created by alexander on 15.09.15.
 */
public class InputDouble {

    public InputDouble(TextField textField) {

        double value = textField.getPrefColumnCount();

    }

    public static void main(String[] args) {

        TextField textField = new TextField();
        textField.setText("text");


    }

}
