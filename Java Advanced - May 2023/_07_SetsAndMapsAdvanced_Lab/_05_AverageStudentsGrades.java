package _07_SetsAndMapsAdvanced_Lab;

import java.util.*;

public class _05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsRecordMap = new TreeMap<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            String student = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);

            studentsRecordMap.putIfAbsent(student, new ArrayList<>());

            List<Double> gradesList = studentsRecordMap.get(student);

            gradesList.add(grade);

        }
        for (String student : studentsRecordMap.keySet()) {
            List<Double> gradesList = studentsRecordMap.get(student);

            System.out.print(student + " -> ");

            double sum = 0;
            for (double grade : gradesList) {

                sum += grade;

                System.out.printf("%.2f ", grade);
            }

            System.out.printf("(avg: %.2f)\n", sum / gradesList.size());

        }
    }
}
