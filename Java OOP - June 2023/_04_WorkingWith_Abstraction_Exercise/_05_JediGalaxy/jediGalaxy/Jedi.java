package _04_WorkingWith_Abstraction_Exercise._05_JediGalaxy.jediGalaxy;

public class Jedi {
    private int row;
    private int col;

    public Jedi(int[] positions) {
        this.row = positions[0];
        this.col = positions[1];
    }

    public int move(Field field) {
        int starsCount = 0;
        while (row >= 0 && col < field.getColLength()) {
            if (field.isInBounds(row, col)) {
                starsCount += field.getValue(row, col);
            }
            col++;
            row--;
        }
        return starsCount;

    }
}
