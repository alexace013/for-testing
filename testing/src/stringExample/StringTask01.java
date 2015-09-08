package stringExample;

/**
 * Created by alexander on 08.09.15.
 */
public class StringTask01 {

    public static void main(String[] args) {

        String str = "Hello Java.";
        String str2 = str.substring(6);
        String str3 = str.substring(0, 4);
        int i = str.charAt(0);
        String str4 = str2 + str3;
        int i2 = str.indexOf('a');
        int i3 = str.lastIndexOf('a');
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("i = " + i);
        System.out.println("str4: " + str4);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);

    }

}
