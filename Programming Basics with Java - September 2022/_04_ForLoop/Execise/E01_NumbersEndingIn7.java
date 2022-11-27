package _04_ForLoop.Execise;

public class E01_NumbersEndingIn7 {
    public static void main(String[] args) {

//        for (int i = 1; i <= 1000 ; i++) {
//            if ( i % 10 == 7) {
//                System.out.println(i);
//            }
//        }
        for (int i = 7; i <= 997; i += 10) {
            System.out.println(i);
        }
    }
}
