package Assignment2;

public class ArrayFullException extends Exception {
    // Schedule list를 초과해서 schedule을 생성하려고 할 때
    public ArrayFullException() {
        super("array is full");
    }

    public ArrayFullException(String message) {
        super(message);
    }
}
