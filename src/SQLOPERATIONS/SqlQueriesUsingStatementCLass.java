package SQLOPERATIONS;

import java.sql.*;

public class SqlQueriesUsingStatementCLass {
    public static final String url = "jdbc:mysql://localhost:3306/Test?userSSL=false";
    public static final String username = "root";
    public static final String password = "Ss12345#";
    public static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO users (NAME,EMAIL,COUNTRY)"
            + "VALUES ('Srijan Kumar Khan','srijankhan20030@gmail.com','INDIA'),"
            + "('Kankana Das','das.kankana1998@gmail.com','INDIA'),"
            + "('Nimesh Krishnana','nimesh@gmail.com','INDIA'),"
            + "('Sk.Sujauddin','skSuja@gmail.com','INDIA');";
    public static final String UPDATE_USER_SQL = "UPDATE users SET Name='Sk Sujauddin' WHERE ID=4";

    public static final String DELETE_USER_SQL = "DELETE FROM users WHERE ID=4";

    public static final String DISPLAY_USERS_SQL = "SELECT * FROM users";


    public void InsertRecord() {
        try {
            //get Database Connection

            Connection con = DriverManager.getConnection(url, username, password);

            //Insert Statement
            Statement statement = con.createStatement();

            //Execute Query
            int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
            System.out.println("No. of rows affected: \n" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateRecord() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(UPDATE_USER_SQL);
            System.out.println("No. of records updated: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteRecord() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(DELETE_USER_SQL);
            System.out.println("No. Of Record Deleted: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayRecords() {
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
        SqlQueriesUsingStatementCLass tableQueries = new SqlQueriesUsingStatementCLass();
//        tableQueries.InsertRecord();
//        tableQueries.UpdateRecord();
        tableQueries.DeleteRecord();
        tableQueries.displayRecords();


    }
}
