package _04_HospitalDatabase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "_04_visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    @Column(columnDefinition = "text")
    private String comments;

    @ManyToMany(mappedBy = "visitations")
    private Set<Patient> patients;

}
