package quiz2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortCard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int num;

        System.out.print("Enter the length of array: ");
        try {
            num = keyboard.nextInt();
            if (num <= 0) {
                throw new BadNumberException(num);
            }
        } catch (BadNumberException e) {
            System.out.println(e.getMessage() + ", " + e.getBadNumber() + " cannot be used");
            num = keyboard.nextInt();
        }
        System.out.println("---------------------------");

        Card[] cards = new Card[num];

        for (int i = 0; i < cards.length; i++) {
            Random rand = new Random();
            cards[i] = new Card(rand.nextInt(4), rand.nextInt(13) + 1);
            System.out.println(cards[i]);
        }
        System.out.println("---------------------------");

        Arrays.sort(cards);

        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println("---------------------------");

        ArrayList<Card> cardList = new ArrayList<Card>();
        for (Card card : cards) {
            cardList.add(card);
        }

        int increaseNum;
        System.out.print("Enter the number to increase: ");
        try {
            increaseNum = keyboard.nextInt();
            if (increaseNum <= 0) {
                throw new BadNumberException(increaseNum);
            }
        } catch (BadNumberException e) {
            System.out.println(e.getMessage() + ", " + e.getBadNumber() + " cannot be used");
            increaseNum = keyboard.nextInt();
        }
        System.out.println("---------------------------");

        for (int i = 0; i < increaseNum; i++) {
            Random rand = new Random();
            Card newCard = new Card(rand.nextInt(4), rand.nextInt(13) + 1);
            int pos = 0;

            for (int j = 0; j < cardList.size(); j++) {
                if (cardList.get(j).compareTo(newCard) != 1) {
                    pos = j;
                    break;
                }
                if (j == cardList.size() - 1) {
                    pos = j+1;
                }
            }

            cardList.add(pos, newCard);
        }

        for (Card card : cardList) {
            System.out.println(card);
        }
    }
}
