package service;

import models.SavingAccount;

public interface ReportService {
    void withdrawalReceipt(double amount);
    void transferReceipt(SavingAccount receiveAccount, double amount);
}
