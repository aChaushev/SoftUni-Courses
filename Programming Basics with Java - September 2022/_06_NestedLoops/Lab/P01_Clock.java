package _06_NestedLoops.Lab;

public class P01_Clock {
    public static void main(String[] args) {

        for (int hours = 0; hours <= 23; hours++) {
            for (int min = 0; min <= 59; min++) {
                System.out.printf("%d:%d%n",hours,min);
            }
        }
    }
}
