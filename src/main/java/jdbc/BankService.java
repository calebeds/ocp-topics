package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class BankService {
    private static Connection connection;

    public static void main(String[] args) {
        connect();
//        retrieveOne();
//        retrieveAll();
//        deleteOne();
        deleteAll();
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

    private static void retrieveOne() {
        System.out.println("Retrieving branch code : \"123456\" and account number \"12345678\"");
        System.out.println(getAccountDetails("123456", "12345678"));
    }

    private static void retrieveAll() {
        System.out.println("Retrieving all accounts");
        for(BankAccount bankAccount: getAllAccounts()) {
            System.out.println(bankAccount);
        }
    }

    private static void deleteOne() {
        System.out.println("Deleting record ---  branch code : \"123456\" and account number \"12345678\"");

        int nRows = deleteBankAccount("123456", "12345678");
        if(nRows == 1) {
            System.out.println("Delete OK: " + nRows);
        } else {
            System.out.println("Delete error: " + nRows);
        }
    }

    private static void deleteAll() {
        System.out.println("Delete all records!");
        deleteAllAccounts();
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


    private static List<BankAccount> getAllAccounts() {
        List<BankAccount> bankAccounts = new ArrayList<>();

        String selectSQL = "SELECT * FROM app.BANK_TABLE";

        try(PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            boolean isResultSet = preparedStatement.execute();
            if(isResultSet) {
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    BankAccount bankAccount = new BankAccount(
                            resultSet.getString("BRANCH_CODE"),
                            resultSet.getString(2),// "ACCOUNT_NUMBER"
                            resultSet.getString("CUST_NAME"),
                            resultSet.getString("CUST_ADDRESS"),
                            resultSet.getDouble("BALANCE"));
                    bankAccounts.add(bankAccount);
                }
            } else {
                System.out.println("Did an update!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bankAccounts;
    }

    private static int deleteBankAccount(String branchCode, String accountNo) {
        int nRows = -1;
        String deleteSQL = "DELETE FROM app.BANK_TABLE where (BRANCH_CODE = ? AND ACCOUNT_NUMBER=?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, branchCode);
            preparedStatement.setString(2, accountNo);

            nRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return nRows;
    }

    private static void deleteAllAccounts() {
        final String deleteSQL = "DELETE FROM app.BANK_TABLE";

        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
