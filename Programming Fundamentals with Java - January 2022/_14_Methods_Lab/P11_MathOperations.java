package _14_Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(df.format(operationResult(firstNum, operator, secondNum)));

    }

    public static double operationResult(int firstNum, String operator, int secondNum) {
        double result = 0;
        switch (operator) {
            case "/":
                result = firstNum * 1.0 / secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
        }
        return result;
    }
}
