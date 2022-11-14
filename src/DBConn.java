import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {

    String name = "myTestDB.db";

    public String getName() {
        return name;
    }

    void DBConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:myTestDB.db");
            System.out.println("Connected to: " + getName());


            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO contacts values('Trevor', 1234556, 'me@gmail.com')");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Couldn't Connect: " + e.getMessage());
        }
    }


}
