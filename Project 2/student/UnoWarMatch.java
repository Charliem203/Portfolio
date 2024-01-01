package student;

/**
 * Represents a Uno War match between two players.
 */
public class UnoWarMatch {

    /**
     * The first player.
     */
    private AI ai1;

    /**
     * The second player.
     */
    private AI ai2;

    /**
     * Constructs an Uno match with twoplayers.
     *
     * @param ai1 The first player.
     * @param ai2 The second player.
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * Plays a game of Uno War two players.
     *
     * @return True if the first player wins, else false.
     */
    public boolean playGame() {
        int roundsToWin = 10;
        int ai1Wins = 0;
        int ai2Wins = 0;
        int round = 0;
        Deck deck = new Deck();
        Hand ai1Hand = new Hand(deck, 5);
        Hand ai2Hand = new Hand(deck, 5);
        CardPile cardPile = new CardPile(deck.draw());

            while (ai1Wins < roundsToWin && ai2Wins < roundsToWin) {

                while (ai1.getPlay(ai1Hand, cardPile) != null || ai2.getPlay(ai2Hand, cardPile) != null) {
                    if (round != 0) {
                        cardPile.play(deck.draw());
                    } else {
                        round++;
                    }
                    Card ai1Play = ai1.getPlay(ai1Hand, cardPile);
                    if (ai1Play == null) {
                        ai2Wins++;
                        break;
                    }
                    ai1Hand.remove(ai1Play);
                    cardPile.play(ai1Play);
                    Card ai2Play = ai2.getPlay(ai2Hand, cardPile);
                    if (ai2Play == null) {
                        ai1Wins++;
                        break;
                    }
                    ai2Hand.remove(ai2Play);
                    cardPile.play(ai2Play);
                }
            }
        return ai1Wins >= ai2Wins;
    }

    /**
     * Finds the winning percentage of the first player over a number of games.
     *
     * @param nTrials The number of trials to run.
     * @return The winning percentage of the first player.
     */
    public double winRate(int nTrials) {
        int ai1Wins = 0;

        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                ai1Wins++;
            }
        }

        return (double) ai1Wins / nTrials;
    }
}
