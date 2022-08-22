package SQLOPERATIONS;

import java.sql.*;
import java.util.Arrays;

public class BatchINSERT {
    public static final String url = "jdbc:mysql://localhost:3306/Test?userSSL=false";
    public static final String username = "root";
    public static final String password = "Ss12345#";

    public static void BatchInsert() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();

            con.setAutoCommit(false);

            statement.addBatch("INSERT INTO USERS(NAME,EMAIL,COUNTRY) VALUES('SRIJAN KUMAR KHAN','srijankhan20030@gmail.com','INDIA')");
            statement.addBatch("INSERT INTO USERS(NAME,EMAIL,COUNTRY) VALUES('KANKANA DAS','das.kankana1998@gmail.com','INDIA')");
            statement.addBatch("INSERT INTO USERS(NAME,EMAIL,COUNTRY) VALUES('Sk Sujauddin','sksujauddin@gmail.com','INDIA')");
            statement.addBatch("INSERT INTO USERS(NAME,EMAIL,COUNTRY) VALUES('NIMESH KRISHNAN','nimeshKrishnan@gmail.com','INDIA')");

            int[] result = statement.executeBatch();

            System.out.println(Arrays.toString(result));

            con.commit();
        } catch (BatchUpdateException be) {
            System.out.println(be);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        BatchInsert();
    }
}
