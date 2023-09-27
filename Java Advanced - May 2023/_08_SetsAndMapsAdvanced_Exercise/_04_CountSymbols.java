package _08_SetsAndMapsAdvanced_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbolsMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {

            if(!symbolsMap.containsKey(input.charAt(i))){
                symbolsMap.put(input.charAt(i), 1);
            } else {
                symbolsMap.put(input.charAt(i),symbolsMap.get(input.charAt(i)) + 1);
            }
        }

        symbolsMap.forEach((symbol,counts) ->
                System.out.printf("%c: %d time/s\n",symbol,counts));
    }
}
