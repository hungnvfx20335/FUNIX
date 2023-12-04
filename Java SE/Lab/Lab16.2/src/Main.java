import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Đường dẫn thư mục gốc:");
        String path = FileSystems.getDefault().getPath("2022").toAbsolutePath().toString();
        System.out.println(path);
        HashMap<String, ArrayList<String>> folderMap = readFileToFolder(path);
        createFolderAndMoveFile(path, folderMap);
    }
    public static boolean checkFileNameValid(String fileName) {
        String regex = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])(.txt)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileName);
        return matcher.matches();
    }

    public static HashMap<String , ArrayList<String>> readFileToFolder(String nameFolder) {
        HashMap<String, ArrayList<String>> folderMap = new HashMap<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(nameFolder))) {
            for (Path path : stream) {
                System.out.println("Check item: " + path.getFileName());
                if(!Files.isDirectory(path)) {
                    String fileName = path.getFileName().toString();
                    if (checkFileNameValid(fileName)) {
                        System.out.println("File valid");
                        String newFolder = fileName.substring(0, fileName.lastIndexOf("-"));
                        ArrayList<String> listFileToFolder = new ArrayList<>();
                        if (folderMap.containsKey(newFolder)) {
                            listFileToFolder = folderMap.get(newFolder);
                        }
                        listFileToFolder.add(fileName);
                        folderMap.put(newFolder, listFileToFolder);
                    } else {
                        System.out.println("File " + path.getFileName() + " invalid will removed");
                        Files.delete(path);
                    }
                }
            }
        }
        catch (IOException exception) {
            System.out.println("IOException " + exception.getMessage());
        }
        return  folderMap;
    }

    public static void createFolderAndMoveFile(String rootFolder,HashMap<String, ArrayList<String>> folderMap) throws IOException {
        for (String newFolder : folderMap.keySet()) {
            Path newFolderPath = Paths.get(rootFolder, newFolder);
            if (!Files.exists(newFolderPath)) {
                Files.createDirectory(newFolderPath);
                for (String fileName : folderMap.get(newFolder)) {
                    Path oldFilePath = Paths.get(rootFolder, fileName);
                    Path newFilePath = newFolderPath.resolve(fileName);
                    Files.move(oldFilePath, newFilePath);
                    System.out.println("Move file: " + oldFilePath + "====>" + newFilePath);
                }
            } else {
                System.out.println("Directory already exists");
                for (String fileName : folderMap.get(newFolder)) {
                    Path oldFilePath = Paths.get(rootFolder, fileName);
                    Path newFilePath = newFolderPath.resolve(fileName);
                    Files.move(oldFilePath, newFilePath);
                    System.out.println("Move file: " + oldFilePath + "====>" + newFilePath);
                }
            }
        }
    }
}