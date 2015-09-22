package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by alexander on 17.09.15.
 */
public class OracleJDBC {

    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Connection connection = null;
        System.out.println("started.");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try{
            connection = DriverManager.getConnection(url, "hr", "hr");
        } catch (SQLException e) {
            System.out.println("failed.");
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
