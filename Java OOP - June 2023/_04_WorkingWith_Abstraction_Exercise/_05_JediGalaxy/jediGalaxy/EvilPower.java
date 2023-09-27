package _04_WorkingWith_Abstraction_Exercise._05_JediGalaxy.jediGalaxy;

public class EvilPower {

    private int row;

    private int col;

    public EvilPower(int[] positions) {
        this.row = positions[0];
        this.col = positions[1];
    }

    public void move(Field field) {
        while (row >= 0 && col >= 0) {
            if (field.isInBounds(row, col)) {
                field.setValue(row, col, 0);
            }
            row--;
            col--;
        }
    }
}
