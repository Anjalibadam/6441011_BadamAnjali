import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/school";  // Change DB URL if needed
    private final String user = "root";                               // Your DB username
    private final String password = "password";                       // Your DB password

    // Method to get DB connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Insert a new student
    public boolean insertStudent(int id, String name, int age) {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update existing student by id
    public boolean updateStudent(int id, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Main method to demonstrate insert and update
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        System.out.println("Inserting student...");
        boolean inserted = dao.insertStudent(3, "Charlie", 23);
        System.out.println("Insert successful? " + inserted);

        System.out.println("Updating student...");
        boolean updated = dao.updateStudent(3, "Charles", 24);
        System.out.println("Update successful? " + updated);
    }
}
