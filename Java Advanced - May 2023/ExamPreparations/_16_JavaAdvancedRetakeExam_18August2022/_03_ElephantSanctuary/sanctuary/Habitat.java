package ExamPreparations._16_JavaAdvancedRetakeExam_18August2022._03_ElephantSanctuary.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream()
                .filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom))
                .findAny()
                .orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream()
                .max(Comparator.comparing(Elephant::getAge))
                .get();
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:");
        for (Elephant e : data) {
            sb.append(System.lineSeparator());
            sb.append(e.getName());
            sb.append(" came from: ");
            sb.append(e.getRetiredFrom());
        }
        return sb.toString();
    }
}
