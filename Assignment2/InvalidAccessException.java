package Assignment2;

public class InvalidAccessException extends Exception {
    // 주어진 메뉴 번호의 범위 밖의 번호를 입력 받을 때
    // 이미 activity가 존재하는 시간에 추가할 때
    // 존재하지 않는 schedule 또는 activity를 선택할 때
    public InvalidAccessException() {
        super("invalid access");
    }

    public InvalidAccessException(String message) {
        super(message);
    }
}
