package assignment3;

public interface Payable {
    public void pay(int amount) throws NotEnoughBalanceException;
}
