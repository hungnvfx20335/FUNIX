import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileService<Company> fileService = new FileService<>();
        String path = FileSystems.getDefault().getPath("company.dat").toAbsolutePath().toString();
        // Đọc file
        List<Company> companyList = fileService.readFile(path);
        // Print file
        System.out.println("List company in file:");
        fileService.printList(companyList);
        Company company = new Company("Shoppe", "admin@shoppe.com", "0123456789",
                "5 Science Park Drive, Shopee Building", "118265", "Singapore", new Date(1995,03, 23));

        companyList.add(company);
        // Ghi file
        fileService.writeFile(path, companyList);
        companyList = fileService.readFile(path);
        System.out.println("List company in file:");
        fileService.printList(companyList);
    }
}