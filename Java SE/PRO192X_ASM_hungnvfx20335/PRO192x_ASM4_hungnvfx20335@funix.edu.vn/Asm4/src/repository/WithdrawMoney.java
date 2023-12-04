package repository;

import java.io.IOException;

public interface WithdrawMoney {
    boolean withdraw(double amount) throws IOException;
    boolean isAccepted(double amount) throws IOException;
}
