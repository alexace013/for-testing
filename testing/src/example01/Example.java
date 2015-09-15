package example01;

import java.util.Scanner;

/**
 * Created by alexander on 14.09.15.
 */
public class Example {

    public static void main(String[] args) {

//        while (true) {
//            System.out.println("hello");
//        }

//        byte b = -(byte)129; // диапазон byte -128...127;
//        System.out.println(b);

//        short number = 18;
//        int i1 = number++; // 18 + 1 = 18 = > 18
//        int i2 = ++number; // 1 + 19 = 20 = > 20;
//        System.out.println("i1 = " + i1 + "\n" + "i2 = " +  i2);

        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();

        if(i1 == i2) {
            System.out.println("Равно");
        } else {
            System.out.println("Не равно");
        }


    }
}
