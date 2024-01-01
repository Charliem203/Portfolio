package student;

/**
 * The AI class represents an AI player that plays a card from its hand.
 */
public class AI {

    /**
     * Finds a playable card from the AI's hand.
     *
     * @param hand      The AI's hand.
     * @param cardPile  The card pile to find playable cards.
     * @return          A playable card from the hand, or null if not found.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize() - 1; i++) {
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    /**
     * Returns a string representation of the AI.
     *
     * @return A string representation of the AI.
     */
    public String toString() {
        return "Random Card AI";
    }
}
