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
            conn = DriverManager.getConnection("jdbc:mysql://172.16.55.59:3306/enoteca", "root", "R11Tmysql!");

            // Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM vini");

            // Iterate over the result set
            while (rs.next()) {
                // Access columns by name
                int id = rs.getInt("id");
                String nome_vino = rs.getString("Nome_Vino");
                int annata = rs.getInt("Annata");
                double prezzo = rs.getDouble("Prezzo");
                
                // Do something with the data
                System.err.println("+----+----------------+------+--------+");
                System.err.println("| ID | Nome Vino      | Annata| Prezzo |");
                System.err.println("+----+----------------+------+--------+");
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.err.printf("| %2d | %-14s | %4d | %6.2f |\n", id, nome_vino, annata, prezzo);
                }
                System.err.println("+----+----------------+------+--------+");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try { rs.close(); } catch (Exception e) { }
            try { stmt.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
    }
}