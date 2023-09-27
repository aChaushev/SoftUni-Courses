package _18_List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10_SoftUniCoursePlanning_ {
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

                if (!courseList.contains(lessonToInsert)) {
                    if (indexToInsert >= 0 && indexToInsert <= courseList.size() - 1) {
                        courseList.add(indexToInsert, lessonToInsert);
                    }
                }

            } else if (command.contains("Remove")) {
                String lessonToRemove = command.get(1);
                String exerciseToRemove = lessonToRemove + "-Exercise";
                if (courseList.contains(lessonToRemove) && courseList.contains(exerciseToRemove)) {
                    courseList.remove(lessonToRemove);
                    courseList.remove(exerciseToRemove);
                }
                courseList.remove(lessonToRemove);

            } else if (command.contains("Swap")) {
                String firstLesson = command.get(1);
                String secondLesson = command.get(2);
                String firstExercise = firstLesson + "-Exercise";
                String secondExercise = secondLesson + "-Exercise";
                if (courseList.contains(firstLesson) && courseList.contains(secondLesson)) {
                    int firstIndex = courseList.indexOf(firstLesson);
                    int secondIndex = courseList.indexOf(secondLesson);

                    courseList.set(firstIndex, secondLesson);
                    courseList.set(secondIndex, firstLesson);
                    if (courseList.contains(firstExercise)) {
                        courseList.remove(firstExercise);
                        if (secondIndex + 1 <= courseList.size() - 1) {
                            courseList.add(secondIndex + 1, firstExercise);
                        } else {
                            courseList.add(firstExercise);
                        }
                    }
                    if (courseList.contains(secondExercise)) {
                        courseList.remove(secondExercise);
                        if (firstIndex + 1 <= courseList.size() - 1) {
                            courseList.add(firstIndex + 1, secondExercise);
                        } else {
                            courseList.add(secondExercise);
                        }
                    }
                }

            } else if (command.contains("Exercise")) {
                String lessonToAddExercise = command.get(1);
                String exerciseToAdd = lessonToAddExercise + "-Exercise";
                if (courseList.contains(lessonToAddExercise) && courseList.contains(exerciseToAdd)) {
                    command = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
                    continue;
                } else if (courseList.contains(lessonToAddExercise)) {
                    int lessonIndex = courseList.indexOf(lessonToAddExercise);

                    if (lessonIndex + 1 <= courseList.size() - 1) {
                        courseList.add(lessonIndex + 1, exerciseToAdd);
                    } else {
                        courseList.add(exerciseToAdd);
                    }

                } else {
                    courseList.add(lessonToAddExercise);
                    courseList.add(exerciseToAdd);
                }

            }

            command = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        }
        for (int i = 0; i <= courseList.size() - 1; i++) {
            System.out.printf("%d.%s%n", i + 1, courseList.get(i));
        }
    }
}

