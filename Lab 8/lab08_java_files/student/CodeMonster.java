package student;

public class CodeMonster {
    private String name;
    private int currentHp;
    private int maxHp;
    private Skill[] moves;
    private int moveIndex;
    private double speedScore;
    private double nextTurnTime;

    public CodeMonster(int maxHp, double speedScore, String name, Skill[] moves) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.name = name;
        this.moves = moves;
        this.moveIndex = 0;
        this.speedScore = speedScore;
        this.nextTurnTime = speedScore;
    }

    public double getNextTurnTime() {
        return nextTurnTime;
    }

    public int getHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Skill[] getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }

    public double getSpeedScore() {
        return speedScore;
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public void setNextTurnTime(double nextTurnTime) {
        this.nextTurnTime = nextTurnTime;
    }

    public String toString() {
        return name + " " + currentHp + "/" + maxHp;
    }

    public void adjustHealth(int amount) {
        currentHp += amount;
        if (currentHp > maxHp) {
            currentHp = maxHp;
        } else if (currentHp < 0) {
            currentHp = 0;
        }
    }
    // 
    public Skill takeTurn() {
        Skill skillToUse = moves[moveIndex];
        moveIndex = (moveIndex + 1) % moves.length;
        nextTurnTime += speedScore;
        return skillToUse;
    }
    // Sets health of monsters to max and resets Turn Time and moves
    public void prepForBattle() {
        currentHp = maxHp;
        nextTurnTime = speedScore;
        moveIndex = 0;
        for (int i = 0; i < moves.length; i++) 
        {
            moves[i].refresh();
        }
    }
}

