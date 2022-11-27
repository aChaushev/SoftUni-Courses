package _07_ExamPreparation.July;

import java.util.Scanner;

public class P03_WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Етап на първенството – текст - “Quarter final ”, “Semi final” или “Final”
        //2. Вид на билета – текст - “Standard”, “Premium” или “VIP”
        //3. Брой билети – цяло число в интервала [1 … 30]
        //4. Снимка с трофея – символ – 'Y' (да) или 'N' (не)

        String stage = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int ticketCount = Integer.parseInt(scanner.nextLine());
        char picWithTrophy = scanner.nextLine().charAt(0);

        double ticketCost = 0;
        if (stage.equals("Quarter final")) {
            if (ticketType.equals("Standard")) {
                ticketCost = 55.50;
            } else if (ticketType.equals("Premium")) {
                ticketCost = 105.20;
            } else if (ticketType.equals("VIP")) {
                ticketCost = 118.90;
            }
        } else if (stage.equals("Semi final")) {
            if (ticketType.equals("Standard")) {
                ticketCost = 75.88;
            } else if (ticketType.equals("Premium")) {
                ticketCost = 125.22;
            } else if (ticketType.equals("VIP")) {
                ticketCost = 300.40;
            }
        } else if (stage.equals("Final")) {
            if (ticketType.equals("Standard")) {
                ticketCost = 110.10;
            } else if (ticketType.equals("Premium")) {
                ticketCost = 160.66;
            } else if (ticketType.equals("VIP")) {
                ticketCost = 400;
            }
        }

        double allTicketsCost = ticketCount * ticketCost;
        double totalCost = allTicketsCost;

        //• Над 4000 лири има 25% отстъпка и безплатни снимки с трофея (ако опцията за снимки е избрана,
        // таксата от 40 лири за билет не се включва)
        //• Над 2500 лири има 10% отстъпка

        if (allTicketsCost > 2500 && allTicketsCost <= 4000) {
            totalCost -= totalCost * 0.1;
        } else if (allTicketsCost > 4000) {
            totalCost -= totalCost * 0.25;
        }

        if (picWithTrophy == 'Y' && allTicketsCost <= 4000) {
            totalCost += (ticketCount * 40);
        }
        System.out.printf("%.2f", totalCost);
    }
}
