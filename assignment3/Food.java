package assignment3;

import java.time.LocalDateTime;

public class Food extends Product {
    private LocalDateTime expirationDateTime; // 유통기한

    public Food(String name, int price, LocalDateTime expTime, int quantity) {
        super(name, price, quantity);
        this.expirationDateTime = expTime;
    }

    public boolean isExpired(LocalDateTime present) {
        // 유통기한이 지났으면 true를 return
        if (present.isAfter(expirationDateTime))
            return true;
        else
            return false;
    }

    public LocalDateTime getExpirationDateTime() {
        return expirationDateTime;
    };

    public void setExpirationDateTime(LocalDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    @Override
    public String toString() {
        return super.toString() + ", Best before: " + expirationDateTime;
    }
}
