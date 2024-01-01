package student;

public class SmallestCardAI extends AI {

    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card smallest = hand.get(0);
        for (int i = 0; i < hand.getSize() - 1; i++) {
            if (cardPile.canPlay(hand.get(i))) {
                if (hand.get(i).getRankNum() < smallest.getRankNum() || smallest == null) {
                    smallest = hand.get(i);
                }
            }
        }
        return smallest;
    }

    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
