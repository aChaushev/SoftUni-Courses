package _10_StreamsFilesDirectories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;

public class _03_ALL_CAPITALS {
    public static void main(String[] args) throws IOException {

        String pathToFile = "src\\_10_resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\_10_resources\\output.txt"));

//        // начин 1
//        List<String> allLines = Files.readAllLines(Path.of(pathToFile)); //взима всички редове
//
//        for (String line : allLines) {
//            writer.write(line.toUpperCase());
//            writer.newLine();
//        }
//        writer.close();

        // начин 2
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile)); //взима редовете ред по ред без /n (newLine) и /r (carriage return)

        String line = reader.readLine();

        while (line != null){
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }
        writer.close();

    }
}
