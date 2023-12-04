package service;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class TextFileService {
    private static final String COMMA_DELIMITER = ",";
    public HashMap<String, String> readFil(String fileName) {
        HashMap<String, String> objects = new HashMap<>();
        try (FileInputStream file = new FileInputStream(fileName)){
            Scanner input = new Scanner(file);
            input.useDelimiter(COMMA_DELIMITER);
            while (input.hasNextLine()) {
                String customerId = input.next();
                input.skip(input.delimiter());
                String name = input.nextLine();
                objects.put(customerId, name);
            }
        } catch (EOFException e) {
            return new HashMap<>();
        }
        catch (FileNotFoundException e) {
            System.out.println("Tệp không tồn tại");
        } catch (IOException io) {
            System.out.println("IO Exception " + io.getMessage());
        }
        return objects;
    }
}
