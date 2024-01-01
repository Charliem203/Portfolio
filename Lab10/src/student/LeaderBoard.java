package student;

/**
 * An object that tracks the top-N values of a larger collection.
 * This data structure stores N elements of any sortable type.
 * (NOTE -- while we initially envisioned this in relation to GameScores -- we're building this with generics
 * and interfaces so it can work with ANY sortable data type. This is a common way to build software
 * you use an example to determine a need -- but you design to be as flexible as possible.)
 *
 * @param <T> the type of data stored in this LeaderBoard object -- must be a sortable type with defines the compareTo method.
 */
public class LeaderBoard<T extends Comparable<T>> {

    /**
     * Do not change.
     */
    private final T[] scores;

    /**
     * Create a new leaderboard.
     *
     * @param size the size of the leaderboard
     * @param dflt the default value for each position in the leaderboard.
     */
    @SuppressWarnings("unchecked")
    public LeaderBoard(int size, T dflt) {
        // do not change.

        // we don't want to deal with small-size boards.
        if (size < 2) {
            size = 2;
        }
        // This line will always have a warning on it (if we hadn't suppressed that on line 17)
        // quite frankly it's a bit messy to begin with -- but it turns out generics and arrays don't play well together.
        // and this is generally understood to be the best we can do for making a generic array.
        scores = (T[]) new Comparable[size];

        for (int i = 0; i < size; i++) {
            scores[i] = dflt;
        }
    }

    /**
     * Gets the size of the leaderboard.
     *
     * @return the size of the leaderboard
     */
    public int getSize() {
        return scores.length;
    }

    /**
     * Gets the highest score in the leaderboard.
     *
     * @return the highest score
     */
    public T highScore() {
        return scores[0]; // replace me.
    }

    /**
     * Gets the lowest score in the leaderboard.
     *
     * @return the lowest score
     */
    public T lowScore() {
        return scores[scores.length - 1]; // replace me.
    }

    /**
     * Adds a new score to the leaderboard.
     *
     * @param newScore the new score to add
     */
    public void add(T newScore) {
        // If new score is less than the lowest score than it does not add to leaderboard and breaks with return.
        if (newScore.compareTo(lowScore()) <= 0) {
            return;
        }
        scores[scores.length - 1] = newScore;

        int index = scores.length - 1;

        while (index > 0 && newScore.compareTo(scores[index - 1]) > 0) {
            T temp = scores[index];
            scores[index] = scores[index - 1];
            scores[index - 1] = temp;

            // Move to the next position
            index--;
        }
    }

    /**
     * Returns a string representation of the LeaderBoard.
     *
     * @return a string representation of the LeaderBoard
     */
    @Override
    public String toString() {
        // do not change.
        StringBuilder retVal = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            retVal.append((i + 1)).append(". ").append(scores[i].toString()).append("\n");
        }
        return retVal.toString();
    }
}

