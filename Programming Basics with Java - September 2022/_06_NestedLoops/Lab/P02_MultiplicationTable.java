package _06_NestedLoops.Lab;

public class P02_MultiplicationTable {
    public static void main(String[] args) {

        for (int firstNum = 1; firstNum <= 10; firstNum++) {
            for (int secondNum = 1; secondNum <= 10; secondNum++) {
                System.out.printf("%d * %d = %d%n", firstNum, secondNum, firstNum * secondNum);
            }

        }
    }
}
