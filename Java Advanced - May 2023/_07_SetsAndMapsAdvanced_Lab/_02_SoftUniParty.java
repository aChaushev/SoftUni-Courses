package _07_SetsAndMapsAdvanced_Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        printSet(vip);

        printSet(regular);

    }

    private static void printSet(Set<String> regular) {
        for (String reg : regular) {
            System.out.println(reg);
        }
    }
}
