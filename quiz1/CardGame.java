package quiz1;

import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.next();

        Participant participant = new Participant(name);
        Participant dealer = new Participant("Dealer");

        System.out.println("Player Name: " + name);
        System.out.println("-----------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(dealer);
            System.out.println(participant);

            int result = Card.compareCard(dealer.getCard(), participant.getCard());
            if (result == 1) {
                participant.addPoint(1);
            }
            participant.setCard(dealer.getCard());
            dealer.changeCard();
            System.out.println("-----------------------");
        }
        System.out.print(participant.getName() + ", " + participant.getPoint() + " points");
    }
}
