package assignment3;

public class Manufactured extends Product {
    public String brand; // 제조사

    public Manufactured(String name, int price, String brand, int quantity) {
        super(name, price, quantity);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand;
    }
}
