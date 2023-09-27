package _10_InterfacesAndAbstraction_Exercise._03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

//        List<Citizen> peopleList = new ArrayList<>();
//        List<Pet> petList = new ArrayList<>();
        List<Birthable> thingsWithBirthday = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String objectType = tokens[0];
            switch(objectType){
                case "Citizen":
                    //Citizen Peter 22 9010101122 10/10/1990
                    String personName = tokens[1];
                    int personAge = Integer.parseInt(tokens[2]);
                    String personId = tokens[3];
                    String personBirthDate = tokens[4];
                    Citizen citizen = new Citizen(personName,personAge,personId,personBirthDate);
//                    peopleList.add(citizen);
                    thingsWithBirthday.add(citizen);
                    break;
                case "Pet":
                    //Pet Topcho 24/12/2000
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];
                    Pet pet = new Pet(petName,petBirthDate);
//                    petList.add(pet);
                    thingsWithBirthday.add(pet);
                    break;
                case "Robot":
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

//        for (Citizen citizen : peopleList) {
//            //born in the rif=ght year
//            if(citizen.getBirthDate().endsWith(year)){
//                System.out.println(citizen.getBirthDate());
//            }
//        }
//
//        for (Pet pet : petList) {
//            //born in the rif=ght year
//            if(pet.getBirthDate().endsWith(year)){
//                System.out.println(pet.getBirthDate());
//            }
//        }

        for (Birthable birthable : thingsWithBirthday) {
            if(birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }




    }


}
