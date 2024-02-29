package _04_HospitalDatabase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "_04_diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(columnDefinition = "text")
    private String comments;

    @OneToMany(mappedBy = "diagnose")
    private Set<Patient> patients;
}
