import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountTransaction {

    private final String url = "jdbc:mysql://localhost:3306/bank"; // Change to your DB
    private final String user = "root";
    private final String password = "password";

    // Get DB connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Transfer money method
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                // Debit from source account
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                int debitCount = debitStmt.executeUpdate();

                // Credit to destination account
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int creditCount = creditStmt.executeUpdate();

                if (debitCount == 1 && creditCount == 1) {
                    conn.commit();
                    System.out.println("Transfer successful!");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed, transaction rolled back.");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error occurred, transaction rolled back.");
                e.printStackTrace();
            } finally {
                conn.setAutoCommit(true); // Restore default
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        AccountTransaction transaction = new AccountTransaction();

        // Transfer 200 from account 1 (Alice) to account 2 (Bob)
        transaction.transferMoney(1, 2, 200);
    }
}