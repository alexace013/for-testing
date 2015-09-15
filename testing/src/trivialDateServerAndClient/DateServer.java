package trivialDateServerAndClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*Сервер TCP, который работает на порту 3095. Когда клиент подключается,
ему отправляется текущая дата и время, а затем связь прерывается с клиентом.*/
public class DateServer {

    /*
    * Запуск сервера.
    * */

    public static void main(String[] args) throws IOException {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.YYYY");

        ServerSocket listener = new ServerSocket(3095);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println("Today " + formatter.format(date) + " and now " + time);
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }

}
