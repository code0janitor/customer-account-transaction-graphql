package org.cj.graphql.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Account")
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;

    @Column(name = "name_on_card", nullable = false)
    private String nameOnCard;

    @Column(name = "last_4_card", nullable = false)
    private String cardLast4;

    @Column(name = "iss_date", nullable = false)
    private String issueDate;

    @Column(name = "exp_date", nullable = false)
    private String expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    /*
        TODO :
         1. fix the error with @RequiredArgsConstructor
         2. remove this manual definition
    */
    public Account(String nameOnCard, String cardLast4, String issueDate, String expiryDate) {
        this.expiryDate = expiryDate;
        this.issueDate = issueDate;
        this.cardLast4 = cardLast4;
        this.nameOnCard = nameOnCard;
    }

    /*
     * This custom toString is needed to avoid problem comes from lombok and lazy loading
     */
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", cardLast4='" + cardLast4 + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", customer=" + customer +
                '}';
    }
}
