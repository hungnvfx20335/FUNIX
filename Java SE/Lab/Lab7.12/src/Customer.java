import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    public Customer(String name, double initialAmount) {
        this.setName(name);
        this.setTransactions(new ArrayList<Double>());
        addTransaction(initialAmount);
    }
    public void addTransaction(double transactionAmount) {
        this.getTransactions().add(transactionAmount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }
}
