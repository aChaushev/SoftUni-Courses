package _18_List_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E07_AppendArrays__ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> arrays = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(arrays);
        String output = arrays.toString().replaceAll("[\\[\\],]", "");
        System.out.println(output.replaceAll("\\s+", " "));

    }
}
