package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E03_Gymnastics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String type = scanner.nextLine();

        double pointsSym = 0;
        if (country.equals("Russia")) {
            if (type.equals("ribbon")) {
                pointsSym = 9.1 + 9.4;
            } else if (type.equals("hoop")) {
                pointsSym = 9.3 + 9.8;
            } else if (type.equals("rope")) {
                pointsSym = 9.6 + 9;
            }
        } else if (country.equals("Bulgaria")) {
            if (type.equals("ribbon")) {
                pointsSym = 9.6 + 9.4;
            } else if (type.equals("hoop")) {
                pointsSym = 9.55 + 9.75;
            } else if (type.equals("rope")) {
                pointsSym = 9.5 + 9.4;
            }
        } else if (country.equals("Italy")) {
            if (type.equals("ribbon")) {
                pointsSym = 9.2 + 9.5;
            } else if (type.equals("hoop")) {
                pointsSym = 9.45 + 9.35;
            } else if (type.equals("rope")) {
                pointsSym = 9.7 + 9.15;
            }
        }
        double percent = (20 - pointsSym) / 20 * 100;
        System.out.printf("The team of %s get %.3f on %s.%n%.2f%%", country, pointsSym, type, percent);
    }
}
