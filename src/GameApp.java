import java.util.concurrent.ThreadLocalRandom;

public class GameApp {

    public static void main(String[] args) {
        Knight attacker = initializeKnights(6);

        if (attacker == null) {
            System.out.println("No knights showed up");
        }

        while (attacker.getEnemy() != attacker) {

            Knight enemy = attacker.getEnemy();
            int hitPower = calculateHit();

            enemy.takeHit(hitPower);

            System.out.println("K" + attacker.getId() + " hits with " + hitPower + " points to K" + enemy.getId());

            if (enemy.isDead()) {
                attacker.setEnemy(enemy.getEnemy());

                System.out.println("K" + enemy.getId() + " dies");
            }

            attacker = attacker.getEnemy();
        }

        System.out.println("K" + attacker.getId() + " wins");
    }

    private static Knight initializeKnights(int qty) {
        if (qty < 1) {
            return null;
        }

        Knight newKnight, knight;
        Knight firstKnight = knight = new Knight(1);
        for (int i = 2; i <= qty; i++) {
            newKnight = new Knight(i, firstKnight);
            knight.setEnemy(newKnight);

            knight = newKnight;
        }

        return firstKnight;
    }


    public static int calculateHit() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

}
