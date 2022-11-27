package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E01_BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rent = Double.parseDouble(scanner.nextLine());

        double cake = rent * 0.2;
        double drinks = cake - cake * 0.45;
        double animator = rent / 3;
        double totalSum = rent + cake + drinks + animator;
        System.out.println(totalSum);
    }
}
