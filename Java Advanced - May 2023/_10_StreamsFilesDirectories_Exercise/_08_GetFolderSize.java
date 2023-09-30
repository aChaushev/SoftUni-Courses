package _10_StreamsFilesDirectories_Exercise;

import java.io.File;

public class _08_GetFolderSize {
    public static void main(String[] args) {

        String pathFolder = "src/_10_resources/Exercises Resources";

        File folder = new File(pathFolder);

        File[] allFilesInFolder = folder.listFiles(); //масив със всички файлове във папката

        int folderSize = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);

    }
}
