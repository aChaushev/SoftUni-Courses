package _05_BillsPaymentSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table
public class BankAccount extends BillingDetails {

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "SWIFT_code")
    private String swiftCode;

}

