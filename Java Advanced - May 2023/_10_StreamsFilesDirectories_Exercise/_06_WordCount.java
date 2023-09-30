package _10_StreamsFilesDirectories_Exercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_WordCount {
    public static void main(String[] args) throws IOException {
        // words.txt -> думи които трябва да търсим
        String pathWords = "src/_10_resources/words.txt";

        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));

        // думи -> брой срещания
        Map<String, Integer> countWords = new HashMap<>();

        // да намерим думите, които ще търсим и да ги добавим в Map-а
        for (String line : allLinesWithWords) {
            line = line.replaceAll("[.,!?:]","");
            String[] wordsOnCurrentRow = line.split("\\s+");

            Arrays.stream(wordsOnCurrentRow).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        // да преброим горенамерените думи колкоп ъти ще се срещат в text.txt
        String pathText = "src/_10_resources/text.txt";

        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));

        for (String line : allLinesWithText) {
            line = line.replaceAll("[.,!?:]","");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }

        // Сортиране по броя на срещанията и записване в нов файл

        PrintWriter writer = new PrintWriter("src/_10_resources/result.txt");

        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();


    }
}
