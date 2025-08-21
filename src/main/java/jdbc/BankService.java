package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class BankService {
    private static Connection connection;

    public static void main(String[] args) {
        connect();
    }

    public static void connect() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "my-secret-pw");
            System.out.println("Db Connection OK!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

}
