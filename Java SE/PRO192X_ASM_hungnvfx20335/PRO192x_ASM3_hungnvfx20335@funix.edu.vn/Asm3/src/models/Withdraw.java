package models;

public interface Withdraw {
    // Nghiệp vụ rút tiền
    double withdraw(double amount);
    // Xác định xem giá trị có thỏa mãn điều kiện rút tiền không
    boolean isAccepted(double amount);

}
