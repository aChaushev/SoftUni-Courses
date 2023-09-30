package _10_StreamsFilesDirectories_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_SumLines {
    public static void main(String[] args) throws IOException {
        // всички редове от input.txt
        // за всеки ред -> намирам сумата на ascii -> принтираме сумата

        String pathToFile = "src/_10_resources/input.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathToFile)); // форматирай pathToFile в Path

        //първи начин
        for (String line : allLines){
            int sum = 0;
            for( char symbol : line.toCharArray()){
                sum += symbol;
            }
            System.out.println(sum);
        }
        // втори начин
        allLines.forEach(line -> {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        });

        // трери начин
        allLines.stream().map(line -> line.toCharArray())
                .forEach(arr -> {
                    int sum = 0;
                    for( char symbol : arr){
                        sum += symbol;
                    }
                    System.out.println(sum);
                });

    }
}
