package _07_Inheritance_Lab._03_RandomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    public Object getRandomElement() {
        int index = ThreadLocalRandom.current().nextInt(0, size());
        return get(index);
    }
}

