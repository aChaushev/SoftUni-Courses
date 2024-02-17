package _15_Workshop_Lab;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Integer> arrayList = new ArrayList<>();
//
////        long startArrayList = System.currentTimeMillis();
//
//
//
//        for (int i = 0; i < 5; i++) {
//            arrayList.add(i + 1);
//        }
//
//
//        SmartArray smartArray = new SmartArray();
//
//        for (int i = 0; i < 4; i++) {
//            smartArray.add(i + 1);
//        }
//
//        smartArray.add(1,13);
//
//        smartArray.forEach(System.out::println);
//
////        for (int i = 0; i < smartArray.size(); i++) {
////            System.out.println(smartArray.get(i));
////        }

        Stack stack = new Stack();

        stack.push(13);
        stack.push(69);

        System.out.println(stack.isEmpty());

        stack.forEach(System.out::println);

        System.out.println(stack.pop());
        System.out.println(stack.pop());







    }
}
