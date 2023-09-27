package _14_Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numInput = Double.parseDouble(scanner.nextLine());
        double powerInput = Double.parseDouble(scanner.nextLine());

        double result = matPower(numInput,powerInput);
        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(result));
    }

    public static double matPower(double num, double power) {
        double result = 1;
        for (int i = 1; i <= power ; i++) {
            result *= num;
        }
        return result;
    }
}
