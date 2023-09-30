package _09_StreamsFilesDirectories_Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _09_Serialize_Deserialize_Example {
//
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Serialization example
        List<Integer> numbers = new ArrayList<>();

        numbers.add(13);
        numbers.add(42);
        numbers.add(69);
        numbers.add(73);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/_09_resources\\serialization.txt"));

//        DemoClass demoClass = new DemoClass();
//        outputStream.writeObject(demoClass);

        outputStream.writeObject(numbers); // serialization

        outputStream.close();

        // Deserialization example
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/_09_resources\\serialization.txt"));

//        DemoClass demoClass1 = (DemoClass)inputStream.readObject();

        List<Integer> list = (List)inputStream.readObject(); // deserialization

        System.out.println();


    }
}
