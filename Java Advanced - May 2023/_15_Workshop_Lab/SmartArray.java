package _15_Workshop_Lab;

import java.util.function.Consumer;

public class SmartArray {

    private int[] data;
    private int size;  // инизиализираме променлива index, index = size


    private int[] grow() {
        int newLength = data.length * 2; // n * O(log n) // old int newLength = data.length + 1; n * О(n)

        int[] newData = new int[newLength];

        System.arraycopy(data, 0, newData, 0, data.length);
        // или        for (int i = 0; i < data.length; i++) {
        //            newData[i] = data[i];
        //        }

        return newData;
    }

    private int[] shrink(){  // намаля големината на масива, ако сме remove-нали дотатъчно елементи, че да намалиме дължината два пъти
        int newLength = data.length / 2;

        int[] newData = new int[newLength];

        System.arraycopy(data, 0, newData, 0, size);

        return newData;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= size) { // проверка дали индекса е извън рамерите на масива и хвърляне на грешка ако е
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public SmartArray() {
        this.size = 0;  // при нов SmartArray size(index) почва от 0
        this.data = new int[4]; // инициализираме нов масив с определен брой елементи
    }

    public void add(int element) {
        if (size == data.length) {  // когато изкам да добавим но нямамеповече място в масива
            data = grow();   // добавяме метод (вътрешен) за овеличаване рамера на масива
        }

        data[size++] = element; // при използване на add size(index) се увеличава с 1
    }

    public int get(int index) {
        ensureIndex(index); // проверка дали индекса е извън рамерите на масива
        return data[index];
    }

    public int size() {  // взимане на рамера на масива
        return size;
    }

    public int remove(int index) {
        int removedElement = get(index);

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1]; // по-големия индекс идва на мястото на по-малкия -> изместваме елементите на ляво
        }
        data[size - 1] = 0; // премахваме последния останал най-десен елемент
        size--;

        if (size == data.length / 4) { // ако размера е равен на половината от дължината намаляме масива
            data = shrink();
        }


        return removedElement;

    }

    public boolean contains(int element) {

        for (int i = 0; i < size; i++) {  // проверяваме дали всеки един елемент е търсения елемент
            int next = data[i];
            if (element == next) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {

        int lastElement = data[size - 1];

        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;

        add(lastElement);

    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }


}
