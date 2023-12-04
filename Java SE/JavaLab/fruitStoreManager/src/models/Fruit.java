package models;

public class Fruit {
    private String fruitCode;
    private String fruitName;
    private String fruitPrice;
    private String fruitQuantity;
    private String fruitOrigin;
    public Fruit(String fruitCode, String fruitName, String fruitPrice, String fruitQuantity, String fruitOrigin) {
        this.setFruitCode(fruitCode);
        this.setFruitName(fruitName);
        this.setFruitPrice(fruitPrice);
        this.setFruitQuantity(fruitQuantity);
        this.setFruitOrigin(fruitOrigin);
    }

    public String getFruitCode() {
        return fruitCode;
    }

    public void setFruitCode(String fruitCode) {
        this.fruitCode = fruitCode;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(String fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public String getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(String fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public String getFruitOrigin() {
        return fruitOrigin;
    }

    public void setFruitOrigin(String fruitOrigin) {
        this.fruitOrigin = fruitOrigin;
    }
    public String toString() {
        return String.format("%-15s%-20s%-20s%-20s%-20s", getFruitCode(), getFruitName(), getFruitPrice(), getFruitQuantity(), getFruitOrigin());
    }
}
