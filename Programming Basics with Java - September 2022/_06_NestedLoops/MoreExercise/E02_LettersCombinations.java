package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E02_LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Ред 1.	Малка буква от английската азбука за начало на интервала – от ‘a’ до ‚z’.
        //Ред 2.	Малка буква от английската азбука за край на интервала  – от първата буква до ‚z’.
        //Ред 3.	Малка буква от английската азбука – от ‘a’ до ‚z’ – като комбинациите съдържащи тази буквата се пропускат.
        char letter1 = scanner.nextLine().charAt(0);
        char letter2 = scanner.nextLine().charAt(0);
        char letter3 = scanner.nextLine().charAt(0);

        int counter = 0;
        for (int i = letter1; i <= letter2; i++) {
            if (i == letter3) {
                continue;
            }
            for (int j = letter1; j <= letter2; j++) {
                if (j == letter3) {
                    continue;
                }
                for (int k = letter1; k <= letter2; k++) {
                    if (k == letter3) {
                        continue;
                    }
                    counter++;
                    System.out.printf("%c%c%c ", i, j, k);
                }
            }
        }
        System.out.print(counter);
    }
}
