package _02_ConditionalStatements.Book;

import java.util.Scanner;

public class B16_Number0_100ToText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int digit1 = num / 10; // при 0 е едноцифрено
        int digit02 = num % 10;

        String result = "";
        String result1 = "";
        String result02 = "";
        if (digit1 == 0) {
            if (digit02 == 0) {
                result = "zero";
            } else if (digit02 == 1) {
                result = "one";
            } else if (digit02 == 2) {
                result = "two";
            } else if (digit02 == 3) {
                result = "three";
            } else if (digit02 == 4) {
                result = "four";
            } else if (digit02 == 5) {
                result = "five";
            } else if (digit02 == 6) {
                result = "six";
            } else if (digit02 == 7) {
                result = "seven";
            } else if (digit02 == 8) {
                result = "eight";
            } else if (digit02 == 9) {
                result = "nine";
            }
        } else if (digit1 == 1) {
            if (digit02 == 0) {
                result = "ten";
            } else if (digit02 == 1) {
                result = "eleven";
            } else if (digit02 == 2) {
                result = "twelve";
            } else if (digit02 == 3) {
                result = "thirteen";
            } else if (digit02 == 4) {
                result = "fourteen";
            } else if (digit02 == 5) {
                result = "fifteen";
            } else if (digit02 == 6) {
                result = "sixteen";
            } else if (digit02 == 7) {
                result = "seventeen";
            } else if (digit02 == 8) {
                result = "eighteen";
            } else if (digit02 == 9) {
                result = "nineteen";
            }
        }

        if (digit1 == 2) {
            result1 = "twenty";
        } else if (digit1 == 3) {
            result1 = "thirty";
        } else if (digit1 == 4) {
            result1 = "forty";
        } else if (digit1 == 5) {
            result1 = "fifty";
        } else if (digit1 == 6) {
            result1 = "sixty";
        } else if (digit1 == 7) {
            result1 = "seventy";
        } else if (digit1 == 8) {
            result1 = "eighty";
        } else if (digit1 == 9) {
            result1 = "ninety";
        }

        if (digit02 == 0) {
            result02 = "";
        } else if (digit02 == 1) {
            result02 = "one";
        } else if (digit02 == 2) {
            result02 = "two";
        } else if (digit02 == 3) {
            result02 = "three";
        } else if (digit02 == 4) {
            result02 = "four";
        } else if (digit02 == 5) {
            result02 = "five";
        } else if (digit02 == 6) {
            result02 = "six";
        } else if (digit02 == 7) {
            result02 = "seven";
        } else if (digit02 == 8) {
            result02 = "eight";
        } else if (digit02 == 9) {
            result02 = "nine";
        }

        if (num == 100) {
            System.out.println("one hundred");
        } else if (0 <= num && num < 20) {
            System.out.println(result);
        } else if (digit02 == 0) {
            System.out.println(result1);
        } else if (20 <= num && num < 100) {
            System.out.printf("%s %s%n", result1, result02);
        }
    }
}
