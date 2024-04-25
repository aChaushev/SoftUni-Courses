package ExamPreparations._09_JavaAdvancedExam_26June2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01_OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stackTasks = new ArrayDeque<>();
//        int[] taskValues = Arrays.stream(scanner.nextLine().split(",\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        for (int element : taskValues) {
//            stackTasks.push(element);
//        }
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(stackTasks::push);

//        Deque<Integer> queueThreads = new ArrayDeque<>();
//        Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .forEach(queueThreads::offer);
        Deque<Integer> queueThreads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int valueToKill = Integer.parseInt(scanner.nextLine());

        int currentTask = 0;
        int currentThread = 0;

        while (stackTasks.size() != 0 && queueThreads.size() != 0) {
//            или
//            while (currentTask != valueToKill){
//
//            }

            currentTask = stackTasks.peek();
            currentThread = queueThreads.peek();
            if(currentTask == valueToKill){
                break;
            }
            if(currentThread >= currentTask){
                stackTasks.pop();
                queueThreads.poll();
            } else {
                queueThreads.poll();
            }
        }

        System.out.printf("Thread with value %d killed task %d\n",currentThread,currentTask);
//        for (Integer element : queueThreads) {
//            System.out.print(element + " ");
//        }

        queueThreads.forEach(e -> System.out.printf("%d ",e));


//        String leftThreads = queueThreads.stream()
//                .map(String::valueOf)
//                .collect(Collectors.joining(" "));
//        System.out.println(leftThreads);

    }
}
