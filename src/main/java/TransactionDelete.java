public class TransactionDelete {

    public static void main(String[] args) {
        TransactionDao dao = new TransactionDao();
        dao.delete(2);
        dao.close();
    }
}




