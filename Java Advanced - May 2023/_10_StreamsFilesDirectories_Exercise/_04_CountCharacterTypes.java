package _10_StreamsFilesDirectories_Exercise;

import java.io.*;
import java.util.Set;

public class _04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String pathToFile = "src\\_10_resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));

//        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\_10_resources\\output.txt"));

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');
        Set<Character> vowelsTable = Set.of('a', 'e', 'i', 'o', 'u');

        int vowels = 0;
        int otherSymbols = 0;
        int punctuation = 0;

        String line = reader.readLine();
        while (line != null) {
            for (char symbol : line.toCharArray()) {

                boolean isVowel = vowelsTable.contains(symbol);
                boolean isPunctuation = punctuationTable.contains(symbol);
                boolean isOtherSymbol = symbol != ' ';

                if (isVowel) {
                    vowels++;

                } else if (isPunctuation) {
                    punctuation++;

                } else if (isOtherSymbol) {
                    otherSymbols++;

                }
            }
            line = reader.readLine();
        }
        System.out.printf("Vowels: %d\nOther symbols: %d\nPunctuation: %d\n", vowels, otherSymbols, punctuation);
    }
}
