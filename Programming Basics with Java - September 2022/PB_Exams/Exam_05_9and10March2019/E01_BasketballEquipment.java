package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E01_BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double yearFee = Double.parseDouble(scanner.nextLine());

        double sneakers = yearFee * 0.6;
        double outfit = sneakers * 0.8;
        double ball = outfit / 4;
        double accessories = ball / 5;

        double totalExpenses = yearFee + sneakers + outfit + ball + accessories;
        System.out.printf("%.2f",totalExpenses);
    }
}
