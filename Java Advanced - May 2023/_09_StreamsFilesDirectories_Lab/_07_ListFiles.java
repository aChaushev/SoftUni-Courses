package _09_StreamsFilesDirectories_Lab;

import java.io.File;

public class _07_ListFiles {
    public static void main(String[] args) {

        String address = "src/_09_resources\\Files-and-Streams";

        File file = new File(address);

        if (file.isDirectory() && file.exists()) {
            File[] files = file.listFiles(); //дава масив от всички вътрешни файлове в един файл (ако е директория)
            for (File f : files) {
                if (f.isFile()) {
                    long size = f.length();
                    System.out.printf("%s: [%d]\n", f.getName(), size);
                }
            }
        }
    }
}
