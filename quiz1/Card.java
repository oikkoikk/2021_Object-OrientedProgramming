package quiz1;

public class Card {
    private int symbol;
    private int number;

    public Card(int symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public Card(Card aCard) {
        this.symbol = aCard.symbol;
        this.number = aCard.number;
    }

    public boolean equals(Card anotherCard) {
        return this.symbol == anotherCard.symbol && this.number == anotherCard.number;
    }

    public String toString() {
        String symString = "";

        switch (symbol) {
        case 0:
            symString = "Clubs";
            break;
        case 1:
            symString = "Diamonds";
            break;
        case 2:
            symString = "Hearts";
            break;
        case 3:
            symString = "Spades";
            break;
        default:
            break;
        }
        return symString + ", " + this.number;
    }

    public static int compareCard(Card cardA, Card cardB) {
        if (cardA.number > cardB.number) {
            return -1;
        } else if (cardA.number < cardB.number) {
            return 1;
        } else {
            return 0;
        }
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
