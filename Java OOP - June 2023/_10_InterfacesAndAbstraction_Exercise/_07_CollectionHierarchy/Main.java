package _10_InterfacesAndAbstraction_Exercise._07_CollectionHierarchy;

import java.util.Scanner;

public class Main {

    // create interfaces
    // create abstract class
    // create classes

    // in main -> initialize 3 collections
    // perform add to every collection
    // perform remove to addRemove and myList
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] words = scanner.nextLine().split("\\s+");
        int numberRemoveOperation = Integer.parseInt(scanner.nextLine());

        performAddOperation(words,addCollection);
        performAddOperation(words,addRemoveCollection);
        performAddOperation(words,myList);

        performRemoveOperations(numberRemoveOperation,addRemoveCollection);
        performRemoveOperations(numberRemoveOperation,myList);


    }

    public static void performRemoveOperations(int counter, AddRemovable addRemovable){
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove() + " ");
        }
        System.out.println();

    }

    public static void performAddOperation(String[] words, Addable addable){
        for (String word : words) {
            System.out.print(addable.add(word) + " ");
        }
        System.out.println();
    }
}
