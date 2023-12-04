package service;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;

public class BinaryFileService {
    public static <T> @NotNull ArrayList<T> readFile(String fileName) {
        ArrayList<T> objects = new ArrayList<>();
        try (ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
            boolean eof = false;
            while (!eof) {
                try {
                    T object = (T) file.readObject();
                    objects.add(object);
                }
                catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (EOFException e) {
            return new ArrayList<>();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception " + e.getMessage());
        } catch (IOException io) {
            System.out.println("IO Exception " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return objects;
    }

    public static <T> void writeFile(String fileName, ArrayList<T> objects) throws IOException {
        try (ObjectOutputStream file = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (T object : objects) {
                file.writeObject(object);
            }
        }
    }
}
