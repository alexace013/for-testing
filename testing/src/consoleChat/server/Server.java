package consoleChat.server;

import consoleChat.main.Const;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alexander on 09.09.15.
 */
public class Server {

    private List<Connection> connections = Collections.synchronizedList(new ArrayList<Connection>());
    private ServerSocket server;

    public Server() {
        try {
            server = new ServerSocket(Const.Port);
            while (true) {
                Socket socket = server.accept();
                Connection con = new Connection(socket);
                connections.add(con);
                con.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

    private void closeAll() {
        try {
            server.close();
            synchronized (connections) {
                Iterator<Connection> iterator = connections.iterator();
                while (iterator.hasNext()) {
                    ((Connection) iterator.next()).close();
                }
            }
        } catch (Exception e) {
            System.err.println("Error.");
        }
    }

    private class Connection extends Thread {

        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        private String name = new String("");

        public Connection(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            try {
                name = in.readLine();
                synchronized (connections) {
                    Iterator<Connection> iterator = connections.iterator();
                    while (iterator.hasNext()) {
                        ((Connection) iterator.next()).out.println(name + " cames now");
                    }
                }
                String str = new String("");
                while (true) {
                    str = in.readLine();
                    if (str.equals("exit")) {
                        break;
                    }
                    synchronized (connections) {
                        Iterator<Connection> iterator = connections.iterator();
                        while (iterator.hasNext()) {
                            ((Connection) iterator.next()).out.println(name + ": " + str);
                        }
                    }
                }
                synchronized (connections) {
                    Iterator<Connection> iterator = connections.iterator();
                    while (iterator.hasNext()) {
                        ((Connection) iterator.next()).out.println(name + " has left");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        public void close() {
            try {
                in.close();
                out.close();
                socket.close();

                connections.remove(this);
                if (connections.size() == 0) {
                    Server.this.closeAll();
                    System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Error.");
            }
        }

    }

}
