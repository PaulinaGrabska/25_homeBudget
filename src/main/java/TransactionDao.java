import java.sql.*;

public class TransactionDao {

    private static final String URL = "jdbc:mysql://localhost:3306/home_budget?characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection connection;

    TransactionIO io = new TransactionIO();

    public TransactionDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void create() {

        Transaction transaction = io.getTransactiondata();

        final String sql1 = "insert into transaction(type, description, amount, date) values(?, ?, ?,?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql1);
            prepStmt.setString(1, transaction.getType().getDescription());
            prepStmt.setString(2, transaction.getDescription());
            prepStmt.setDouble(3, transaction.getAmount());
            prepStmt.setDate(4, transaction.getDate());

            prepStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public Transaction read() {
        int id = io.getId();

        final String sql = "select id, type, description, amount, date from transaction where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                Transaction transaction = new Transaction(result.getInt("id"),
                        Type.valueOf(result.getString("type")),
                        result.getString("description"),result.getDouble("amount") ,
                        result.getDate("date"));
                return transaction;
            }
        } catch (SQLException e) {
            System.out.println("Could not get transaction");
        }
        return null; // lub ElementNotFoundException }
    }

    public void update(Transaction transaction) {
        final String sql = "update transaction set type=?, description=?, amount=?, date=? where id = ?";
        try { PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, transaction.getType().getDescription());
            prepStmt.setString(2, transaction.getDescription());
            prepStmt.setDouble(3, transaction.getAmount());
            prepStmt.setDate(4, transaction.getDate());
            prepStmt.setInt(5, transaction.getId());

            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record"); e.printStackTrace();
        }
    }

    public void delete(int id) {
        final String sql = "delete from transaction where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
