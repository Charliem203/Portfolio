package student;

/**
 * Represents a deck of cards with methods for seeing playable actions and info about the deck.
 */
public class CardPile {

    /**
     * Represents the top card.
     */
    private Card top;

    /**
     * Represents the number of cards in the pile.
     */
    private int size;

    /**
     * Constructs a CardPile with the specific top card.
     *
     * @param top The initial top card.
     */
    public CardPile(Card top) {
        this.top = top;
        this.size = 1;
    }

    /**
     * Checks if a given card can be played based on current top card.
     *
     * @param card The card that needs to be checked.
     * @return True if can be played, false otherwise.
     */
    public boolean canPlay(Card card) {
            return card.getRankNum() >= top.getRankNum() || card.getSuitName().equals(top.getSuitName());

    }

    /**
     * Plays a card on the pile if possible.
     * Updates the top card and increments the size if successful.
     * Prints an error message if the card cannot be played.
     *
     * @param card The card to be played.
     */
    public void play(Card card) {
        if (card != null && canPlay(card)) {
            top = card;
            size++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * Returns the number of cards in the pile.
     *
     * @return The number of cards in the pile.
     */
    public int getNumCards() {
        return size;
    }

    /**
     * Returns the top card.
     *
     * @return The top card.
     */
    public Card getTopCard() {
        return top;
    }
}
