package student;

/**
 * The BiggestCardAI class represents a player that selects the biggest playable card.
 */
public class BiggestCardAI extends AI {

    /**
     * Retrieves the biggest playable card from the hand.
     *
     * @param hand      The player's hand of cards.
     * @param cardPile  The card pile to check for playable cards.
     * @return          The biggest playable card from the hand, or null if none is found.
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card biggest = hand.get(0);
        for (int i = 0; i < hand.getSize() - 1; i++) {
            if (cardPile.canPlay(hand.get(i))) {
                if (hand.get(i).getRankNum() > biggest.getRankNum()) {
                    biggest = hand.get(i);
                }
            }
        }
        return biggest;
    }

    /**
     * Returns a string representation of the AI.
     *
     * @return A string representation of the AI.
     */
    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
