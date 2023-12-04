package repository;

import models.SavingAccount;

import java.io.IOException;

public interface TransferMoney {
    boolean transfer(SavingAccount receiveAccount, double amount) throws IOException;
}
