package ExamPreparations._20_JavaAdvancedRetakeExam_12April2023.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {

    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (data.size() < capacity) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return data.removeIf(cloth -> cloth.getColor().equals(color));
    }

    public Cloth getSmallestCloth() {
        return data.stream()
                .min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color) {
        return data.stream().filter(cloth -> cloth.getColor().equals(color))
                .findAny()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(type + " magazine contains:");
        data.forEach(cloth ->
                sb.append(System.lineSeparator())
                        .append(cloth.toString()));
        return sb.toString();
    }

}
