package trivialDateServerAndClient;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by alexander on 09.09.15.
 */
public class DateClient {

    public static void main(String[] args) throws IOException {

        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine is\n" +
                        "running the date service on port 3095: ");
        Socket socket = new Socket(serverAddress, 3095);
        BufferedReader input =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);

    }
}
