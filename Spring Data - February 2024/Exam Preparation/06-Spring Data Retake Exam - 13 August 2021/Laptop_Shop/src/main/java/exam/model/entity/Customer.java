package exam.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private  String firstName;

    @Column(name = "last_name", nullable = false)
    private  String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(name = "registered_on",nullable = false)
    private LocalDate registeredOn;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
