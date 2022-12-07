package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputPowerN = Integer.parseInt(scanner.nextLine());
        int targetDistanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());
        // N-M докато N<M`
        // N-M -> target++
        // if N = N/2.0 -> N/Y
        int targetPokedCnt = 0;
        int pokePowerN = inputPowerN;
        while (pokePowerN >= targetDistanceM) {
            pokePowerN -= targetDistanceM;
            targetPokedCnt++;
            if (pokePowerN == inputPowerN * 0.5 && exhaustionFactorY != 0) {
                pokePowerN /= exhaustionFactorY;
            }
        }
        System.out.println(pokePowerN);
        System.out.println(targetPokedCnt);
    }
}
