package student;

/**
 * Represents a Uno War tournament between different AIs.
 */
public class Tournament {

    public static void main(String[] args) {
        int nTrials = 1000;

        AI randomCardAI = new AI();
        AI smallestCardAI = new SmallestCardAI();
        AI biggestCardAI = new BiggestCardAI();

        printWinRate(randomCardAI, randomCardAI, nTrials);
        printWinRate(randomCardAI, smallestCardAI, nTrials);
        printWinRate(randomCardAI, biggestCardAI, nTrials);

        printWinRate(smallestCardAI, randomCardAI, nTrials);
        printWinRate(smallestCardAI, smallestCardAI, nTrials);
        printWinRate(smallestCardAI, biggestCardAI, nTrials);

        printWinRate(biggestCardAI, randomCardAI, nTrials);
        printWinRate(biggestCardAI, smallestCardAI, nTrials);
        printWinRate(biggestCardAI, biggestCardAI, nTrials);
    }

    private static void printWinRate(AI ai1, AI ai2, int nTrials) {
        double winRate = calculateWinRate(ai1, ai2, nTrials);
        String formattedWinRate = String.format("%.3f", winRate);
        System.out.println(ai1 + " vs. " + ai2 + " Win Rate: " + formattedWinRate);
    }

    private static double calculateWinRate(AI ai1, AI ai2, int nTrials) {
        UnoWarMatch match = new UnoWarMatch(ai1, ai2);
        return match.winRate(nTrials);
    }
}
