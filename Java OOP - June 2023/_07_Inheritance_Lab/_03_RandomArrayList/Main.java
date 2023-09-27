package _07_Inheritance_Lab._03_RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        randomArrayList.add(13);
        randomArrayList.add(42);
        randomArrayList.add(73);
        randomArrayList.add(69);

        System.out.println(randomArrayList.getRandomElement());
    }
}
