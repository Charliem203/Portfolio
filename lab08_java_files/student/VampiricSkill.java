package student;

public class VampiricSkill extends Skill {
    public VampiricSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    @Override
    // Applies damage to foe Monster and returns it to me monster as health
    public void applyChanges(CodeMonster me, CodeMonster foe) {

        int damage = getStrength();
        foe.adjustHealth(-damage);


        me.adjustHealth(damage);
    }
}
