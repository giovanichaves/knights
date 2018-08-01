import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class GameApp {

    public static void main(String[] args) {
        LinkedList<Knight> knights = initializeKnights(6);

        Knight attacker = knights.getFirst();
        while (attacker.getEnemy() != attacker) {

            Knight enemy = attacker.getEnemy();
            int hitForce = calculateHit();

            enemy.takeHit(hitForce);

            System.out.println("K" + attacker.getId() + " hits with " + hitForce + " points to K" + enemy.getId());

            if (enemy.isDead()) {
                attacker.setEnemy(enemy.getEnemy());

                System.out.println("K" + enemy.getId() + " dies");
                knights.remove(enemy);
            }

            attacker = attacker.getEnemy();
        }

        System.out.println("K" + knights.getFirst().getId() + " wins");
    }

    private static LinkedList<Knight> initializeKnights(int qty) {
        LinkedList<Knight> knights = new LinkedList<>();

        Knight knight = new Knight(1);
        for (int i = 1; i <= qty; i++) {
            Knight nextKnight = new Knight(i+1);
            knight.setEnemy(nextKnight);

            knights.add(knight);

            knight = nextKnight;
        }
        knights.getLast().setEnemy(knights.getFirst());

        return knights;
    }


    public static int calculateHit() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

}
