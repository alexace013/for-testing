package calculationFacilities;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexander on 15.09.15.
 */
public class ControlSymbol {

    private static double value;
    private static final String ERROR_MESSAGE = "Вы ввели не число.";

    public double examination(String string) {

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(string);


        if (!matcher.matches()) {
            String s = string;

            value = Double.parseDouble(s);
        } else {
            value = 0.0d;
//            System.out.println(ERROR_MESSAGE);
        }

        return value;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ControlSymbol cs = new ControlSymbol();
        double d = cs.examination(scan.nextLine());
        System.out.println(d);

    }

}
