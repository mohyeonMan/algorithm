package questions.programmers;

public class 붕대감기 {

    public int execute() {

        // int[] bandage = { 5, 1, 5 }; // 시전시간, 초당 회복량, 추가 회복량;
        // int health = 30;
        // int[][] attacks = { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } }; // 공격하는 턴,
        // 데미지

        int[] bandage = { 1, 1, 1 }; // 시전시간, 초당 회복량, 추가 회복량;
        int health = 20;
        int[][] attacks = { { 1, 5 }, { 4, 1 } };

        int repeatation = attacks[attacks.length - 1][0];

        Hero hero = new Hero(health, bandage[0], bandage[1], bandage[2]);
        Monster monster = new Monster(attacks[0][0], attacks[0][1]);

        for (int i = 1; i <= repeatation; i++) {

            boolean isLastAttack = monster.attackCount + 1 > attacks.length - 1;

            int nextAttackTurn = !isLastAttack ? attacks[monster.attackCount + 1][0] : 0;
            int nextDamage = !isLastAttack ? attacks[monster.attackCount + 1][1] : 0;

            boolean monsterAttacked = monster.attack(hero, i, nextAttackTurn, nextDamage);
            if (!monsterAttacked) {
                hero.heal();
            }

            if (!hero.isAlive) {
                return -1;
            }

        }

        return hero.currentHp;

    }

    class Hero {
        int maxHp;
        int currentHp;
        int healTime = 0;
        int healAmount;
        int healTimeGoal;
        int healReward;
        boolean isAlive = true;

        public Hero(int maxHp, int healTimeGoal, int healAmount, int healReward) {
            this.maxHp = maxHp;
            this.currentHp = maxHp;
            this.healAmount = healAmount;
            this.healTimeGoal = healTimeGoal;
            this.healReward = healReward;
        }

        public void heal() {

            currentHp += healAmount;
            healTime++;

            if (healTime == healTimeGoal) {
                currentHp += healReward;
                healTime = 0;
            }

            if (currentHp > maxHp) {
                currentHp = maxHp;
            }
        }
    }

    class Monster {
        int attackCount = 0;
        int attackTurn;
        int damage;

        public Monster(int attackTurn, int damage) {
            this.attackTurn = attackTurn;
            this.damage = damage;
        }

        public boolean attack(Hero hero, int currentTurn, int nextAttackTurn, int nextDamage) {
            if (currentTurn == attackTurn) {

                hero.currentHp -= damage;
                attackCount++;
                hero.healTime = 0;

                if (hero.currentHp <= 0) {
                    hero.isAlive = false;
                }

                this.attackTurn = nextAttackTurn;
                this.damage = nextDamage;

                return true;
            }
            return false;

        }

    }

}
