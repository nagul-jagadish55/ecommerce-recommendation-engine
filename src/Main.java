import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();
        EcommerceApp app = new EcommerceApp(conn);
        app.start();
    }
}
