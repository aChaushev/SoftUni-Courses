package _17_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String lineInput = scanner.nextLine();
//        List<String> itemsList = Arrays.stream(lineInput.split(" "))
//                .collect(Collectors.toList());
//
//        List<Integer> numbersList = new ArrayList<>();
//        for (int i = 0; i < itemsList.size(); i++) {
//            String currentItemStr = itemsList.get(i);
//            int currentNum = Integer.parseInt(currentItemStr);
//            numbersList.add(currentNum);
//        }

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                 .collect(Collectors.toList());

        List<String> listStr = new ArrayList<>(Arrays.asList(
                "one", "two", "three", "four"
        ));
        System.out.println(String.join(" ", listStr));


    }
}
