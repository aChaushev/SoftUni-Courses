package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E01_SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serialName = scanner.nextLine();
        int serialSeasons = Integer.parseInt(scanner.nextLine());
        int serialEpisodes = Integer.parseInt(scanner.nextLine());
        double episodeTime = Double.parseDouble(scanner.nextLine());

        double allEpisodesInSeason = episodeTime * 1.2 * serialEpisodes + 10;
        double totalTime = Math.floor(allEpisodesInSeason * serialSeasons);

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", serialName, totalTime);
    }
}
