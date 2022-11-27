package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E05_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        double moneyInCoins = Math.round(money * 100);
        int coinsCount = 0;

        while (moneyInCoins > 0) {

            if (moneyInCoins >= 200) {
                moneyInCoins -= 200;
                coinsCount++;
            } else if (moneyInCoins >= 100) {
                moneyInCoins -= 100;
                coinsCount++;
            } else if (moneyInCoins >= 50) {
                moneyInCoins -= 50;
                coinsCount++;
            } else if (moneyInCoins >= 20) {
                moneyInCoins -= 20;
                coinsCount++;
            } else if (moneyInCoins >= 10) {
                moneyInCoins -= 10;
                coinsCount++;
            } else if (moneyInCoins >= 5) {
                moneyInCoins -= 5;
                coinsCount++;
            } else if (moneyInCoins >= 2) {
                moneyInCoins -= 2;
                coinsCount++;
            } else if (moneyInCoins >= 1) {
                moneyInCoins -= 1;
                coinsCount++;
            } else {
                break;
            }
        }
        System.out.println(coinsCount);
    }
}
