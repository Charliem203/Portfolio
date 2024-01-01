package student;

/**
 * Represents a game score with a name, score, and information about the game mode.
 *
 * Written by: Charlie Madison, Nate Solomon
 */
public class GameScore implements Comparable<GameScore> {

    /**
     * The score of the game.
     */
    private double score;

    /**
     * The name of the player.
     */
    private String name;

    /**
     * Indicates whether the game was played in hard mode.
     */
    private boolean hardMode;

    /**
     * Creates a new GameScore with the specified name, score, and game mode.
     *
     * @param name     the name of the player
     * @param score    the score of the game
     * @param hardMode indicates whether the game was played in hard mode
     */
    public GameScore(String name, double score, boolean hardMode) {
        this.name = name;
        this.score = score;
        this.hardMode = hardMode;
    }

    /**
     * Gets the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the score of the game.
     *
     * @return the score of the game
     */
    public double getScore() {
        return score;
    }

    /**
     * Checks if the game was played in hard mode.
     *
     * @return true if the game was played in hard mode, false otherwise
     */
    public boolean isHardMode() {
        return hardMode;
    }

    /**
     * Returns a string representation of the GameScore.
     *
     * @return a string representation of the GameScore
     */
    @Override
    public String toString() {
        if (isHardMode() == true) {
            return name + " " + score + "*";
        } else {
            return name + " " + score;
        }
    }

    /**
     * Checks if this GameScore is equal to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GameScore other = (GameScore) o;

        return this.getScore() == other.getScore() && this.getName().equals(other.getName())
        && this.isHardMode() == other.isHardMode();
    }

    /**
     * Compares this GameScore to another GameScore.
     *
     * @param other the GameScore to compare with
     * @return a negative, zero, or a positive integer if this object is lesser, equal to, or greater than the specified object
     */
    public int compareTo(GameScore other) {
        if (this.isHardMode() == true && other.isHardMode() == false) {
            return 1;
        } else if (other.isHardMode() == true && this.isHardMode() == false) {
            return -1;
        } else if (this.getScore() > other.getScore()) {
            return 1;
        } else if (other.getScore() > this.getScore()) {
            return -1;
        } else {
            return 0;
        }
    }
}
