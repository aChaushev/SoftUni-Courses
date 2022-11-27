package PB_Exams.Exam_02_6and7April2019;

import java.util.Scanner;

public class E05_MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moviesNum = Integer.parseInt(scanner.nextLine());
        double highestRating = Double.MIN_VALUE;
        double lowestRating = Double.MAX_VALUE;
        double totalRatingSum = 0;
        String movieMaxRating = "";
        String movieMinRating = "";
        for (int i = 1; i <= moviesNum; i++) {
            String movieTitle = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());
            if (highestRating < rating) {
                highestRating = rating;
                movieMaxRating = movieTitle;
            }
            if (lowestRating > rating) {
                lowestRating = rating;
                movieMinRating = movieTitle;
            }
            totalRatingSum += rating;
        }

        System.out.printf("%s is with highest rating: %.1f%n", movieMaxRating, highestRating);
        System.out.printf("%s is with lowest rating: %.1f%n", movieMinRating, lowestRating);
        System.out.printf("Average rating: %.1f%n", totalRatingSum / moviesNum);
    }
}
