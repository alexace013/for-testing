package inputControlNumber;

import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexander on 14.10.15.
 */
public class ControlNumber {

    public  ControlNumber() {}

    public boolean checkNumber(TextField textField) {
        double value;
        String strValue = textField.getText();
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(strValue);
        if (strValue.equals(null) || strValue.equals("")) {
            return false;
        }
        if (matcher.matches()) {
            return false;
        } else {
            value = Double.parseDouble(strValue);
            return true;
        }
    }


}
