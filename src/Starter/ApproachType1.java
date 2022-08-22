package Starter;

import java.sql.*;

public class ApproachType1 {
    public static void main(String[] args) {
        try {
            //get database connection
            String url = "jdbc:mysql://localhost:3306/Test?userSSL=false";
            String username = "root";
            String password = "Ss12345#";
            Connection connection = DriverManager.getConnection(url, username, password);

            //create statement
            Statement statement = connection.createStatement();

            //execute statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            //process result
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String NAME = resultSet.getString("NAME");
                String EMAIL = resultSet.getString("EMAIL");
                String COUNTRY = resultSet.getString("Country");

                System.out.println("The column of the Users table are: " + "\nID:" + ID +
                        "\nNAME:" + NAME + "\nEMAIL:" + EMAIL + "\nCountry:" + COUNTRY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
