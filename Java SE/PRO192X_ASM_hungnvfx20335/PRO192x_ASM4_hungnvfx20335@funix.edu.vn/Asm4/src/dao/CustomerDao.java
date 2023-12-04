package dao;

import models.Customer;
import service.BinaryFileService;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class CustomerDao implements Serializable {
    public static final long serialVersionUID = 1L;
    private static final String path = FileSystems.getDefault().getPath("src\\store\\customers.dat").toAbsolutePath().toString();
    public static void save(ArrayList<Customer> customers) throws IOException {
        BinaryFileService.writeFile(path, customers);
    }
    public static ArrayList<Customer> listCustomer() {
        return BinaryFileService.readFile(path);
    }
}
