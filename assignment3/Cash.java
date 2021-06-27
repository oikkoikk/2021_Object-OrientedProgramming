package assignment3;

public class Cash implements Payable {
    private String currency; // 통화
    private int amount; // 금액

    public Cash(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public void pay(int amount) throws NotEnoughBalanceException {
        // 지불한 만큼의 amount를 감소시킴
        // 소지한 금액보다 초과해서 Cash를 사용할 수 없음
        if (this.amount >= amount)
            this.amount -= amount;
        else {
            throw new NotEnoughBalanceException(amount - this.amount);
        }
    }

    @Override
    public String toString() {
        return currency + ", " + amount + " won";
    }

    public String getCurrency() {
        return currency;
    }
}
