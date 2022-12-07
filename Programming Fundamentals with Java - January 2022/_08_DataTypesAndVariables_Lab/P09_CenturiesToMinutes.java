package _08_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class P09_CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte century = Byte.parseByte(scanner.nextLine());

        double years = century * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;

        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes", century, years, days, hours, minutes);
    }
}
