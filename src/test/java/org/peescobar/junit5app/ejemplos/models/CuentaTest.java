package org.peescobar.junit5app.ejemplos.models;

import org.junit.jupiter.api.Test;
import org.peescobar.junit5app.ejemplos.exceptions.InsufficientMoneyException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    @Test
    void testNameAccoun(){
        Cuenta cuenta = new Cuenta("Pablo", new BigDecimal("1000.12345"));

        String realName = cuenta.getPersona();

        assertEquals("Pablo", cuenta.getPersona());
        assertTrue(realName.equals("Pablo"));
        assertNotNull(realName);
    }

    @Test
    void testAmountAccount(){
        Cuenta cuenta = new Cuenta("Pablo", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenceAccount() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        //assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);
    }

    @Test
    void testDebitAccount() {
        Cuenta cuenta = new Cuenta("Pablo Escobar ", new BigDecimal("1000.12345"));
        cuenta.debit(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditAccount() {
        Cuenta cuenta = new Cuenta("Pablo Escobar ", new BigDecimal("1000.12345"));
        cuenta.credit(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testInsufficientMoneyExceptionAccount() {
        Cuenta cuenta = new Cuenta("Pablo Escobar ", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(InsufficientMoneyException.class, ()->{
            cuenta.debit(new BigDecimal(1100));
        });
        String realException = exception.getMessage();
        String expectedException = "Insufficient money";
        assertEquals(realException, expectedException);
    }

    @Test
    void testTransferMoneyAccounts() {
        Cuenta cuentaUno = new Cuenta("John Doe", new BigDecimal("2500"));
        Cuenta cuentaDos = new Cuenta("Pablo Doe", new BigDecimal("1500.8989"));

        Bank bank = new Bank();
        bank.setName("Banco de Bogotá");

        bank.transferMoney(cuentaUno, cuentaDos, new BigDecimal("500"));
        assertEquals("2000", cuentaUno.getSaldo().toPlainString());
        assertEquals("2000.8989", cuentaDos.getSaldo().toPlainString());
    }
}