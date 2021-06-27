package assignment3;

public class Product {
    private String name; // 제품명
    private int price; // 제품의 가격
    private int quantity; // 제품의 수량

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Product anotherProduct) {
        this.name = new String(anotherProduct.name);
        this.price = anotherProduct.price;
        this.quantity = anotherProduct.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;

        Product temp = (Product) obj;
        return this.name.equals(temp.name) && this.price == temp.price && this.quantity == temp.quantity;
    }

    @Override
    public String toString() {
        return "(Quantity: " + quantity + ") " + name + ", " + price + " won";
    }

    public String getName() {
        return new String(name);
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
