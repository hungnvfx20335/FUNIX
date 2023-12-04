public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Cong Thuong Viet Nam");

        bank.addBranch("Hai Ba Trung");
        bank.addCustomer("Hai Ba Trung", "Nguyen Van Hung", 30000.00);
        bank.addCustomer("Hai Ba Trung", "Nguyen Van Cuong", 40000.00);
        bank.addCustomer("Hai Ba Trung", "Nguyen Van Tung", 60000.00);
        bank.addCustomerTransaction("Hai Ba Trung", "Nguyen Van Hung", 40000.00);

        bank.listCustomer("Hai Ba Trung", false);
    }

}