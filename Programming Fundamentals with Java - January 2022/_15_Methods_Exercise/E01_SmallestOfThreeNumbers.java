package _15_Methods_Exercise;

import java.util.Scanner;

public class E01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        printMinNum(firstNum, secondNum, thirdNum);

    }

    public static void printMinNum(int firstNum, int secondNum, int thirdNum) {
//        int minValue = Math.min(Math.min(firstNum,secondNum),thirdNum);
//        System.out.println(minValue);
        if (firstNum <= secondNum && firstNum <= thirdNum) {
            System.out.println(firstNum);
        } else if (secondNum <= firstNum && secondNum <= thirdNum) {
            System.out.println(secondNum);
        } else if (thirdNum <= firstNum && thirdNum <= secondNum) {
            System.out.println(thirdNum);
        }
    }

//    public static int printMinNumber(int firstNum, int secondNum, int thirdNum) {
//        if (firstNum <= secondNum && firstNum <= thirdNum) {
//            return firstNum;
//        } else if (secondNum <= firstNum && secondNum <= thirdNum) {
//            return secondNum;
//        } else if (thirdNum <= firstNum && thirdNum <= secondNum) {
//            return thirdNum;
//        }
//        return 0;
//    }
}

