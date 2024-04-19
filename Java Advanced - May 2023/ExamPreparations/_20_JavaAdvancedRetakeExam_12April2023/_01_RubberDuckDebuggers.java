package ExamPreparations._20_JavaAdvancedRetakeExam_12April2023;

import java.util.*;

public class _01_RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> timeQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(timeQueue::offer);

        Deque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

        //Darth Vader Ducky	0 - 60
        //Thor Ducky	61 – 120
        //Big Blue Rubber Ducky	121 - 180
        //Small Yellow Rubber Ducky	181 - 240

        Map<String, Integer> rubberDuckiesTaken = new LinkedHashMap<>();
        rubberDuckiesTaken.put("Darth Vader Ducky", 0);
        rubberDuckiesTaken.put("Thor Ducky", 0);
        rubberDuckiesTaken.put("Big Blue Rubber Ducky", 0);
        rubberDuckiesTaken.put("Small Yellow Rubber Ducky", 0);


        while (!timeQueue.isEmpty() && !tasksStack.isEmpty()) {

            int firstTime = timeQueue.poll();
            int lastTask = tasksStack.pop();
            int multiplied = firstTime * lastTask;

            if (multiplied <= 60) {
                rubberDuckiesTaken.put("Darth Vader Ducky", rubberDuckiesTaken.get("Darth Vader Ducky") + 1);

            } else if (multiplied <= 120) {
                rubberDuckiesTaken.put("Thor Ducky", rubberDuckiesTaken.get("Thor Ducky") + 1);

            } else if (multiplied <= 180) {
                rubberDuckiesTaken.put("Big Blue Rubber Ducky", rubberDuckiesTaken.get("Big Blue Rubber Ducky") + 1);

            } else if (multiplied <= 240) {
                rubberDuckiesTaken.put("Small Yellow Rubber Ducky", rubberDuckiesTaken.get("Small Yellow Rubber Ducky") + 1);

            } else {
                tasksStack.push(lastTask - 2);
                timeQueue.offer(firstTime);
            }

        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        rubberDuckiesTaken.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));

    }
}
