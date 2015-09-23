package jdbcTESTING;

import java.sql.*;
import java.util.Locale;

/**
 * Created by alexander on 22.09.15.
 */
public class JDBCmyTEST {

    public static void main(String[] args) throws SQLException {

        String user = "hr";
        String pass = user;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String driver = "";

        Locale.setDefault(Locale.ENGLISH);
        Connection connection = null;
        System.out.println("start");
        try {
            connection = DriverManager.getConnection(url, "hr", "hr");
        } catch (SQLException e) {
            System.out.println("error.");
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
