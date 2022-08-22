package SQLOPERATIONS;

import java.sql.*;

public class SqlQueriesUsingPrepareStatementClass {
    public static final String url = "jdbc:mysql://localhost:3306/Test?userSSL=false";
    public static final String username = "root";
    public static final String password = "Ss12345#";
    public static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO users (NAME,EMAIL,COUNTRY) VALUES"
            + "(?,?,?);";
    public static final String UPDATE_USER_SQL = "UPDATE users SET Name=? WHERE ID=?";

    public static final String DELETE_USER_SQL = "DELETE FROM users WHERE ID=?";

    public static final String DISPLAY_USERS_SQL = "SELECT * FROM users";

    public void InsertRecord() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = con.prepareStatement(INSERT_MULTIPLE_USERS_SQL);

            preparedStatement.setString(1, "Saha Alam Mallick");
            preparedStatement.setString(2, "sahaAlam123@gmail.com");
            preparedStatement.setString(3, "INDIA");
            int result = preparedStatement.executeUpdate();

            System.out.println("No. of row added: " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateRecord() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_USER_SQL);

            preparedStatement.setString(1, "Sagar Mallick");
            preparedStatement.setInt(2, 6);
            int result = preparedStatement.executeUpdate();

            System.out.println("No. of row added: " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteRecord() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = con.prepareStatement(DELETE_USER_SQL);

            preparedStatement.setInt(1, 5);
            int result = preparedStatement.executeUpdate();

            System.out.println("No. of row added: " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DisplayRecord() {
        try {
            //get Database Connection
            Connection con = DriverManager.getConnection(url, username, password);

            //Insert Statement
            Statement statement = con.createStatement();

            //Execute Query
            ResultSet result = statement.executeQuery(DISPLAY_USERS_SQL);
            System.out.print("\nRecords are: \n");
            System.out.print(
                    "\n |            ID                |"
                            + "            COUNTRY            |"
                            + "              NAME             |"
                            + "              EMAIL               |\n");


            System.out.print(" -----------------------------------" +
                    "----------------------" +
                    "----------------" +
                    "-----------------------------" +
                    "------------------------------\n");


            while (result.next()) {
                int ID = result.getInt("ID");
                String NAME = result.getString("NAME");
                String EMAIL = result.getString("EMAIL");
                String COUNTRY = result.getString("Country");

                System.out.print("              " + ID
                        + "                               " + COUNTRY);
                System.out.print("                        " + NAME);

                System.out.print("            " + EMAIL);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SqlQueriesUsingPrepareStatementClass sqlPre = new SqlQueriesUsingPrepareStatementClass();
//        sqlPre.InsertRecord();
//        sqlPre.UpdateRecord();
        sqlPre.DeleteRecord();
        sqlPre.DisplayRecord();
    }
}
