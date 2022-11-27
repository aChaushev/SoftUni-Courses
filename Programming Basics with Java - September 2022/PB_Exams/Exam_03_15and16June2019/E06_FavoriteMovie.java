package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E06_FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();

        int counter = 0;
        int movieMaxPoints = 0;
        String movie = "";
        while (!movieName.equals("STOP")) {
            counter++;
            int currentMoviePoints = 0;
            for (int i = 0; i < movieName.length(); i++) {
                currentMoviePoints += movieName.charAt(i);
                if ('A' <= movieName.charAt(i) && movieName.charAt(i) <= 'Z') {
                    currentMoviePoints -= movieName.length();
                } else if ('a' <= movieName.charAt(i) && movieName.charAt(i) <= 'z') {
                    currentMoviePoints -= 2 * movieName.length();
                }
            }
            if (currentMoviePoints > movieMaxPoints) {
                movieMaxPoints = currentMoviePoints;
                movie = movieName;
            }

            if (counter == 7) {
                System.out.println("The limit is reached.");
                break;
            }
            movieName = scanner.nextLine();
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", movie, movieMaxPoints);
    }
}
