import java.sql.*;
import java.util.Scanner;

public class GenerateValues {
    Values values = new Values();
    Scanner scanner = new Scanner(System.in);
    private PreparedStatement statement;

    void feedValues() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:myTestDB.db");

            System.out.println("Enter a name: ");
            values.setName(scanner.nextLine());
            System.out.println("Enter a phone number: ");
            values.setPhone(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter an email: ");
            values.setEmail(scanner.nextLine());

            statement = conn.prepareStatement("INSERT INTO contacts ('name', 'phone', 'email')" +  "values(?, ?, ?)");
            statement.setString(1, values.getName());
            statement.setInt(2, values.getPhone());
            statement.setString(3, values.getEmail());
            statement.execute();

            Statement statement1 = conn.createStatement();
            statement1.execute("SELECT * FROM contacts");
            ResultSet results = statement1.getResultSet();
            while(results.next()) {
                System.out.println(results.getString("name") + results.getInt("phone") + results.getString("email"));
            }

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect: " + e.getMessage());
        }
    }
}
