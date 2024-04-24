package ExamPreparations._12_JavaAdvancedRetakeExam_15December2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (fishInPool.size() < capacity) {
            if (fishInPool.stream().noneMatch(fish1 -> fish1.getName().equals(fish.getName()))) {
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public Fish findFish(String name) {
        return fishInPool.stream()
                .filter(fish -> fish.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Aquarium: " + name + " ^ Size: " + size);
        sb.append(System.lineSeparator());
        fishInPool.forEach(fish ->
                sb.append(fish.toString())
                        .append(System.lineSeparator()));
        return sb.toString();
    }


}
