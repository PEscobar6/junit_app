package org.peescobar.junit5app.ejemplos.models;

import org.peescobar.junit5app.ejemplos.exceptions.InsufficientMoneyException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal saldo;
    private Bank bank;

    public Cuenta(String persona, BigDecimal saldo) {
        this.persona = persona;
        this.saldo = saldo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void debit(BigDecimal amount){
        BigDecimal newAmount = this.saldo.subtract(amount);
        if (newAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new InsufficientMoneyException("Insufficient money");
        }else{
            this.saldo = newAmount; 
        }
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void credit(BigDecimal amount){
        this.saldo = this.saldo.add(amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta) obj;
        if (this.persona == null || this.saldo == null){
            return false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }
}
