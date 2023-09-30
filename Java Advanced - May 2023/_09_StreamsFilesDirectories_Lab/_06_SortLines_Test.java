package _09_StreamsFilesDirectories_Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class _06_SortLines_Test {
    public static void main(String[] args) throws IOException {

        String address = "src/_09_resources\\input.txt";

        Path path = Paths.get(address);
        Stream<String> lines = Files.lines(path);  // не използвай за големи файлове
//        List<String> lines = Files.readAllLines(path);  // не използвай за големи файлове

        lines.forEach(System.out::println);
        // при този случай ред 14-18 -> при получаване на много голям файл програмата ще "гръмне"
        // ако има вероятност файла да нарасне също не се препоръчва


    }
}
