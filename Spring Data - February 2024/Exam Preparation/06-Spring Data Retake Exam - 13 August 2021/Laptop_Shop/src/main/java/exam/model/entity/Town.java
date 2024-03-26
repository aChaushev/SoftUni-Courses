package exam.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(nullable = false, unique = true)
    private  String name;

    @Column
    private int population;

    @Column(name = "travel_guide", columnDefinition = "TEXT")
    private String 	travelGuide;

    @OneToMany(targetEntity = Shop.class, mappedBy = "town")
    private Set<Shop> shops;

    @OneToMany(targetEntity = Customer.class, mappedBy = "town")
    private Set<Customer> customers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
