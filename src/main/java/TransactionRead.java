
public class TransactionRead {
    public static void main(String[] args) {
        TransactionDao dao = new TransactionDao();
        Transaction transaction = dao.read();
        System.out.println(transaction);
        dao.close(); }


}
