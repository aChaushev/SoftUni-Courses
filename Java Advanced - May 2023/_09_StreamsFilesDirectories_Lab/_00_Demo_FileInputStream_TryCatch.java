package _09_StreamsFilesDirectories_Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class _00_Demo_FileInputStream_TryCatch {
    public static void main(String[] args) {


        String path = "D:\\_SoftUni\\xxx_Java Advanced - септември 2022\\09-10-Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        // изпълнявайки кода между try {..........} catch (условие) ,ако се случи това условие изпълни долупосоченото
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            //1010101 -> byte
            int bytes = fileInputStream.read();

            while (bytes != -1) {
                System.out.print((char) bytes); // (Integer.toBinaryString(bytes)) ако искаме да отпечатаме машинния код 01010...
                bytes = fileInputStream.read();
            }

        } catch (IOException e) { // включва по-голям брой грешки, една от които е "FileNotFoundException
            // изпълнявайки кода между try {..........} catch (условие) ,ако се случи това условие изпълни долупосоченото
            // примерно System.out.println("The file " + path + " is missing");
            throw new RuntimeException(e);
        } finally {
            // finally се изпълнява винаги, независимо дали има catch или не
            // finally is executed no matter what ДОРИ И АКО ПРЕДИ НЕГО ИМА return;-> прекрати работата на програмата
        }
    }
}
