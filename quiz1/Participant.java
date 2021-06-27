package quiz1;

import java.util.Random;

public class Participant {
    private String name;
    private Card card;
    private int point;

    public Participant(String name) {
        Random rand = new Random();
        int cardSymbol = rand.nextInt(4);
        int cardNumber = rand.nextInt(13) + 1;

        this.name = name;
        this.card = new Card(cardSymbol, cardNumber);
        this.point = 0;
    }

    public void addPoint(int point) {
        this.point += point;
    }

    public void changeCard() {
        Random rand = new Random();
        int cardSymbol = rand.nextInt(4);
        int cardNumber = rand.nextInt(13) + 1;

        this.card = new Card(cardSymbol, cardNumber);
    }

    public String toString() {
        return name + " has " + card.toString() + "(point: " + point + ")";
    }

    public Card getCard() {
        return new Card(card);
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
