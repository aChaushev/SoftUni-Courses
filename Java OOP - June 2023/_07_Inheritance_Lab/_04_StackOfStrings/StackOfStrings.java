package _07_Inheritance_Lab._04_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    //•	Private field: data: ArrayList<String>
    //•	Public method: push(String item): void
    //•	Public method: pop(): String
    //•	Public method: peek(): String
    //•	Public method: isEmpty(): boolean
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        data.add(element);
    }

    public String pop() {
        return data.remove(data.size() - 1);
    }

    public String peek() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


}
