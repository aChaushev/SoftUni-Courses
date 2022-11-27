package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E03_TravelAgency_booleanSCAN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.	Име на града - текст с възможности ("Bansko",  "Borovets", "Varna" или "Burgas")
        //2.	Вид на пакета - текст с възможности ("noEquipment",  "withEquipment", "noBreakfast" или "withBreakfast")
        //3.	Притежание на VIP отстъпка - текст с възможности  "yes" или "no"
        //4.	Дни за престой - цяло число в интервала [1 … 10000]
        String cityName = scanner.nextLine();
        String packageType = scanner.nextLine();
        String vipCard = scanner.nextLine(); //boolean hasVIP = scanner.nextLine().equals("yes");
        int daysStay = Integer.parseInt(scanner.nextLine());
        //	                    Банско/Боровец	                    Варна/Бургас
        //	            с екипировка	без екипировка	    със закуска	    без закуска
        //Цена за ден	100лв.	        80лв	            130лв.	        100лв.
        //VIP отстъпка	10%	            5%	                12%	            7%

        double dayStayPrice = 0;
        boolean inValid = false;
        if (cityName.equals("Bansko") || cityName.equals("Borovets")) {
            if (packageType.equals("noEquipment")) {
                dayStayPrice = 80;
                if (vipCard.equals("yes")) {
                    dayStayPrice -= dayStayPrice * 0.05;
                }
            } else if (packageType.equals("withEquipment")) {
                dayStayPrice = 100;
                if (vipCard.equals("yes")) {
                    dayStayPrice -= dayStayPrice * 0.1;
                }
            } else {
                inValid = true;
            }

        } else if (cityName.equals("Varna") || cityName.equals("Burgas")) {
            if (packageType.equals("noBreakfast")) {
                dayStayPrice = 100;
                if (vipCard.equals("yes")) {
                    dayStayPrice -= dayStayPrice * 0.07;
                }
            } else if (packageType.equals("withBreakfast")) {
                dayStayPrice = 130;
                if (vipCard.equals("yes")) {
                    dayStayPrice -= dayStayPrice * 0.12;
                }
            } else {
                inValid = true;
            }

        } else {
            inValid = true;
        }

        if (daysStay > 7) {
            daysStay -= 1;
        }

        double allDaysCost = daysStay * dayStayPrice;
        if (inValid) {
            System.out.println("Invalid input!");
        } else if (daysStay < 1) {
            System.out.println("Days must be positive number!");
        } else {
            System.out.printf("The price is %.2flv! Have a nice time!", allDaysCost);
        }
    }
}
