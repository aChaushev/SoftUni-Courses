package _14_DefiningClasses_Exercise._09_CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Cat> catMap = new HashMap<>();

        while (!line.equals("End")) {
            String[] catData = line.split("\\s+");

            String catBreed = catData[0];
            String catName = catData[1];
            Cat cat = null;

            if (catBreed.equals("Siamese")) {
                double earSize = Double.parseDouble(catData[2]);
                cat = new Siamese(catName, earSize);


            } else if (catBreed.equals("Cymric")) {
                double furLength = Double.parseDouble(catData[2]);
                cat = new Cymric(catName, furLength);


            } else if (catBreed.equals("StreetExtraordinaire")) {
                double decibelsOfMeows = Double.parseDouble(catData[2]);
                cat = new StreetExtraordinaire(catName, decibelsOfMeows);

            }

            catMap.put(catName,cat);

            line = scanner.nextLine();
        }

        String catNameToSearch = scanner.nextLine();
        if(catMap.containsKey(catNameToSearch)){
            System.out.println(catMap.get(catNameToSearch));
        }

    }
}
