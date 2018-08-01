public class Knight {

    private int id;
    private Knight enemy;
    private int life = 100;

    public Knight(int id) {
        this.id = id;
        this.enemy = this;
    }

    public Knight(int id, Knight enemy) {
        this.id = id;
        this.enemy = enemy;
    }

    public int getId() {
        return id;
    }

    public void takeHit(int hit) {
            this.life -= hit;
        }

    public boolean isDead() {
        return this.life < 1;
    }

    public void setEnemy(Knight enemy) {
        this.enemy = enemy;
    }

    public Knight getEnemy() {
        return this.enemy;
    }

}
