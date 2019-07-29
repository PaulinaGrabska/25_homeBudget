import sun.util.calendar.BaseCalendar;

import java.sql.Date;
import  java.util.GregorianCalendar;

//TransactionUpdate – zaktualizuj dane dotyczące dowolnej książki zapisanej w bazie danych
public class TransactionUpdate {

    public static void main(String[] args) {
        TransactionDao dao = new TransactionDao();
        Transaction transaction = dao.read();
        transaction.setType(Type.INCOME);
        transaction.setDescription("extra bonus");
        transaction.setAmount(340);
        transaction.setDate(Date.valueOf("2019-09-09"));
        dao.update(transaction);
        dao.close(); }
}
