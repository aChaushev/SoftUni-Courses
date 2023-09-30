package _09_StreamsFilesDirectories_Lab;

import java.io.*;

public class _09_SerializeCustomObject {
    public static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3.0;

        String path = "src/_09_resources\\save.txt";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))){
            outputStream.writeObject(cube);
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        try (ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream("src/_09_resources\\save.txt"))){
            Cube cube1 = (Cube) inputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
