package _10_StreamsFilesDirectories_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _02_SumBytes {
    public static void main(String[] args) throws IOException {

        // всички редове от input.txt
        // намирам сумата на всички ascii -> принтираме сумата

        String pathToFile = "src/_10_resources/input.txt";
        long sum = 0; //сумата от ASCII на всички символи

//        List<String> allLines = Files.readAllLines(Path.of(pathToFile)); // форматирай pathToFile в Path
//        // начин 1:
//
//        for (String line : allLines){
//            for(char symbol : line.toCharArray()){
//                sum += symbol;
//            }
//        }
//
//        System.out.println(sum);

        // начин 2:
        byte[] allBytes = Files.readAllBytes(Path.of(pathToFile));
        for(byte ascii : allBytes){
            if(ascii != 10 && ascii != 13){ // ако симбола е различен от /n -> newLine и /r -> carriage return
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
