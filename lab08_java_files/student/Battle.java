package student;

public class Battle {
    public static void doOneTurn(CodeMonster one, CodeMonster two) {
        CodeMonster currentMonster;
        CodeMonster otherMonster;


        if (one.getNextTurnTime() < two.getNextTurnTime() || (one.getNextTurnTime() == two.getNextTurnTime())) {
            currentMonster = one;
            otherMonster = two;
        } else {
            currentMonster = two;
            otherMonster = one;
        }

        Skill skill = currentMonster.takeTurn();
        skill.useSkill(currentMonster, otherMonster);

  
        System.out.println(currentMonster.getName() + " used " + skill.getName() + " on " + otherMonster.getName() +
                " (" + otherMonster.getName() + " " + otherMonster.getHp() + "/" + otherMonster.getMaxHp() + ")");
    }

    public static CodeMonster battle(CodeMonster one, CodeMonster two) {

        one.prepForBattle();
        two.prepForBattle();


        System.out.println("Battle between " + one.getName() + " (" + one.getHp() + "/" + one.getMaxHp() + ") and " +
                two.getName() + " (" + two.getHp() + "/" + two.getMaxHp() + ")");

        while (one.isAlive() && two.isAlive()) {

            doOneTurn(one, two);
        }

  
        CodeMonster winner = one.isAlive() ? one : two;

        System.out.println(winner.getName() + " is the winner!");

        return winner;
    }
}
