package _05_BillsPaymentSystem;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CreditCard extends BillingDetails {

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "exp_month", nullable = false)
    private Short expirationMonth;

    @Column(name = "exp_year", nullable = false)
    private Short expirationYear;
}
