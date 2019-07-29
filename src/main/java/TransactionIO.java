import java.sql.Date;
import java.util.Scanner;

public class TransactionIO {

    public Transaction getTransactiondata(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter type [EXPENDITURE or INCOME] :");
        String type = sc.nextLine();

        System.out.println("Enter description:");
        String description = sc.nextLine();

        System.out.println("Enter amount:");
        Double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter date:");
        String date = sc.nextLine();

        return new Transaction(Type.valueOf(type),description,amount, Date.valueOf(date));
    }


    public int getId(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id of transaction you want to find:");
        int id= sc.nextInt();

        return id;
    }


}
