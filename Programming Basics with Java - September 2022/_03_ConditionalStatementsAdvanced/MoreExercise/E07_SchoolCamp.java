package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E07_SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.	Сезонът – текст - “Winter”, “Spring” или “Summer”;
        //2.	Видът на групата – текст - “boys”, “girls” или “mixed”;
        //3.	Брой на учениците – цяло число в интервала [1 … 10000];
        //4.	Брой на нощувките – цяло число в интервала [1 … 100].
        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int overnightStays = Integer.parseInt(scanner.nextLine());

        //	                Зимна ваканция	Пролетна ваканция	Лятна ваканция
        //момчета/момичета	9.60	        7.20	            15
        //смесена група	    10	            9.50	            20

        //	                Зимна ваканция	Пролетна ваканция	Лятна ваканция
        //момичета	        Gymnastics	    Athletics	        Volleyball
        //момчета	        Judo	        Tennis	            Football
        //смесена група	    Ski	            Cycling	            Swimming
        double overnightStayPrice = 0;
        String sportType = "";
        if (season.equals("Winter")) {
            if (groupType.equals("girls")) {
                overnightStayPrice = overnightStays * 9.60 * students;
                sportType = "Gymnastics";
            } else if (groupType.equals("boys")) {
                overnightStayPrice = overnightStays * 9.60 * students;
                sportType = "Judo";
            } else if (groupType.equals("mixed")) {
                overnightStayPrice = overnightStays * 10 * students;
                sportType = "Ski";
            }
        } else if (season.equals("Spring")) {
            if (groupType.equals("girls")) {
                overnightStayPrice = overnightStays * 7.20 * students;
                sportType = "Athletics";
            } else if (groupType.equals("boys")) {
                overnightStayPrice = overnightStays * 7.20 * students;
                sportType = "Tennis";
            } else if (groupType.equals("mixed")) {
                overnightStayPrice = overnightStays * 9.50 * students;
                sportType = "Cycling";
            }
        } else if (season.equals("Summer")) {
            if (groupType.equals("girls")) {
                overnightStayPrice = overnightStays * 15 * students;
                sportType = "Volleyball";
            } else if (groupType.equals("boys")) {
                overnightStayPrice = overnightStays * 15 * students;
                sportType = "Football";
            } else if (groupType.equals("mixed")) {
                overnightStayPrice = overnightStays * 20 * students;
                sportType = "Swimming";
            }
        }
        if (10 <= students && students < 20) {
            overnightStayPrice -= overnightStayPrice * 0.05;
        } else if (20 <= students && students < 50) {
            overnightStayPrice -= overnightStayPrice * 0.15;
        } else if (students >= 50) {
            overnightStayPrice -= overnightStayPrice * 0.5;
        }
        System.out.printf("%s %.2f lv.", sportType, overnightStayPrice);
    }
}

