package _04_HospitalDatabase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "_04_patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(columnDefinition = "blob")
    private String picture;

    @Column(name = "have_insurance")
    private boolean haveInsurance;

    @ManyToMany
    @JoinTable(
            name = "_04_patients_medicaments",
            joinColumns = @JoinColumn(name = "patients_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicaments_id", referencedColumnName = "id")
    )
    private Set<Medicament> medicaments;

    @ManyToMany
    @JoinTable(
            name = "_04_patients_visitations",
            joinColumns = @JoinColumn(name = "patients_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "visitations_id", referencedColumnName = "id")
    )
    private Set<Visitation> visitations;

    @ManyToOne
    private Diagnose diagnose;


}
