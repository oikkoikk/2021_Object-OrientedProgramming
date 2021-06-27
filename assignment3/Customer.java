package assignment3;

import java.util.ArrayList;

public class Customer implements Observer {
    private String name; // 이름
    private ArrayList<Payable> wallet; // 소지한 Payable 목록
    private ArrayList<Product> shoppingCart; // 구매할 Product 목록
    private ArrayList<Product> waitingList; // 구매대기 신청한 목록

    public Customer(String name, ArrayList<Payable> wallet) {
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<Product>();
        this.waitingList = new ArrayList<Product>();
    }

    public void addToCart(int productIdx, int quantity) throws ExpiredException {
        Product product = Mart.getInstance().getSalesList().get(productIdx - 1);

        if (product.getClass() == Food.class) {
            // 유통기한이 지난 식품이라면 throw!
            Food temp = (Food) product;
            if (temp.isExpired(Mart.getTimeNow()))
                throw new ExpiredException();
        }
        if (product.getQuantity() < quantity) {
            // 재고가 부족한 경우
            // 구매대기 신청
            if (!Mart.getInstance().getObservers().contains(this))
                Mart.getInstance().addObserver(this);
            int diff = quantity - product.getQuantity();
            if (product.getQuantity() > 0) {
                // 카트에 넣고, 재고 감소
                this.shoppingCart.add(new Product(product.getName(), product.getPrice(), product.getQuantity()));
                System.out.println("Successfully added " + product.getQuantity() + " " + product.getName() + "in cart");
                product.setQuantity(0);
            }
            waitingList
                    .add(new Product(product.getName(), product.getPrice(), (quantity - diff == 0 ? quantity : diff)));

            System.out.print("Purchase waiting has been successfully done: ");
            System.out
                    .println("Name: " + product.getName() + ", Quantity: " + (quantity - diff == 0 ? quantity : diff));
            return;
        }
        // 정상적인 상태라면
        // 카트에 넣고, 재고 감소
        this.shoppingCart.add(new Product(product.getName(), product.getPrice(), quantity));
        System.out.println("Successfully added " + quantity + " " + product.getName());
        product.setQuantity(product.getQuantity() - quantity);
    }

    public void requestPay(int paymentIdx, int totalPrice) throws NotEnoughBalanceException {
        Payable payment = wallet.get(paymentIdx - 1);

        payment.pay(totalPrice);
        // 결제 성공시
        System.out.println("Payment Completed! (transaction number: " + Mart.transactionNum + ")");
    }

    public void clearCart() {
        this.shoppingCart = new ArrayList<Product>();
    }

    @Override
    public void update(InventoryManager generator) {
        int i = 0, j = 0;

        Loop: for (i = 0; i < waitingList.size(); i++) {
            for (j = 0; j < Mart.getInstance().getSalesList().size(); j++) {
                if (Mart.getInstance().getSalesList().get(j).getName().equals(waitingList.get(i).getName())) {
                    break Loop;
                }
            }
        }

        try {
            Product temp = new Product(waitingList.get(i));

            addToCart(j + 1, temp.getQuantity());
            waitingList.remove(temp);
        } catch (ExpiredException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;

        Customer temp = (Customer) obj;
        return this.name.equals(temp.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public ArrayList<Product> getWaitingList() {
        return waitingList;
    }

    public ArrayList<Payable> getWallet() {
        return wallet;
    }
}
