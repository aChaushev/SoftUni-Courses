package _10_StreamsFilesDirectories_Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class _07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathOne = "src/_10_resources/inputOne.txt";

        String pathTwo = "src/_10_resources/inputTwo.txt";

        List<String> listOne = Files.readAllLines(Path.of(pathOne));
        List<String> listTwo = Files.readAllLines(Path.of(pathTwo));



        List<String> resultList = new ArrayList<>();
        resultList.addAll(listOne);
        resultList.addAll(listTwo);

        PrintWriter writer = new PrintWriter("src/_10_resources/output.txt");

        for (String element : resultList){
            writer.println(element);
        }
        writer.close();



    }
}
