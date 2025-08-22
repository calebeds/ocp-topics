package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

class CallProcedures {
    private static Connection connection;

    public static void main(String[] args) {
        connect();
        callWithNoParams();
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

    private static void callWithNoParams() {
        // DB - "CREATE PROCEDURE read_joinville_addresses";
        String noParamsSQL = "{call read_dublin_addresses()}";

        try(CallableStatement callableStatement = connection.prepareCall(noParamsSQL);
            ResultSet rs = callableStatement.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("CUST_ADDRESS"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void callWithInParam() {
        // DB - "CREATE PROCEDURE read_addresses(IN address VARCHAR(50))"
        final String inParamSQL = "{call read_addresses(?)}";

        try(CallableStatement callableStatement = connection.prepareCall(inParamSQL)) {
            callableStatement.setString(1, "Dublin");

            try(ResultSet rs = callableStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("CUST_ADDRESS"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void callWithOutParam() {
        // DB - CREATE PROCEDURE count_customers(OUT count INT)
        final String outParamSQL = "{?= call count_customers(?)}";

        try(CallableStatement callableStatement = connection.prepareCall(outParamSQL)) {
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt("count"));
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    private static void callWithInOutParam() {
        String inOutParamSQL = "{call square_number(?)}";
        // DB - "CREATE PROCEDURE square_number(INOUT number INT)"
        try(CallableStatement cs = connection.prepareCall(inOutParamSQL)) {
            cs.setInt(1, 5);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println(cs.getInt("number"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
