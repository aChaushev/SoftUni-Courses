package _15_Workshop_Lab;

import java.util.function.Consumer;

/**
 * Custom implementation of LIFO data structure
 */
// добавя форма за писане на документация - multiline comment

public class Stack {

    private static class Node {  // inner class // static -> обвързано е с класа, а не с инстанциите
        private int element;
        private Node prev;  // инициализирамо класа в неговото тяло

        public Node(int element) {
            this.element = element;
        }
    }


    private Node top;
    private int size;

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.prev = top;
        top = newNode;
        size++;

    }

    public int pop() {
        ensureNotEmpty();
        int value = top.element;
        top = top.prev;
        size--;
        return value;
    }

    private void ensureNotEmpty() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty!");
        }
    }

    public int peek() {
        ensureNotEmpty();
        return top.element;

    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = top;  // за да не променяме състоянието на стека инициализираме нов Node

        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
