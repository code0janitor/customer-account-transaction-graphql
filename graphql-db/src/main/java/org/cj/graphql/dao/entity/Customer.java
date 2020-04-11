package org.cj.graphql.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "lang_pref", nullable = false)
    private String languagePreference;

    @Column(name = "type", nullable = false)
    private String customerType;

    @Column(name = "last_4_ssn", nullable = false)
    private String ssnLast4;

    @Column(name = "dob", nullable = false)
    private String dateOfBirth;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Account> accounts = new ArrayList<Account>();

    /*
       TODO :
        1. fix the error with @RequiredArgsConstructor
        2. remove this manual definition
   */
    public Customer(String firstName, String lastName, String languagePreference, String customerType, String ssnLast4, String dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.languagePreference = languagePreference;
        this.customerType = customerType;
        this.ssnLast4 = ssnLast4;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public void addAccount(Account entry) {
        accounts.add(entry);
        entry.setCustomer(this);
    }

    public void removeAccount(Account entry) {
        accounts.remove(entry);
        entry.setCustomer(null);
    }

    /*
     * This custom toString is needed to avoid problem comes from lombok and lazy loading
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", languagePreference='" + languagePreference + '\'' +
                ", customerType='" + customerType + '\'' +
                ", ssnLast4='" + ssnLast4 + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}