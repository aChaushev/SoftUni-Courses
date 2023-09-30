package _09_StreamsFilesDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "src/_09_resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream); // "обграждаме" със scanner за да получим повече функционалности

        while (scanner.hasNext()){       //докато скенера чете (има) следващ елемент
            if(scanner.hasNextInt()){   //ако следвашия елемент е int, принтирай следващия int
                System.out.println(scanner.nextInt());
            } else {                    //в противен случай просължи със следвашия елемент
                scanner.next();
            }
        }
    }
}
