package example01;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alexander on 07.09.15.
 * Ввести дробное число с клавиатуры, округлить его по правилам.
 */
public class Task01 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Введите дробное число: ");
        double value = scanner.nextDouble();
        method1(value);
//        method2(value);

    }

    public static void method1(double d) {
        double value = d;
        int result;
        if ((value % 2) == 0) {
            result = (int)value;
            System.out.println(result);
        } else {
            result = (int)(value + 0.5);
            System.out.println(result);
        }
    }

    public static void method2(double d) {
        double value = d;
        double value2 = value + 0.5;
        int result = (int) value2;
        System.out.println(result);
    }

}
