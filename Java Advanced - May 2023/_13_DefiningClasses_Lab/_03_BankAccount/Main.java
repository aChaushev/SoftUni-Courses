package _13_DefiningClasses_Lab._03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//• Create
//•	Deposit {Id} {Amount}
//•	SetInterest {Interest}
//•	GetInterest {ID} {Years}
//•	End

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccountsMap = new HashMap<>();

        BiFunction<BankAccount, String[], String> depositFunction = (b, arr) -> {
            int amount = Integer.parseInt(arr[2]);
            b.deposit(amount);
            return "Deposited " + amount + " to ID" + arr[1];
        };

        BiFunction<BankAccount, String[], String> getInterestFunction = (b, arr) -> {
            int years = Integer.parseInt(arr[2]);
            double interest = b.getInterest(years);
            return String.format("%.2f", interest);
        };

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            String command = data[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccountsMap.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created\n", bankAccount.getId());

            } else if (command.equals("Deposit")) {
                String output = executeOnBankAccount(data, bankAccountsMap, depositFunction);
                System.out.println(output);
            } else if (command.equals("GetInterest")) {
                String output = executeOnBankAccount(data, bankAccountsMap, getInterestFunction);
                System.out.println(output);
            } else if (command.equals("SetInterest")) {
                double interestRate = Double.parseDouble(data[1]);
                BankAccount.setInterestRate(interestRate);
            }


            input = scanner.nextLine();
        }

//        BankAccount.setInterestRate(1.1);       //static нещата се извикват чрез името на класа class BankAccount
    }

    private static String executeOnBankAccount(String[] data, Map<Integer, BankAccount> bankAccountsMap, BiFunction<BankAccount, String[], String> function) {

        int id = Integer.parseInt(data[1]);
        BankAccount bankAccount = bankAccountsMap.get(id);

        if (bankAccount == null) {
            return "Account does not exist";
        }

        return function.apply(bankAccount, data);
    }
}
