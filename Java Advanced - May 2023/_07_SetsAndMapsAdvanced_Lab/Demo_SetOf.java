package _07_SetsAndMapsAdvanced_Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class Demo_SetOf {
    public static void main(String[] args) throws IOException {

        String path = "resources_StreamsFiles\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        int bytes = fileInputStream.read();

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');

            char symbol = (char) bytes;

            boolean isPunctuation = punctuationTable.contains(symbol);

    }
}
