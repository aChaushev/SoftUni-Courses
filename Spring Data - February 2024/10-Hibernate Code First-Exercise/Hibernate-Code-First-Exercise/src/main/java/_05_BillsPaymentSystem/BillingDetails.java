package _05_BillsPaymentSystem;


import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails {

    @Id
    @Column(unique = true)
    private String number;

    @ManyToOne
    private User owner;

}
