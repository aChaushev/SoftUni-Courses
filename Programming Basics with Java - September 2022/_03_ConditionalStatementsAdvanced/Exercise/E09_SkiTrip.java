package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E09_SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред - дни за престой - цяло число в интервала [0...365]
        //•	Втори ред - вид помещение - "room for one person", "apartment" или "president apartment"
        //•	Трети ред - оценка - "positive"  или "negative"

        int daysStay = Integer.parseInt(scanner.nextLine());
        String typeOfRoom = scanner.nextLine();
        String rating = scanner.nextLine();

        //	"room for one person" – 18.00 лв за нощувка
        //	"apartment" – 25.00 лв за нощувка
        //	"president apartment" – 35.00 лв за нощувка

        double roomForOne = 18.00;
        double apartment = 25.00;
        double presidentApart = 35.00;

        //вид помещение	        по-малко от 10 дни	    между 10 и 15 дни	    повече от 15 дни
        //room for one person	не ползва намаление	    не ползва намаление	    не ползва намаление
        //apartment	            30% от крайната цена	35% от крайната цена	50% от крайната цена
        //president apartment	10% от крайната цена	15% от крайната цена	20% от крайната цена
        int overnightStay = daysStay - 1;
        double overnightStayPrice = 0;
        if (typeOfRoom.equals("room for one person")) {
            overnightStayPrice = 18.00 * overnightStay;
        } else if (typeOfRoom.equals("apartment")) {
            if (daysStay < 10) {
                overnightStayPrice = (25.00 * overnightStay) * 0.7;
            } else if (10 <= daysStay && daysStay <= 15) {
                overnightStayPrice = (25.00 * overnightStay) * 0.65;
            } else if (daysStay > 15) {
                overnightStayPrice = (25.00 * overnightStay) * 0.5;
            }
        } else if (typeOfRoom.equals("president apartment")) {
            if (daysStay < 10) {
                overnightStayPrice = (35.00 * overnightStay) * 0.9;
            } else if (10 <= daysStay && daysStay <= 15) {
                overnightStayPrice = (35.00 * overnightStay) * 0.85;
            } else if (daysStay > 15) {
                overnightStayPrice = (35.00 * overnightStay) * 0.8;
            }
        }
        if (rating.equals("positive")) {
            overnightStayPrice = overnightStayPrice + overnightStayPrice * 0.25;
        } else if (rating.equals("negative")) {
            overnightStayPrice = overnightStayPrice - overnightStayPrice * 0.1;
        }
        System.out.printf("%.2f", overnightStayPrice);
    }
}
