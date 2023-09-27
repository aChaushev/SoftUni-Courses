package _11_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P07_CondenseArrayToNumber__H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] condensedArr = new int[numArr.length - 1];

        for (int i = 0; i < numArr.length; i++) {
            if (numArr.length == 1) {   //проверка дали имаме само един елемент
                break;
            }
            if (i == numArr.length - 1) {  //проверка дали сме на последния елемент, за да ибегнем събиране на повече елементи отколкото имаме т.е. гршка
                int[] condensedNew = new int[condensedArr.length - 1]; // нов масив с нулеви/default стойности на елементите
                i = -1;                     // сетване на -1 за да продължи/отначало от i = 0
                numArr = condensedArr;      // numArr e сетнат като нов масив с толкова брой елемени колкото condensedArr
                condensedArr = condensedNew;// condensedArr се занулява
            } else {
                condensedArr[i] = numArr[i] + numArr[i + 1];
            }
        }
        System.out.println(numArr[0]);
    }
}
