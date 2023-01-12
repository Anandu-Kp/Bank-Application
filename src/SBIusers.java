import java.util.Objects;
import java.util.UUID;

public class SBIusers implements BankInterface{
    private String name;
    private String accNo;
    private double balance;
    private String password;
    private static double rateOfInterest;


    public SBIusers(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        //bank initialising

        this.rateOfInterest=6.5;
        this.accNo=String.valueOf(UUID.randomUUID());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public  void setRateOfInterest(double rateOfInterest) {
        SBIusers.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance + amount;
        return "YOUR BALANCE IS "+balance;
    }

    @Override
    public String withdrawMoney(int amount,String enteredPassword) {
        if(Objects.equals(password,enteredPassword))
        {
            if(amount>balance)
            {
                return "INSUFFICIENT BALANCE";
            }
            else
            {
                balance = balance - amount;
                return "REMAINING BALANCE IS "+balance;
            }
        }
        else
        {
            return "WRONG PASSWORD";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateOfInterest)/100;
    }
}
