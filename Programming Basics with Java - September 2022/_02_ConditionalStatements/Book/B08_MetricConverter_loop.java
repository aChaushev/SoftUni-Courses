package _02_ConditionalStatements.Book;

import java.util.Scanner;

public class B08_MetricConverter_loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double size = Double.parseDouble(scanner.nextLine());
        String source = scanner.nextLine().toLowerCase();
        String destination = scanner.nextLine().toLowerCase();

        double result = 0;
        if (source.equals("m")) {
            result = size;
        } else if (source.equals("mm")) {
            result = size / 1000;
        } else if (source.equals("cm")) {
            result = size / 100;
        } else if (source.equals("mi")) {
            result = size / 0.000621371192;
        } else if (source.equals("in")) {
            result = size / 39.3700787;
        } else if (source.equals("km")) {
            result = size / 0.001;
        } else if (source.equals("ft")) {
            result = size / 3.2808399;
        } else if (source.equals("yd")) {
            result = size / 1.0936133;
        }

        if (destination.equals("m")) {
            result = result;
        } else if (destination.equals("mm")) {
            result = result * 1000;
        } else if (destination.equals("cm")) {
            result = result * 100;
        } else if (destination.equals("mi")) {
            result = result * 0.000621371192;
        } else if (destination.equals("in")) {
            result = result * 39.3700787;
        } else if (destination.equals("km")) {
            result = result * 0.001;
        } else if (destination.equals("ft")) {
            result = result * 3.2808399;
        } else if (destination.equals("yd")) {
            result = result * 1.0936133;
        }
        System.out.println(result);
    }
}
