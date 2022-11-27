package _03_ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P12_TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double salesVolume = Double.parseDouble(scanner.nextLine());

        //Град	    0 ≤ s ≤ 500	    500 < s ≤ 1 000	    1 000 < s ≤ 10 000	    s > 10 000
        //Sofia	    5%	            7%	                8%	                    12%
        //Varna	    4.5%	        7.5%	            10%	                    13%
        //Plovdiv	5.5%	        8%	                12%	                    14.5%

        boolean a = 0 <= salesVolume && salesVolume <= 500;
        boolean b = 500 < salesVolume && salesVolume <= 1000;
        boolean c = 1000 < salesVolume && salesVolume <= 10000;
        boolean d = salesVolume > 10000;

        boolean isValid = true;
        double percent = 0;
        if (city.equals("Sofia")) {
            if (a) {
                percent = 0.05;
            } else if (b) {
                percent = 0.07;
            } else if (c) {
                percent = 0.08;
            } else if (d) {
                percent = 0.12;
            } else {
                isValid = false;
            }
        } else if (city.equals("Varna")) {
            //Varna	    4.5%	        7.5%	            10%	                    13%
            if (a) {
                percent = 0.045;
            } else if (b) {
                percent = 0.075;
            } else if (c) {
                percent = 0.10;
            } else if (d) {
                percent = 0.13;
            } else {
                isValid = false;
            }
        } else if (city.equals("Plovdiv")) {
            //Plovdiv	5.5%	        8%	                12%	                    14.5%
            if (a) {
                percent = 0.055;
            } else if (b) {
                percent = 0.08;
            } else if (c) {
                percent = 0.12;
            } else if (d) {
                percent = 0.145;
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        double commission = percent * salesVolume;
        if (isValid) {
            System.out.printf("%.2f", commission);
        } else {
            System.out.println("error");
        }
    }
}
