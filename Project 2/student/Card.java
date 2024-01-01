package student;

/**
 * Represents a playing card.
 */
public class Card {

    /**
     * Rank of the card.
     */
    private final int rank;

    /**
     * Suit of the card.
     */
    private final int suit;

    /**
     * Constructs a Card with rank and suit.
     * If rank or suit is invalid then defaults to Ace of Spades.
     *
     * @param rank The card's rank.
     * @param suit The card's suit.
     */
    public Card(int rank, int suit) {
        if ((1 <= suit && suit <= 4) && (1 <= rank && rank <= 13)) {
            this.suit = suit;
            this.rank = rank;
        } else {
            System.out.println("Invalid Card");
            this.suit = 1;
            this.rank = 1;
        }
    }

    /**
     * Returns the rank of the card.
     *
     * @return The card's rank.
     */
    public int getRankNum() {
        return rank;
    }

    /**
     * Returns the card's rank.
     *
     * @return The card's rank.
     */
    public String getRankName() {
        String[] rankNames = {"","Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        return rankNames[rank];
    }

    /**
     * Returns the the card's suit.
     *
     * @return The card's suit name.
     */
    public String getSuitName() {
        String[] suitNames = {"","Spades", "Hearts", "Clubs", "Diamonds"};
        return suitNames[suit];
    }

    /**
     * Returns a string representation of the card.
     *
     * @return A string representing the card.
     */
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    /**
     * Checks if the current card is equal to other card.
     *
     * @param obj The object to compare with.
     * @return True if the cards are equal, if not then false.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        boolean equal = rank == other.rank && suit == other.suit;
        return equal;
    }
}
