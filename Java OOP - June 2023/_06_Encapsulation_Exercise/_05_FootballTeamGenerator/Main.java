package _06_Encapsulation_Exercise._05_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Team> teamsMap = new LinkedHashMap<>();

        while (!"END".equals(line)) {
            String[] commandParts = line.split(";");
            String commandName = commandParts[0];
            String teamName = commandParts[1];

            try {

                switch (commandName) {
                    case "Team":
                        Team teamToCreate = new Team(teamName);
                        teamsMap.putIfAbsent(teamName, teamToCreate);
                        break;
                    case "Add":
                        //endurance:  int
                        //sprint:  int
                        //dribble: int
                        //passing: int
                        //shooting: int
                        String playerName = commandParts[2];
                        int endurance = Integer.parseInt(commandParts[3]);
                        int sprint = Integer.parseInt(commandParts[4]);
                        int dribble = Integer.parseInt(commandParts[5]);
                        int passing = Integer.parseInt(commandParts[6]);
                        int shooting = Integer.parseInt(commandParts[7]);


                        if (!teamsMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teamsMap.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerToRemove = commandParts[2];
                        teamsMap.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if (!teamsMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teamsMap.get(teamName).getRating()));
                        }
                        break;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }


            line = scanner.nextLine();
        }


    }
}
