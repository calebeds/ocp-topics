package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class BankService {
    private static Connection connection;

    public static void main(String[] args) {
        connect();
        retrieveOne();
        System.out.println();
        retrieveAll();
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

    static void retrieveOne() {
        System.out.println(getAccountDetails("123456", "12345678"));
    }

    static void retrieveAll() {

    }

    private static BankAccount getAccountDetails(final String branchCode, final String accountNo) {
        final String selectSQL = "SELECT * FROM app.BANK_TABLE WHERE (BRANCH_CODE = ? AND ACCOUNT_NUMBER = ?)";
        BankAccount bankAccount = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, branchCode);
            preparedStatement.setString(2, accountNo);

            ResultSet resultSet = preparedStatement.executeQuery(); // implies SELECT

            if(!resultSet.next()) {
                return bankAccount;
            }

            bankAccount = new BankAccount(
                    resultSet.getString("BRANCH_CODE"),
                    resultSet.getString(2),// "ACCOUNT_NUMBER"
                    resultSet.getString("CUST_NAME"),
                    resultSet.getString("CUST_ADDRESS"),
                    resultSet.getDouble("BALANCE")
            );
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

        return bankAccount;
    }
}
