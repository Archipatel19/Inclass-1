package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/*
*@modifier : Archi Patel;
*student number : 991706059;
*/

class Card {
    private final int value;
    private final String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value == card.value && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.value;
        hash = 17 * hash + Objects.hashCode(this.suit);
        return hash;
    }
}

public class CardTrick {

    public static void main(String[] args) {
        List<Card> magicHand = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card c = createRandomCard();
            magicHand.add(c);
        }

        Card luckCard = new Card(2, "clubs");
        magicHand.add(luckCard);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a card value: ");
        int userValue = scanner.nextInt();
        System.out.print("Pick a card suit (spades, hearts, diamonds, clubs): ");
        String userSuit = scanner.next().toLowerCase();

        Card userCard = new Card(userValue, userSuit);

        boolean cardFound = magicHand.contains(userCard);

        if (cardFound) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    private static Card createRandomCard() {
        int randomValue = (int) (Math.random() * 13) + 1; 
        String[] suits = {"spades", "hearts", "diamonds", "clubs"};
        String randomSuit = suits[(int) (Math.random() * 4)]; 
        return new Card(randomValue, randomSuit);
    }
}
