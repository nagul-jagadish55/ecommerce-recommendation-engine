import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {

    public static void main(String[] args) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            // USERS TABLE
            String usersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "user_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(50),"
                    + "age INT,"
                    + "gender VARCHAR(10),"
                    + "location VARCHAR(50)"
                    + ")";

            // PRODUCTS TABLE
            String productsTable = "CREATE TABLE IF NOT EXISTS products ("
                    + "product_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(100),"
                    + "category VARCHAR(50),"
                    + "price DOUBLE,"
                    + "brand VARCHAR(50)"
                    + ")";

            // INTERACTIONS TABLE
            String interactionsTable = "CREATE TABLE IF NOT EXISTS user_interactions ("
                    + "interaction_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "user_id INT,"
                    + "product_id INT,"
                    + "action VARCHAR(20),"
                    + "rating INT,"
                    + "FOREIGN KEY (user_id) REFERENCES users(user_id),"
                    + "FOREIGN KEY (product_id) REFERENCES products(product_id)"
                    + ")";

            stmt.executeUpdate(usersTable);
            stmt.executeUpdate(productsTable);
            stmt.executeUpdate(interactionsTable);

            System.out.println("🎉 Tables created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
