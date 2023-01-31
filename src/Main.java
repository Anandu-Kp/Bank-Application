import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER YOUR NAME,PASSWORD & BALANCE TO CREATE AN ACCOUNT");
        String name=sc.nextLine();
        String password=sc.nextLine();
        double balance=sc.nextDouble();

        //create user
        SBIusers user=new SBIusers(name,balance,password);
        int p=0;
        do
        {
            System.out.println("1.View Amount");
            System.out.println("2.Add Amount");
            System.out.println("3.Withdraw Amount");
            System.out.println("4.Check Interest of 10 years");
            System.out.println("5.Exit");
            p=sc.nextInt();
            switch (p)
            {
                case 1:
                    System.out.println(user.getBalance());
                    break;
                case 2:
                    System.out.println("ENTER THE AMOUNT YOU WANT TO ADD");
                    int amt=sc.nextInt();
                    String message=user.addMoney(amt);
                    System.out.println(message);
                    break;
                case 3:
                    System.out.println("ENTER AMOUNT DO YOU WANT TO WITHDRAW");
                    int money=sc.nextInt();
                    System.out.println("ENTER YOUR PASSWORD");
                    String pwd=sc.next();
                    System.out.println(user.withdrawMoney(money,pwd));
                    break;
                case 4:
                    System.out.println("YOUR INTEREST IS  "+user.calculateInterest(10));
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
        while(p!=5);
        //addmoney
//        System.out.println("ENTER THE AMOUNT YOU WANT TO ADD");
//        int amt=sc.nextInt();
//        String message=user.addMoney(amt);
//        System.out.println(message);

        //withdraw money
//        System.out.println("ENTER AMOUNT DO YOU WANT TO WITHDRAW");
//        int money=sc.nextInt();
//        System.out.println("ENTER YOUR PASSWORD");
//        String pwd=sc.next();
//        System.out.println(user.withdrawMoney(money,pwd));

        //calculate Interest

//        System.out.println("YOUR INTEREST IS  "+user.calculateInterest(10));
    }
}