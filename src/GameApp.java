import java.util.Collections;
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

        if (qty < 1) {
            return knights;
        }

        Knight newKnight;
        Knight knight = new Knight(1);
        knights.add(knight);
        for (int i = 1; i < qty; i++) {
            newKnight = new Knight(i+1, knights.getFirst());
            knight.setEnemy(newKnight);

            knights.add(newKnight);

            knight = newKnight;
        }

        return knights;
    }


    public static int calculateHit() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

}
