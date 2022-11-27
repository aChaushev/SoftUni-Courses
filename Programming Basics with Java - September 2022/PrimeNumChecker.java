import java.util.Scanner;

public class PrimeNumChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Чекер за прости числа
        // Просто число е естествено число, по-голямо от 1, което има точно два естествени делителя – 1 и самото себе си
        // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, ...
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= num; i++) {
            int counter = 0;                // брояч на броя на възможните деления на числото
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {           // ако числото се дели само на себе си (и на 1)
                    counter++;
                }
            }
            if (counter == 1) {             // ако числото се дели само на себе си (и на 1)
                counter = 0;
                System.out.println(i);
            }
        }

    }
}
