package _09_StreamsFilesDirectories_Lab;

import java.io.*;
import java.util.Set;

public class _03_CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "src/_09_resources\\input.txt";

        FileReader reader = new FileReader(path); // FileReader стъпва върху FileInputStream и добавя функционалности

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("src/_09_resources\\output.txt");

        PrintWriter printer = new PrintWriter(outputStream);

        int bytes = inputStream.read();

        Set<Integer> delimiterTable = Set.of(10, 32); // ASCII за space и newLine

        while (bytes > -1) {

            boolean isDelimiter = delimiterTable.contains(bytes);

            if (isDelimiter) {
                printer.print((char) bytes);
            } else {
                printer.print(bytes);
            }

            bytes = inputStream.read();
        }

        inputStream.close();
        outputStream.close();


    }
}
