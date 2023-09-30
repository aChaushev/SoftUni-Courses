package _10_StreamsFilesDirectories_Exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class _00_Demo_Writers {
    public static void main(String[] args) throws IOException {
        //WRITERS -> ПИШЕМ ВЪВ ФАЙЛОВЕТЕ
        String pathToFile = "src\\_10_resources\\demoFileWriter.txt";
        String pathToFile2 = "src\\_10_resources\\demoBufferedWriter.txt";
        //1. FileWriter
        File file = new File(pathToFile);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("This is a demo of file writer.");
        fileWriter.close();

        //2. BufferedWriter -> по-бърз от FileWriter
        File file2 = new File(pathToFile2);
        FileWriter fileWriter2 = new FileWriter(file2);
        BufferedWriter bfWriter = new BufferedWriter(fileWriter2);
        bfWriter.write("This is a demo of buffered writer.");
        bfWriter.close();
    }
}
