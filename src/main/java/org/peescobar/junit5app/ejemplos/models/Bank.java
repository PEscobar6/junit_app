package org.peescobar.junit5app.ejemplos.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;

    private List<Cuenta> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cuenta> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Cuenta> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Cuenta account) {
        this.accounts.add(account);
        account.setBank(this);
    }

    public void transferMoney(Cuenta accountOrigin, Cuenta accountDestiny, BigDecimal amount){
        accountOrigin.debit(amount);
        accountDestiny.credit(amount);
    }

}
