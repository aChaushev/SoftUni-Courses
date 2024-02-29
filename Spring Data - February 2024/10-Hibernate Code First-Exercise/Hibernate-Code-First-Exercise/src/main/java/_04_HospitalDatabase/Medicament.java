package _04_HospitalDatabase;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "_04_medicaments ")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "medicaments")
    private Set<Patient> patients;


}
