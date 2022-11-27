package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E06_WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Последния сектор от секторите - символ (B-Z)
        //•	Броят на редовете в първия сектор - цяло число (1-100)
        //•	Броят на местата на нечетен ред - цяло число (1-24)
        char lastSector = scanner.nextLine().charAt(0);
        int rowsSecA = Integer.parseInt(scanner.nextLine());
        int seatingOddRow = Integer.parseInt(scanner.nextLine());

        int seatingCounter = 0;
        int rowsSec = rowsSecA;
        for (int i = 'A'; i <= lastSector; i++) {
            if (i > 'A') {
                rowsSec++;
            }
            for (int j = 1; j <= rowsSec; j++) {
                if (j % 2 != 0) {
                    for (int k = 'a'; k < 'a' + seatingOddRow; k++) {
                        seatingCounter++;
                        System.out.printf("%c%d%c%n", i, j, k);
                    }
                } else {
                    for (int k = 'a'; k < 'a' + seatingOddRow + 2; k++) {
                        seatingCounter++;
                        System.out.printf("%c%d%c%n", i, j, k);
                    }
                }
            }
        }
        System.out.println(seatingCounter);
    }
}
