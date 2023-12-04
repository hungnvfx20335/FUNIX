package models;

import java.io.Serializable;

public class DigitalBank extends Bank implements Serializable {
    public static final long serialVersionUID = 1L;
    public DigitalBank(String bankId, String bankName) {
        super(bankId, bankName);
    }
}
