package _05_WhileLoop.MoreExercise;

public class E04_NumbersDividedBy3WithoutReminder {
    public static void main(String[] args) {

        for (int i = 3; i <= 99; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
