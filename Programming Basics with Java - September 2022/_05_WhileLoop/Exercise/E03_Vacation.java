package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededVacMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        double allMoney = availableMoney;
        int spendCount = 0;
        int allDays = 0;
        boolean cantSave = false;

        while (allMoney < neededVacMoney) {
            allDays++;
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());

            switch (command) {
                case "save":
                    spendCount = 0;
                    allMoney += money;
                    break;
                case "spend":
                    spendCount++;
                    allMoney -= money;
                    if (allMoney <= 0) {
                        allMoney = 0;
                    }
                    break;
            }

            if (spendCount == 5) {
                cantSave = true;
                break;
            }
        }

        if (cantSave){
            System.out.println("You can't save the money.");
            System.out.printf("%d", allDays);
        } else {
            System.out.printf("You saved the money for %d days.", allDays);
        }
    }
}
