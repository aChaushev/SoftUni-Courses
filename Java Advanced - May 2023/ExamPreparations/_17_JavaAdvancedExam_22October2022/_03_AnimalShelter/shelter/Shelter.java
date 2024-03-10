package ExamPreparations._17_JavaAdvancedExam_22October2022._03_AnimalShelter.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        setCapacity(capacity);
        this.data = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findAny()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream().max(Comparator.comparing(Animal::getAge)).get();
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The shelter has the following animals:");
        for (Animal animal : data) {
            sb.append(System.lineSeparator());
            sb.append(animal.getName())
                    .append(" ")
                    .append(animal.getCaretaker());
        }
        return sb.toString();
    }
}
