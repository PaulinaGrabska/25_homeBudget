//TransactionUpdate – zaktualizuj dane dotyczące dowolnej książki zapisanej w bazie danych
public class TransactionUpdate {

    public static void main(String[] args) {
        TransactionDao dao = new TransactionDao();
        Transaction transaction = dao.read();
        transaction.setId(2);
        dao.update(transaction);
        dao.close(); }
}
