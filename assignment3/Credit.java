package assignment3;

public class Credit implements Payable {
    private String bank; // 은행
    private int limit; // 사용한도
    private int amountUsed; // 현재 누적 사용 금액

    public Credit(String bank, int limit, int amountUsed) {
        this.bank = bank;
        this.limit = limit;
        this.amountUsed = amountUsed;
    }

    @Override
    public void pay(int amount) throws NotEnoughBalanceException {
        // 지불한 amount만큼 amountUsed를 증가시킴
        // limit에서 amountUsed를 뺀 금액이 최대 사용 가능 금액
        if (limit - amountUsed >= amount)
            amountUsed += amount;
        else {
            throw new NotEnoughBalanceException(amount - (limit - amountUsed));
        }
    }

    @Override
    public String toString() {
        return bank + ", " + "Amount used: " + amountUsed + " won" + " (Limit: " + limit + " won)";
    }

    public String getBank() {
        return bank;
    }
}
