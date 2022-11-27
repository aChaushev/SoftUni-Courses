package _04_ForLoop.Book;

public class B03_LatinLetters {
    public static void main(String[] args) {
        System.out.print("Latin alphabet: ");
        for (char letter = 'a'; letter <= 'z'; letter++) {
            System.out.print(" " + letter);
        }
        System.out.println();
    }
}
