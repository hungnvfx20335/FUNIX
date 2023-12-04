package test;

import models.SavingAccount;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {

    @Test
    void transfer() throws IOException {
        SavingAccount savingAccount = new SavingAccount("030095001610", "123456", 10000000);
        boolean balance = savingAccount.transfer(new SavingAccount("030095001610", "123457", 1000000),6000000);
        assertTrue(balance);
    }

    @Test
    void withdraw() throws IOException {
        SavingAccount savingAccount = new SavingAccount( "030095001610", "123456", 10000000);
        assertTrue(savingAccount.withdraw(6000000));
    }

    @Test
    void isAccepted() throws IOException {
        SavingAccount savingAccount = new SavingAccount("030095001610", "123456", 10000000);
        assertTrue(savingAccount.isAccepted(6000000));
    }
}