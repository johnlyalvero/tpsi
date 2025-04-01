// javac -cp ./mysql-connector-j-8.0.32.jar JdbcExample.java
// java -cp ./mysql-connector-j-8.0.32.jar;. JdbcExample

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost/miodb", "root", "R11Tmysql!");

            // Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tabella");

            // Iterate over the result set
            while (rs.next()) {
                // Access columns by name
                int id = rs.getInt("id");
                String descrizione = rs.getString("descrizione");
                // Do something with the data
                System.out.println("ID:" + id + " Descrizione:" + descrizione);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}