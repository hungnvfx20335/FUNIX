package dao;

import models.Transaction;
import service.BinaryFileService;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class TransactionDao implements Serializable {
    public static final long serialVersionUID = 1L;
    private static final String path = FileSystems.getDefault().getPath("src\\store\\transactions.dat").toAbsolutePath().toString();
    public static void save(ArrayList<Transaction> transactions) throws IOException {
        BinaryFileService.writeFile(path, transactions);
    }
    public static ArrayList<Transaction> listTransaction() {
        return BinaryFileService.readFile(path);
    }
}
