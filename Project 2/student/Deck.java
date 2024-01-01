package student;

import java.util.*;

/**
 * The Deck class represents a deck of playing cards with methods for shuffling and drawing them.
 */
public class Deck {


    /**
     * Represents an array of cards.
     */
    private Card[] cards;

    /**
     * Represents the number of remaining cards.
     */
    private int cardsRemaining;

    /**
     * Represents the amount of cards drawn.
     */
    private int cardsDrawn;

    /**
     * Represents a random number used for shuffling.
     */
    private Random random;

    /**
     * Constructs a Deck object with standard deck and shuffles it.
     */
    public Deck() {
        cardsRemaining = 52;
        cards = new Card[52];
        cardsDrawn = 0;
        random = new Random();

        int cardIndex = 0;
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                cards[cardIndex++] = new Card(rank, suit);
            }
        }
        shuffle();
    }

    /**
     * Shuffles the cards.
     */
    public void shuffle() {
        for (int i = cards.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        cardsDrawn = 0;
        cardsRemaining = 52;
    }

    /**
     * Draws a card.
     *
     * @return The drawn card.
     */
    public Card draw() {
        if (cardsRemaining == 0) {
            shuffle();
        }
        Card drawnCard = cards[cardsDrawn++];
        cardsRemaining--;

        return drawnCard;
    }

    /**
     * Returns the number of cards remaining.
     *
     * @return The number of cards remaining.
     */
    public int cardsRemaining() {
        return cardsRemaining;
    }

    /**
     * Checks if empty.
     *
     * @return True if the deck is empty, else false.
     */
    public boolean isEmpty() {
        if (cardsRemaining == 0) {
            return true;
        } else {
            return false;
        }
    }
}
