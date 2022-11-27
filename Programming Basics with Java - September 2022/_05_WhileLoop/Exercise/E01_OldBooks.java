package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E01_OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String theBook = scanner.nextLine();
        int booksCount = 0;
        boolean isFound = false;
        String currentBook = scanner.nextLine();

        while (!currentBook.equals("No More Books")) {

            if (currentBook.equals(theBook)) {
                isFound = true;
                break;
            }
            booksCount++;
            currentBook = scanner.nextLine();
        }
        if (isFound) {
            System.out.printf("You checked %d books and found it.", booksCount);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", booksCount);
        }
    }
}
