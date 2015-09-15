package consoleChat.main;

import consoleChat.client.Client;
import consoleChat.server.Server;

import java.util.Scanner;

/**
 * Created by alexander on 09.09.15.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Run this program as a (S)erver or (C)lient?\nPlease, enter: ");
        while (true) {
            char answer = Character.toLowerCase(scanner.nextLine().charAt(0));
            if (answer == 's') {
                new Server();
                break;
            } else if (answer == 'c') {
                new Client();
                break;
            } else {
                System.out.println("Invalid input. Repeat.");
            }
        }

    }

}
