import java.util.Scanner;

public class LiveExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String cocktailName = scanner.nextLine();
        double cocktailPrice =  cocktailName.length();
        int n =Integer.parseInt(scanner.nextLine());

        System.out.println(cocktailPrice);
        System.out.printf("%c%n", 96);
        System.out.printf("%c%n", 'a' + 23);
        System.out.println(128.5 % 1);
        System.out.println(128 % 1);
        System.out.println(48.5 / 50);
        System.out.println(6 % 3);
        System.out.println(Math.sqrt(9));
//        int n = Integer.parseInt(scanner.nextLine());

//
//        int maxNum = n;
//        int minNum = n;
//
//        for (int i = 1; i <= n; i++) {
//            int currentNum = Integer.parseInt(scanner.nextLine());
//
//            if (currentNum > maxNum) {
//                maxNum = currentNum;
//            }
//            if (currentNum < minNum) {
//                minNum = currentNum;
//            }
//        }
//        System.out.printf("Max number: %d%n", maxNum);
//        System.out.printf("Min number: %d", minNum);
    }
}


