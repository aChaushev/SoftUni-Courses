package _08_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            if (isValidEmail(email)) {
                emailsMap.put(name, email);
            }

            input = scanner.nextLine();
        }

        emailsMap.forEach((name, email) -> System.out.printf("%s -> %s\n", name, email));

        //или записваме всичко и след това ги премахваме от map-a
//        emailsMap.entrySet().removeIf(entry ->
//                entry.getValue().endsWith("us") || entry.getValue().endsWith("uk") || entry.getValue().endsWith("com"));

    }

    private static boolean isValidEmail(String email) {
        return !email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com");
    }
}
