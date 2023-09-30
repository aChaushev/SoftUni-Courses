package _09_StreamsFilesDirectories_Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_ReadFile {
    public static void main(String[] args) {


        String path = "src/_09_resources\\input.txt";


        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            int bytes = fileInputStream.read();

            while (bytes > -1) {
                System.out.print(Integer.toBinaryString(bytes) + " ");

                bytes = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
