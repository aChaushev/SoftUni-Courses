package _09_StreamsFilesDirectories_Lab;

import java.io.File;
import java.util.ArrayDeque;

public class _07_08_ListFilesFolders {
    public static void main(String[] args) {

        String address = "src/_09_resources\\Files-and-Streams";

        File root = new File(address);

        // BFS (Breadth First Search) - трърсене в широчина -> ред 16-31
        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            File file = queue.poll();  // всеки, който е наред в опашката го вземи

            System.out.println(file.getName()); // отпечатай името на всеки файл

            File[] files = file.listFiles(); //дава масив от всички вътрешни файлове в един файл (ако е директория)
            if (files != null) {        // ако има подфайлове
                for (File f : files) {
                    queue.offer(f);     // добави ги опашката
                }
            }


            // DFS (Deep First Search) - търсене в дълбочина


        }
    }
}
