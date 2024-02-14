package _14_DefiningClasses_Exercise._07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;


    public Person() {
        //company = null
        //car = null
        //parents = празен списък
        this.parents = new ArrayList<>();
        //children = празен списък
        this.children = new ArrayList<>();
        //pokemons = празен списък
        this.pokemons = new ArrayList<>();
    }

    public Person(String name, Company company, List<Pokemon> pokemons, List<Parent> parents, List<Child> children, Car car) {
        this.name = name;
        this.company = company;
        this.pokemons = pokemons;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company:").append(System.lineSeparator());
        if(company != null){
            sb.append(company).append(System.lineSeparator());;
        }
        sb.append("Car:").append(System.lineSeparator());
        if(car != null){
            sb.append(car).append(System.lineSeparator());;
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        for(Pokemon pokemon : pokemons){
            sb.append(pokemon).append(System.lineSeparator());
        }
        sb.append("Parents:").append(System.lineSeparator());
        for(Parent parent : parents){
            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for(Child child : children){
            sb.append(child).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
