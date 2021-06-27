package assignment3;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Mart extends InventoryManager {
    private ArrayList<Product> salesList; // 판매목록
    public static int transactionNum = 1000; // 마트의 transaction 번호
    private static LocalDateTime timeNow;
    private static Mart mart = new Mart();

    private Mart() {// NOTE: Singleton(Eager Initialization)
        super();
        this.salesList = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        if (product.getClass() == Food.class) {
            Food temp = (Food) product;
            this.salesList.add(temp);
        } else if (product.getClass() == Manufactured.class) {
            Manufactured temp = (Manufactured) product;
            this.salesList.add(temp);
        } else {
            return;
        }
    }

    public void addInventory(int productIdx, int quantity) {
        productIdx--; // 0부터 시작하므로

        salesList.get(productIdx).setQuantity(salesList.get(productIdx).getQuantity() + quantity);
        notifyObservers();
    }

    public static Mart getInstance() {
        return mart;
    }

    public ArrayList<Product> getSalesList() {
        return salesList;
    }

    public static LocalDateTime getTimeNow() {
        return timeNow;
    }

    public static void setTimeNow(LocalDateTime timeNow) {
        Mart.timeNow = timeNow;
    }

}
