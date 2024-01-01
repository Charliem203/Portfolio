package student;

public class Skill {
    /**
    * Constructs name.
    */
    private String name;
    /**
    * Constructs Stength.
    */
    private int strength;
    /**
    * Constructs usage limit.
    */
    private int usageLimit;
    /**
    * Constructs the amount of usages left.
    */
    private int usageLeft;
    /**
     * Constructs a Skill object with the specified parameters.
     *
     * @param name , The name of the skill.
     * @param strength , The strength of the skill.
     * @param usageLimit , The maximum number of times the skill can be used.
     */
    public Skill(String name, int strength, int usageLimit) {
        this.name = name;
        this.strength = strength;
        this.usageLimit = usageLimit;
        this.usageLeft = usageLimit;
    }

    /**
     * @return The name of the skill.
     * returns name
     */
    public String getName() {
        return name;
    }

    /**
     * Refreshes the number of usages left and sets it back to the usage limit.
     */
    public void refresh() {
        usageLeft = usageLimit;
    }

    /**
     * @return the strength of the skill.
     * returns strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @return The usage limit of the skill.
     * returns the usage limit of the skill
     */
    public int getUsageLimit() {
        return usageLimit;
    }

    /**
     * @return The number of usages left.
     * returns the number of usages left
     */
    public int getUsageLeft() {
        return usageLeft;
    }

    /**
     * Uses the skill on a CodeMonster. If there are usages left, it applies the skill's changes.
     *
     * @param me , The CodeMonster using the skill.
     * @param foe , The CodeMonster on which the skill is used.
     */
    public void useSkill(CodeMonster me, CodeMonster foe) {
        if (usageLeft > 0) {
            usageLeft--;
            applyChanges(me, foe);
        }
    }

    /**
     * Applies the changes of the skill to the specified CodeMonster, causing damage to the foe.
     *
     * @param me , The CodeMonster using the skill.
     * @param foe , The CodeMonster on which the skill is used.
     */
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        int damage = getStrength();
        foe.adjustHealth(-damage);
    }

    /**
     * Returns a string representation of the Skill object, including its name, usages left, and usage limit.
     *
     * @return A string representation of the skill.
     */
    @Override
    public String toString() {
        return name + " " + usageLeft + "/" + usageLimit;
    }
}
