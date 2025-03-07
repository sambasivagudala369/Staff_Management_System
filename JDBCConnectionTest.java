import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/vijay";
        String user = "root";
        String password = "Vijay#369";
            // Load MySQL JDBC Driver (Not required in Java 8+ but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connection Successful!");
                conn.close(); // Close connection after success
            } else {
                System.out.println("Connection Failed!");
            }
        }
}
