package _05_BasicSyntax_Lab;

import java.util.Scanner;

public class P06_ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        String language = "";
        switch (country) {
            case "England":
            case "USA":
                language = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                language = "Spanish";
                break;
            default:
                System.out.println("unknown");
        }
        System.out.println(language);
    }
}
