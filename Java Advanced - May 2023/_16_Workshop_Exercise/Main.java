
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Node node = new Node(1);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//
//        node.next = node1;
//        node1.next = node2;
//
//        System.out.println(node.next.next.value);

        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);


        System.out.println(list.get(0));
        System.out.println(list.get(3));
        System.out.println(list.get(2));

        System.out.println();

    }
}
