import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService <T extends Company>{
    public FileService() {
    }
    public void printList(List<T> list) {
        for (T company : list) {
            System.out.println(company.toString());
        }
    }
    public List<T> readFile(String fileName) {
        List<T> objects = new ArrayList<>();
        try(ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (true) {
                try {
                    T object = (T) file.readObject();
                    objects.add(object);
                } catch(EOFException e) {
                    System.out.println("Kết thúc của đọc file");
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
        return objects;
    }
    public void writeFile(String fileName, List<T> list) {
        try (ObjectOutputStream file = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (T object : list) {
                file.writeObject(object);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}
