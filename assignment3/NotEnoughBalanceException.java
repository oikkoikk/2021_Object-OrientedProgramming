package assignment3;

public class NotEnoughBalanceException extends Exception {
    private int difference;

    public NotEnoughBalanceException(int difference) {
        super(difference + " won is not enough");
        this.difference = difference;
    }

    public int getDifference() {
        return difference;
    }
}
