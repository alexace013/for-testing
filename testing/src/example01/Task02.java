package example01;

/**
 * Created by alexander on 07.09.15.
 * С помощью только одного цикла while вывеси на экран: 1 2 3 4 5 4 3 2 1
 */
public class Task02 {

    public static void main(String[] args) {

        int value = 0;
        while (value < 5) {
            value++;
            System.out.print(value + " ");
        }
        value = 5;
        while (value > 1) {
            value--;
            System.out.print(value + " ");
        }

    }

}
