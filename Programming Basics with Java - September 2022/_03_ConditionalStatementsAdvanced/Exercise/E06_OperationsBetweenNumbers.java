package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E06_OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Оператор – един символ измеду: "+", "-", "*", "/", "%"
        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();


        double result = 0;
        boolean isZero = false;
        String evenOdd = "";

        switch (operator) {
            case "+":
                result = numOne + numTwo;
                break;
            case "-":
                result = numOne - numTwo;
                break;
            case "*":
                result = numOne * numTwo;
                break;
            case "/":
                if (numTwo == 0) {
                    isZero = true;
                } else {
                    result = numOne * 1.0 / numTwo;
                }
                break;
            case "%":
                if (numTwo == 0) {
                    isZero = true;
                } else {
                    result = numOne % numTwo;
                }
                break;
        }

        if (result % 2 == 0) {
            evenOdd = "even";
        } else {
            evenOdd = "odd";
        }
        //•	Ако операцията е събиране, изваждане или умножение:
        //o	 "{N1} {оператор} {N2} = {резултат} – {even/odd}"
        //•	Ако операцията е деление:
        //o	"{N1} / {N2} = {резултат}" – резултатът е форматиран до вторият знак след дес.запетая
        //•	Ако операцията е деление с остатък:
        //o	"{N1} % {N2} = {остатък}"
        //•	В случай на деление с 0 (нула):
        //o	"Cannot divide {N1} by zero"
        if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
            System.out.printf("%d %s %d = %.0f - %s", numOne, operator, numTwo, result, evenOdd);
        } else if (operator.equals("/") && !isZero) {
            System.out.printf("%d %s %d = %.2f", numOne, operator, numTwo, result);
        } else if (operator.equals("%") && !isZero) {
            System.out.printf("%d %s %d = %.0f", numOne, operator, numTwo, result);
        } else {
            System.out.printf("Cannot divide %d by zero", numOne);
        }

    }
}
