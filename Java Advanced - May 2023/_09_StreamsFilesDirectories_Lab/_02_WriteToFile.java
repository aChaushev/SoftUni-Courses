package _09_StreamsFilesDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class _02_WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "src/_09_resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("src/_09_resources/output.txt");

        int bytes = inputStream.read();

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');

        while (bytes > -1) {

            char symbol = (char) bytes;

            boolean isPunctuation = punctuationTable.contains(symbol);

            if (!isPunctuation) {
                outputStream.write(symbol);
                System.out.print(symbol);
            }

            bytes = inputStream.read();
        }


    }
}
