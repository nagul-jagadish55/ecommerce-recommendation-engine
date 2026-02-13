import java.sql.Connection;
import java.sql.Statement;

public class InsertSampleData {

    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            // Insert Users
            stmt.executeUpdate("INSERT INTO users (name, age, gender, location) VALUES " +
                    "('John',22,'Male','Kerala')," +
                    "('Arjun',25,'Male','Delhi')," +
                    "('Priya',23,'Female','Mumbai')," +
                    "('Sneha',21,'Female','Chennai')");

            // Insert Products
            stmt.executeUpdate("INSERT INTO products (name, category, price, brand) VALUES " +
                    "('Gaming Mouse','Electronics',999,'Logitech')," +
                    "('Mechanical Keyboard','Electronics',2999,'Redgear')," +
                    "('Running Shoes','Fashion',1999,'Nike')," +
                    "('Bluetooth Headphones','Electronics',1499,'Boat')," +
                    "('Smart Watch','Electronics',3999,'Noise')," +
                    "('Sports T-shirt','Fashion',799,'Puma')");

            // Insert Interactions
            stmt.executeUpdate("INSERT INTO user_interactions (user_id, product_id, action, rating) VALUES " +
                    "(1,1,'purchase',5)," +
                    "(1,2,'purchase',4)," +
                    "(1,4,'view',0)," +
                    "(2,1,'purchase',5)," +
                    "(2,3,'purchase',4)," +
                    "(3,3,'purchase',5)," +
                    "(3,6,'purchase',4)," +
                    "(4,4,'purchase',5)," +
                    "(4,5,'purchase',4)");

            System.out.println("🎉 Sample data inserted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
