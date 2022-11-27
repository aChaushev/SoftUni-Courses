package _05_BasicSyntax_Lab;

import java.util.Scanner;

public class P11_MultiplicationTable_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int firstNum = Integer.parseInt(scanner.nextLine());

//        if (firstNum <= 10){
//            for (int i = firstNum; i <= 10; i++) {
//                int result = num * i;
//                System.out.printf("%d X %d = %d%n", num, i, result);
//            }
//        } else {
//            int result = num * firstNum;
//            System.out.printf("%d X %d = %d%n", num, firstNum, result);
//        }
        do {
            System.out.printf("%d X %d = %d%n", num, firstNum, num * firstNum);
            firstNum++;
        } while (firstNum <= 10);
    }
}

