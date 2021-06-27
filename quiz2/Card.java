package quiz2;

public class Card implements Comparable<Card> {
    private int symbol; // Card의 무늬
    private int number; // Card의 숫자(1~13)

    public Card(int symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public Card(Card aCard) {
        this.symbol = aCard.symbol;
        this.number = aCard.number;
    }

    public int compareTo(Card o) {

        if (this.number > o.number) {
            return 1;
        } else if (this.number < o.number) {
            return -1;
        } else {
            if (this.symbol > o.symbol) {
                return 1;
            } else if (this.symbol < o.symbol) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public boolean equals(Card anotherCard) {
        if (anotherCard == null) {
            return false;
        }
        if (getClass() != anotherCard.getClass()) {
            return false;
        }
        return this.symbol == anotherCard.symbol && this.number == anotherCard.number;
    }

    public String toString() {
        String cardSymbol = "";

        if (this.symbol == 0) {
            cardSymbol = "Clubs";
        } else if (this.symbol == 1) {
            cardSymbol = "Diamonds";
        } else if (this.symbol == 2) {
            cardSymbol = "Hearts";
        } else if (this.symbol == 3) {
            cardSymbol = "Spades";
        }

        return cardSymbol + ", " + this.number;
    }

    public int getNumber() {
        return number;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }
}
