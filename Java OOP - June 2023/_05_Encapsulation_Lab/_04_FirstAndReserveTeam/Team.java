package _05_Encapsulation_Lab._04_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam() {
        // ако искаме да избегнем и сортирането
        List<Person> otherList = new ArrayList<>();
        otherList.addAll(firstTeam);
        //забраняваме модефициране на листа
        return Collections.unmodifiableList(otherList);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }
}
