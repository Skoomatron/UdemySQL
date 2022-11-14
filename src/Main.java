import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:myTestDB.db");
        } catch (SQLException e) {
            System.out.println("Couldn't Connect: " + e.getMessage());
        }
    }
}