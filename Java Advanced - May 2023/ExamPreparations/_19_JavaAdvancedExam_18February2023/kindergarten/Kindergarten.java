package ExamPreparations._19_JavaAdvancedExam_18February2023.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName){
        return registry.removeIf(child -> child.getFirstName().equals(firstName));
    }

    public int getChildrenCount(){
        return registry.size();
    }

    public Child getChild(String firstName){
        return registry.stream()
                .filter(child -> child.getFirstName().equals(firstName))
                .findAny()
                .orElse(null);
    }

//    public void registryReport(){
//        System.out.printf("Registered children in %s:%n", name);
//        registry.stream().sorted((s1, s2) -> {
//            int sort = Integer.compare(s1.getAge(), s2.getAge());
//            if (sort == 0) {
//                sort = s1.getFirstName().compareTo(s2.getFirstName());
//            }
//            return sort;
//        }).forEach(child -> System.out.println(child.toString()));

        public String registryReport(){
            StringBuilder sb = new StringBuilder(String.format("Registered children in %s:%n", name));
            registry.stream().sorted(Comparator.comparingInt(Child::getAge)
                            .thenComparing(Child::getFirstName)
                            .thenComparing(Child::getLastName))
                    .forEach(child -> sb
                            .append("--")
                            .append(System.lineSeparator())
                            .append(child.toString())
                            .append(System.lineSeparator()));
            return sb.toString();
    }

}
