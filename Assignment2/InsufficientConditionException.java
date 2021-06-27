package Assignment2;

public class InsufficientConditionException extends Exception {
    //Activity에서 설정된 activity 참여 조건을 만족시키지 못할 때
    public InsufficientConditionException() {
        super("insufficient condition");
    }

    public InsufficientConditionException(String message) {
        super(message);
    }
}
