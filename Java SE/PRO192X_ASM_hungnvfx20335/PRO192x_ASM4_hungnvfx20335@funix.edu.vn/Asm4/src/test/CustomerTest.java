package test;

import models.Customer;
import models.SavingAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getTotalAccountBalance() {
        Customer customer = new Customer("030095001610", "Nguyen Van Hung");
        customer.addSavingsAccount(new SavingAccount("030095001610", "123456", 10000000.0));
        customer.addSavingsAccount(new SavingAccount("030095001610", "123457", 20000000.0));
        double balance = customer.getTotalAccountBalance();
        assertEquals(30000000, balance);
    }

    @Test
    void isPremiumAccount() {
        Customer customer = new Customer("030095001610", "Nguyen Van Hung");
        customer.addSavingsAccount(new SavingAccount("030095001610", "123456", 10000000.0));
        assertEquals( "   Premium   ",customer.isPremiumAccount());
    }
}