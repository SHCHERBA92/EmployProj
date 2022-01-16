package bisnesLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    String USER_NAME = "postgres";
    String USER_PASSWORD = "root";
    String URL = "jdbc:postgresql://localhost/employee_proj_db";

    public Connection getConn()
    {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME,USER_PASSWORD);
            System.out.println("Connection OK");
//            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Connection ERROR");
        }
//        finally {
//            try {
//                connection.close();
//            } catch (SQLException sqlException) {
//                sqlException.printStackTrace();
//            }
//        }
        return connection;
    }
}
