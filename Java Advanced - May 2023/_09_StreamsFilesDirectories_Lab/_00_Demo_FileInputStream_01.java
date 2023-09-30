package _09_StreamsFilesDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _00_Demo_FileInputStream_01 {
    public static void main(String[] args) {


        String path = "D:\\_SoftUni\\xxx_Java Advanced - септември 2022\\09-10-Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            String FileInputStream = null;
            Scanner scanner = new Scanner(FileInputStream);

            String input = scanner.nextLine();

            List<String> fileContent = new ArrayList<>();

            while(!input.equals("END")){
                fileContent.add(input);
                input = scanner.nextLine();
            }

            System.out.println(String.join(System.lineSeparator(),fileContent));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
