package _09_StreamsFilesDirectories_Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {

        String address = "src/_09_resources\\input.txt";

        Path path = Paths.get(address);

        List<String> lines = Files.lines(path) // не използвай за големи файлове
                .sorted()
                .collect(Collectors.toList());

        Files.write(Paths.get("_09_resources\\sorted-lines.txt"), lines);

        // не оптимален вариант виж "_06_SortLines_Test", по добре BufferedStream


    }
}
