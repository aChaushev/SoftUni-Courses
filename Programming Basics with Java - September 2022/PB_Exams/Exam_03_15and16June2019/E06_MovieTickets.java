package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E06_MovieTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	a1 – цяло число в интервала [65… 89]
        //•	a2 – цяло число в интервала [66… 91]
        //•	n – цяло число в интервала [1… 10]
        int a1 = Integer.parseInt(scanner.nextLine());
        int a2 = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        //•	Символ 1: символ с ASCII код от а1 до а2 - 1
        //•	Символ 2: цифра от 1 до n - 1
        //•	Символ 3: цифра от 1 до n / 2 - 1
        //•	Символ 4: цифрова репрезентация (ASCII код) на символ 1
        //След като са изпълнени условията се генерира следния билет:
        //"{Символ 1}-{Символ 2}{Символ 3}{Символ  4}"

        for (int s1 = a1; s1 <= a2 - 1; s1++) {
            for (int s2 = 1; s2 <= n - 1; s2++) {
                for (int s3 = 1; s3 <= n / 2 - 1; s3++) {
                    int s4 = s1;
                    if (s1 % 2 != 0 && (s2 + s3 + s4) % 2 != 0) {
                        System.out.printf("%c-%d%d%d%n", s1, s2, s3, s4);
                    }
                }
            }
        }
    }
}
