package _10_StreamsFilesDirectories_Exercise;

import java.io.*;

public class _05_LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "src\\_10_resources\\inputLineNumbers.txt";

        FileInputStream inputStream = new FileInputStream(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        FileOutputStream outputStream = new FileOutputStream("src\\_10_resources\\output.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = reader.readLine();

        int lineCounter = 1;

        while (line != null){
            writer.write(String.format("%d. %s\n",lineCounter, line));

            line = reader.readLine();
            lineCounter++;
        }
        writer.close();






    }
}
