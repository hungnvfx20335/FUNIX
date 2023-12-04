package test;

import models.Bank;
import models.Customer;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class BankTest {

    @org.junit.jupiter.api.Test
    void isCustomerExisted() {
        Bank bank = new Bank("BANK001", "NGAN HANG TRUNG NGUYEN");
        bank.addCustomer("store\\customers.txt");
        assertTrue(bank.isCustomerExisted("000095001619"));
    }
}