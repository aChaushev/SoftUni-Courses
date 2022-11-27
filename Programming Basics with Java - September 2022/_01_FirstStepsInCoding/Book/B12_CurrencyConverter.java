package _01_FirstStepsInCoding.Book;

import java.util.Scanner;

public class B12_CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double value = Double.parseDouble(scanner.nextLine());
        String currencyIN = scanner.nextLine();
        String currencyOUT = scanner.nextLine();

        //Курс    USD     EUR     GBP
        //1 BGN   1.79549 1.95583 2.53405
        double currency = 0;
        if (currencyOUT.equals("BGN")) {
            if (currencyIN.equals("USD")) {
                currency = 1.79549;
            } else if (currencyIN.equals("EUR")) {
                currency = 1.95583;
            } else if (currencyIN.equals("GBP")) {
                currency = 2.53405;
            }
        } else if (currencyOUT.equals("USD")) {
            if (currencyIN.equals("BGN")) {
                currency = 1 / 1.79549;
            } else if (currencyIN.equals("EUR")) {
                currency = 1.95583 / 1.79549;
            } else if (currencyIN.equals("GBP")) {
                currency = 2.53405 / 1.79549;
            }
        } else if (currencyOUT.equals("EUR")) {
            if (currencyIN.equals("BGN")) {
                currency = 1 / 1.95583;
            } else if (currencyIN.equals("USD")) {
                currency = 1.79549 / 1.95583;
            } else if (currencyIN.equals("GBP")) {
                currency = 2.53405 / 1.95583;
            }
        } else if (currencyOUT.equals("GBP")) {
            if (currencyIN.equals("BGN")) {
                currency = 1 / 2.53405;
            } else if (currencyIN.equals("USD")) {
                currency = 1.79549 / 2.53405;
            } else if (currencyIN.equals("EUR")) {
                currency = 1.95583 / 2.53405;
            }
        }
        double result = value * currency;
        System.out.printf("%.2f %s", result, currencyOUT);
    }
}
