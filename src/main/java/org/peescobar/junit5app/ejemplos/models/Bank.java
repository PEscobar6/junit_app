package org.peescobar.junit5app.ejemplos.models;

import java.math.BigDecimal;

public class Bank {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void transferMoney(Cuenta accountOrigin, Cuenta accountDestiny, BigDecimal amount){
        accountOrigin.debit(amount);
        accountDestiny.credit(amount);
    }

}
