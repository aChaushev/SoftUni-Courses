package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E04_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        double ticketPrice = 5;
        int allPeople = 0;
        double income = 0;
        boolean isFull = false;
        while (!input.equals("Movie time!")) {
            int people = Integer.parseInt(input);
            if (allPeople + people > hallCapacity) {
                isFull = true;
                break;
            }
            allPeople += people;
            income += people * ticketPrice;
            if (people % 3 == 0) {
                income -= 5;
            }
            input = scanner.nextLine();
        }
        if (isFull) {
            System.out.println("The cinema is full.");
        } else {

            System.out.printf("There are %d seats left in the cinema.%n", hallCapacity - allPeople);
        }
        System.out.printf("Cinema income - %.0f lv.", income);
    }
}
