package ExamPreparations._05_JavaAdvancedRetakeExam_19August2020.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {

    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
//        for (Pet pet : data) {
//            if (pet.getName().equals(name)) {
//                data.remove(pet);
//                return true;
//            }
//        }
//        return false;
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
//        for (Pet pet : data) {
//            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
//                return pet;
//            }
//        }
//        return null;
        return data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findAny()
                .orElse(null);
    }

    public Pet getOldestPet() {
        return data.stream()
                .max(Comparator.comparing(Pet::getAge))
                .get();
//        return Collections.max(data,(f, s) -> Integer.compare(f.getAge(),s.getAge()));
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");
        for (Pet pet : data) {
            sb.append(System.lineSeparator());
            sb.append(pet.getName())
                    .append(" ")
                    .append(pet.getOwner());
        }
        return sb.toString();
    }
}
