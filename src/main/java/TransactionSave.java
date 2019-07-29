//TransactionSave – wczytaj w niej dane o dowolnej transakcji
public class TransactionSave {

    public static void main(String[] args) {
        TransactionDao dao = new TransactionDao();
        dao.create();
        dao.close();
    }
}
