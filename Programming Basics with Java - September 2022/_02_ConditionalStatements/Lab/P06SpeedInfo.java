package _02_ConditionalStatements.Lab;

import java.util.Scanner;

public class P06SpeedInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double speed = Double.parseDouble(scanner.nextLine());

//        if (speed <= 10) {
//            System.out.println("slow");
//        } else if (speed <= 50) {
//            System.out.println("average");
//        } else if (speed <= 150) {
//            System.out.println("fast");
//        } else if (speed <= 1000) {
//            System.out.println("ultra fast");
//        } else {
//            System.out.println("extremely fast");
//        }
        String textResult = "";
        if (speed <= 10) {
            textResult = "slow";
        } else if (speed <= 50) {
            textResult = "average";
        } else if (speed <= 150) {
            textResult = "fast";
        } else if (speed <= 1000) {
            textResult = "ultra fast";
        } else {
            textResult = "extremely fast";
        }

        System.out.println(textResult);
    }
}