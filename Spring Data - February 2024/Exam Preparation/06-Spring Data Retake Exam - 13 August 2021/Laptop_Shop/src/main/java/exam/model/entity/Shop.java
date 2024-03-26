package exam.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {

    @Column(nullable = false, unique = true)
    private  String name;

    @Column
    private BigDecimal income;

    @Column(nullable = false)
    private String address;

    @Column(name = "employee_count")
    private int employeeCount;

    @Column(name = "shop_area")
    private int shopArea;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    @OneToMany(targetEntity = Laptop.class, mappedBy = "shop")
    private Set<Laptop> laptops;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getShopArea() {
        return shopArea;
    }

    public void setShopArea(int shopArea) {
        this.shopArea = shopArea;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
