package models;

import dao.CustomerDao;
import exception.CustomerIdNotValidException;
import service.TextFileService;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank implements Serializable {
    public static final long serialVersionUID = 1L;
    public String bankId;
    public String bankName;

    public Bank(String bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }
    public void showInformationCustomers() {
        if (CustomerDao.listCustomer().size() == 0) {
            System.out.println("Không có khách hàng nào");
        }
        CustomerDao.listCustomer().forEach(customer -> System.out.println(customer.showInformationAccount()));
    }
    public void showInformationCustomer(String customerId) {
        CustomerDao.listCustomer().forEach(customer -> {
            if (customer.getCustomerId().equals(customerId)) {
                System.out.println(customer.showInformationAccount());
            }
        });
    }
    public void showInformationTransactionAccount(String customerId) {
        CustomerDao.listCustomer().forEach(customer -> {
            if (customer.getCustomerId().equals(customerId)) {
                System.out.println(customer.showInformationTransactionAccount());
            }
        });
    }
    public void addCustomer(String fileName) {
        TextFileService textFileService = new TextFileService();
        ArrayList<Customer> customers = CustomerDao.listCustomer();
        String path = FileSystems.getDefault().getPath("src").toAbsolutePath().toString();
        HashMap<String, String> hashMap = textFileService.readFil(path + "\\" + fileName);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String customerId = entry.getKey();
            String name = entry.getValue();
            try {
                if (validateCustomerId(customerId)) {
                    if (isCustomerExisted(customerId)) {
                        System.out.println("Khách hàng có mã id " + customerId + " đã tồn tại");
                    } else {
                        System.out.println("Đã thêm khách hàng có mã id " + customerId + " vào danh sách");
                        customers.add(new Customer(customerId, name));
                        CustomerDao.save(customers);
                    }
                } else {
                    throw new CustomerIdNotValidException("Khách hàng có mã id " + customerId + " không hợp lệ");
                }
            } catch (CustomerIdNotValidException exception) {
                System.out.println(exception.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void addSavingsAccount(String customerId, SavingAccount savingAccounts) {
        CustomerDao.listCustomer().forEach(customer -> {
            if (customer.getCustomerId().equals(customerId)) {
                customer.addSavingsAccount(savingAccounts);
            }
        });
    }
    public boolean validateCustomerId(String customerId) {
        String regex = "^\\d{12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customerId);
        return matcher.matches();
    }


    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : CustomerDao.listCustomer()) {
            if (customer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }
    public Customer getCustomerByAccountNumber(String accountNumber) {
        for (Customer customer : CustomerDao.listCustomer()) {
            if (customer.getAccountByAccountNumber(accountNumber) != null) {
                return customer;
            }
        }
        return null;
    }
    public void transferMoney(SavingAccount savingAccountReceive, String customerID, String accountNumber, double amount) {
        CustomerDao.listCustomer().forEach(customer -> {
            if (customer.getCustomerId().equals(customerID)) {
                try {
                    customer.transferMoneyAccount(savingAccountReceive, accountNumber, amount);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void withdrawMoney(String customerID, String accountNumber, double amount) throws IOException {
        CustomerDao.listCustomer().forEach(customer -> {
            if (customer.getCustomerId().equals(customerID)) {
                try {
                    customer.withdrawMoneyAccount(accountNumber, amount);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public boolean checkAccountBalance(String balance) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(balance);
        return matcher.matches();
    }
    public boolean checkAccountNumber(String accountNumber) {
        String regex = "^\\d{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(accountNumber);
        return matcher.matches();
    }
    public boolean validateBalance(String balance) {
        return Double.parseDouble(balance) >= 50000.0;
    }
}
