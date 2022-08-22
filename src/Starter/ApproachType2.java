package Starter;

import java.sql.*;


public class ApproachType2 {
    public static void main(String[] args) {
        try {
            //Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Test";
            String username = "root";
            String password = "Ss12345#";
            String SQL = "INSERT INTO STUDENT VALUES(NULL,'SRIJAN KUMAR',30)";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            if (con.isClosed()) {
                System.out.println("Connection Closed...");
            } else {
                System.out.println("Connection Created Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
