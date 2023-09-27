package _18_List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10_SoftUniCoursePlanning_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> courseList = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        List<String> command = Arrays.stream(scanner.nextLine().split(":"))
                .collect(Collectors.toList());
        while (!command.contains("course start")) {
            if (command.contains("Add")) {
                String lessonToAdd = command.get(1);
                if (!courseList.contains(lessonToAdd)) {
                    courseList.add(lessonToAdd);
                }

            } else if (command.contains("Insert")) {
                String lessonToInsert = command.get(1);
                int indexToInsert = Integer.parseInt(command.get(2));
                if (indexToInsert < 0 || indexToInsert > courseList.size() - 1) {
                    command = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
                    continue;
                }
                if (!courseList.contains(lessonToInsert)) {
                    courseList.add(indexToInsert, lessonToInsert);
                }

            } else if (command.contains("Remove")) {
                String lessonToRemove = command.get(1);
                if (courseList.contains(lessonToRemove)) {
                    int lessonIndex = getLessonIndex(courseList, lessonToRemove);
                    if (lessonIndex + 1 <= courseList.size() - 1) {
                        String lessonExercise = courseList.get(lessonIndex + 1);
                        if (lessonExercise.contains("Exercise")) {
                            courseList.remove(lessonIndex + 1);
                        }
                    }
                    courseList.remove(lessonToRemove);
                }

            } else if (command.contains("Swap")) {
                String firstLesson = command.get(1);
                String secondLesson = command.get(2);
                if (courseList.contains(firstLesson) && courseList.contains(secondLesson)) {
                    int firstIndex = getLessonIndex(courseList, firstLesson);
                    int secondIndex = getLessonIndex(courseList, secondLesson);

                    courseList.set(firstIndex, secondLesson);
                    courseList.set(secondIndex, firstLesson);
                    if (firstIndex + 1 <= courseList.size() - 1) {
                        String firstLessonExercise = courseList.get(firstIndex + 1);
                        if (firstLessonExercise.contains("Exercise")) {
                            courseList.remove(firstIndex + 1);
                            courseList.add(secondIndex + 1, firstLessonExercise);
                        }
                    }
                    if (secondIndex + 1 <= courseList.size() - 1) {
                        String secondLessonExercise = courseList.get(secondIndex + 1);
                        if (secondLessonExercise.contains("Exercise")) {
                            courseList.remove(secondIndex + 1);
                            courseList.add(firstIndex + 1, secondLessonExercise);

                        }
                    }
                }

            } else if (command.contains("Exercise")) {
                String lessonToAddExercise = command.get(1);
                if (courseList.contains(lessonToAddExercise)) {
                    int lessonIndex = getLessonIndex(courseList, lessonToAddExercise);
                    if (lessonIndex == courseList.size() - 1) {
                        courseList.add(lessonToAddExercise + "-Exercise");
                    } else {
                        courseList.add(lessonIndex + 1, lessonToAddExercise + "-Exercise");
                    }

                } else {
                    courseList.add(lessonToAddExercise);
                    courseList.add(lessonToAddExercise + "-Exercise");
                }

            }

            command = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        }
        for (int i = 0; i <= courseList.size() - 1; i++) {
            System.out.printf("%d.%s%n", i + 1, courseList.get(i));
        }
    }

    private static int getLessonIndex(List<String> courseList, String lesson) {
        int lessonIndex = 0;
        for (int i = 0; i <= courseList.size() - 1; i++) {
            if (courseList.get(i).equals(lesson)) {
                lessonIndex = i;
                break;
            }
        }
        return lessonIndex;
    }
}
