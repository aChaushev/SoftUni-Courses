package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());
        for (int i = firstNum; i <=lastNum ; i++) {
            System.out.printf("%c ",i);
        }
    }
}
