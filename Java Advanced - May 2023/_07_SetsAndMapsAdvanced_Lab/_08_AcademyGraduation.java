package _07_SetsAndMapsAdvanced_Lab;

import java.util.*;

public class _08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> gradesByStudents = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            String[] gradesString = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[gradesString.length];

            for (int i = 0; i < grades.length; i++) {
                grades[i] = Double.parseDouble(gradesString[i]);
            }

            gradesByStudents.put(name, grades);
        }

        for (String studentsName : gradesByStudents.keySet()) {
            Double[] grades = gradesByStudents.get(studentsName);

            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            System.out.printf("%s is graduated with %f\n", studentsName, sum / grades.length);

        }


    }
}
