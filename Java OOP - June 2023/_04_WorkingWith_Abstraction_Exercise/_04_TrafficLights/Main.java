package _04_WorkingWith_Abstraction_Exercise._04_TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split("\\s+");
        int iterations = Integer.parseInt(scanner.nextLine());

//        List<TrafficLight> trafficLightsList = new ArrayList<>();
//
//        for (String signal : signals) {
//            Colors color = Colors.valueOf(signal);
//            TrafficLight trafficLight = new TrafficLight(color);
//            trafficLightsList.add(trafficLight);
//        }

//        List<TrafficLight> trafficLightsList = Arrays.stream(signals)
//                .map(e -> Colors.valueOf(e))
//                .map(e -> {
//                    TrafficLight trafficLight = new TrafficLight(e);
//                    return trafficLight;
//                }).collect(Collectors.toList());

        List<TrafficLight> trafficLightsList = Arrays.stream(signals)
                .map(Color::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());

        for (int i = 0; i < iterations; i++) {
            for (TrafficLight trafficLight : trafficLightsList) {
                //changeColor
                trafficLight.changeColor();
                //print
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }


    }
}
