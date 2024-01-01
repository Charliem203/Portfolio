package student;
/**
 * The Hand class represents a player's hand of cards with methods for managing and interacting with the hand.
 */
public class Hand {

    /**
     * Represents an array of cards in the hand.
     */
    private Card[] cards;

    /**
     * Represents the deck from which cards are drawn.
     */
    private Deck deck;

    /**
     * Constructs a Hand object with a specified deck and size, drawing an initial hand of cards.
     *
     * @param deck The deck from which cards are drawn.
     * @param size The size of the hand.
     */
    public Hand(Deck deck, int size) {
        this.deck = deck;
        this.cards = new Card[size];
        drawHand();
    }

    /**
     * Gets the size of the hand.
     *
     * @return The number of cards in the hand.
     */
    public int getSize() {
        return cards.length;
    }

    /**
     * Gets the card at the specified index in the hand.
     *
     * @param i The index of the card to retrieve.
     * @return The card at the specified index, or the first card if the index is out of bounds.
     */
    public Card get(int i) {
        if (i < 0 || i >= cards.length) {
            System.out.println("Error: Index out of bounds. Returning the first card.");
            return cards[0];
        }
        return cards[i];
    }

    /**
     * Removes a specified card from the hand and replaces it with a new card drawn from the deck.
     *
     * @param card The card to be removed from the hand.
     * @return True if the card was successfully removed, false otherwise.
     */
    public boolean remove(Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null && cards[i].equals(card)) {
                cards[i] = deck.draw();
                return true;
            }
        }
        return false;
    }

    /**
     * Draws an initial hand of cards from the deck.
     */
    private void drawHand() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.draw();
        }
    }
}


