package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E05_Coins_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputSum = Double.parseDouble(scanner.nextLine());
        double inputInCoins = Math.floor(inputSum * 100);

        int coinsCounter = 0;
        while (inputInCoins != 0) {
            if (inputInCoins / 200 >= 1) {
                coinsCounter++;
                inputInCoins -= 200;
            } else if (inputInCoins / 100 >= 1) {
                coinsCounter++;
                inputInCoins -= 100;
            } else if (inputInCoins / 50 >= 1) {
                coinsCounter++;
                inputInCoins -= 50;
            } else if (inputInCoins / 20 >= 1) {
                coinsCounter++;
                inputInCoins -= 20;
            } else if (inputInCoins / 10 >= 1) {
                coinsCounter++;
                inputInCoins -= 10;
            } else if (inputInCoins / 5 >= 1) {
                coinsCounter++;
                inputInCoins -= 5;
            } else if (inputInCoins / 2 >= 1) {
                coinsCounter++;
                inputInCoins -= 2;
            } else {
                coinsCounter++;
                inputInCoins -= 1;
            }
        }
        System.out.println(coinsCounter);
    }
}
