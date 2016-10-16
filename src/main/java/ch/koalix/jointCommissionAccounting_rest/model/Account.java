package ch.koalix.jointCommissionAccounting_rest.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Component
@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "account_number")
    @NotNull
    private Integer accountNumber;

    @Column(name = "account_name")
    @NotNull
    private String accountName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
