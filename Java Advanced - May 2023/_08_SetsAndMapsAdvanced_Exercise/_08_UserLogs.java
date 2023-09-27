package _08_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> usersMap = new TreeMap<>();

        while (!input.equals("end")) {
            // input = "IP={IP.Address} message={A&sample&message} user={username}"
            String ip = input.split("\\s+")[0].split("=")[1];
            String message = input.split("\\s+")[1].split("=")[1];
            String user = input.split("\\s+")[2].split("=")[1];

            usersMap.putIfAbsent(user, new LinkedHashMap<>());

            Map<String, Integer> ipMap = usersMap.get(user);

            if (!ipMap.containsKey(ip)) {
                ipMap.put(ip, 1);
            } else {
                ipMap.put(ip, ipMap.get(ip) + 1);
            }

            input = scanner.nextLine();
        }

        usersMap.forEach((user, ips) -> {
            System.out.println(user + ": ");
            int count = 0;
            for (Map.Entry<String, Integer> entry : ips.entrySet()) {
                count++;
                if (count < ips.size()) {
                    System.out.printf("%s => %d, ", entry.getKey(), entry.getValue());
                } else {
                    System.out.printf("%s => %d.\n", entry.getKey(), entry.getValue());
                }
            }
        });
    }
}
