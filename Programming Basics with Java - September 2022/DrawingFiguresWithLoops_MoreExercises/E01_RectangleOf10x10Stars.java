package DrawingFiguresWithLoops_MoreExercises;

public class E01_RectangleOf10x10Stars {
    public static void main(String[] args) {

        char star = '*';
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
