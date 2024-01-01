package student;

public class FastSkill extends Skill {
    public FastSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    @Override
    // Applies the damage from the skill and then refunds the time to the "me" monster
    public void applyChanges(CodeMonster me, CodeMonster foe) {

        int damage = getStrength();
        foe.adjustHealth(-damage);


        me.setNextTurnTime(me.getNextTurnTime() - me.getSpeedScore());
    }
}
