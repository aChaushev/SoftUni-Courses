package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E06_TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        double maxWordPoints = 0;
        String mostPowerfulWord = "";
        while (!word.equals("End of words")) {
            int wordLength = word.length();
            double currentWordSum = 0;
            for (int i = 0; i < wordLength; i++) {
                currentWordSum += word.charAt(i);
            }
            char s1 = word.toLowerCase().charAt(0);
            if (s1 == 'a' || s1 == 'e' || s1 == 'i' || s1 == 'o' || s1 == 'u' || s1 == 'y') {
                currentWordSum *= wordLength;
            } else {
                currentWordSum = Math.floor(currentWordSum / wordLength);
            }

            if (currentWordSum > maxWordPoints) {
                maxWordPoints = currentWordSum;
                mostPowerfulWord = word;
            }
            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %.0f", mostPowerfulWord, maxWordPoints);
    }
}
