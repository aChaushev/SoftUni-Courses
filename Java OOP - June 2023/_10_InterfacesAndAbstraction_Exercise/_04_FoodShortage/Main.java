package _04_FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //2
        //Peter 25 8904041303 04/04/1989
        //Stan 27 WildMonkeys
        //Peter
        //George
        //Peter
        //End

        Map<String, Buyer> buyerMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personTokens = scanner.nextLine().split("\\s+");
            String personName = personTokens[0];
            int personAge = Integer.parseInt(personTokens[1]);
            Buyer buyer;
            if (personTokens.length == 4) {
                //citizen
                String id = personTokens[2];
                String birthDate = personTokens[3];
                buyer = new Citizen(personName, personAge, id, birthDate);
            } else {
                //rebel
                String group = personTokens[2];
                buyer = new Rebel(personName,personAge,group);
            }

            buyerMap.put(personName,buyer);
        }

        String nameFromConsole = scanner.nextLine();
        while ((!"End".equals(nameFromConsole))){
            Buyer buyer = buyerMap.get(nameFromConsole);
            if(buyer != null){
                buyer.buyFood();
            }

            nameFromConsole = scanner.nextLine();
        }

        int totalFood = buyerMap.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();
        System.out.println(totalFood);


    }


}
