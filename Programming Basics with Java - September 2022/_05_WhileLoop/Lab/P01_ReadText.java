package _05_WhileLoop.Lab;

import java.util.Scanner;

public class P01_ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            String word = scanner.nextLine();
//            if (word.equals("Stop")) {
//                break;
//            }
//            System.out.println(word);
//        }

        String word = scanner.nextLine();
        while (!word.equals("Stop")) {

            System.out.println(word);
            word = scanner.nextLine();
        }
    }
}
