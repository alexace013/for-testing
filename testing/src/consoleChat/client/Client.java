package consoleChat.client;

import consoleChat.main.Const;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by alexander on 09.09.15.
 */
public class Client {

    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public Client() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Please, enter IP address in this format (xxx.xxx.xxx.xxx) : ");
        String ip = scan.nextLine();

        try {

            socket = new Socket(ip, Const.Port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter you nickname: ");
            out.print(scan.nextLine());

            Resender resender = new Resender();
            resender.start();

            String str = new String("");
            while (!str.equals("exit")) {
                str = scan.nextLine();
                out.println(str);
            }
            resender.setStop();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Error.");
        }
    }

    private class Resender extends Thread {

        private boolean stoped;

        public void setStop() {
            stoped = true;
        }

        @Override
        public void run() {

            try {
                while (!stoped) {
                    String str = in.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println("Error getting the message.");
                e.printStackTrace();
            }

        }

    }

}
