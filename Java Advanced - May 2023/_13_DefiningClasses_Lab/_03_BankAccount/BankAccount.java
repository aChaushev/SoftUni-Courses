package _13_DefiningClasses_Lab._03_BankAccount;

public class BankAccount {

    private static int nextId = 1;         //поменлива, която важи за всички полета
    private static double interestRate = 0.02;  //поменлива, която важи за всички полета
    private int id;
    private double balance;

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }

    public int getId(){
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;         //не може this.interestRate защото interestRate е static
    }

    public double getInterest(int years) {
        return balance * years * interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }


}
