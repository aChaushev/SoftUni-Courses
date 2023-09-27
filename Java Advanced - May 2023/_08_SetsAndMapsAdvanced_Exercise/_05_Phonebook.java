package _08_SetsAndMapsAdvanced_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebookMap = new HashMap<>();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebookMap.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (phonebookMap.containsKey(input)) {
                System.out.printf("%s -> %s\n", input, phonebookMap.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }

            input = scanner.nextLine();
        }

    }
}
