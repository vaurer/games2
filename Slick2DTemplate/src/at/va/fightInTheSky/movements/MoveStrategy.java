package at.va.fightInTheSky.movements;

import java.util.Random;

public class MoveStrategy {
    private float x, y, speed;

    public MoveStrategy(float x, float y, float speed) {
        Random random = new Random();
        this.x = random.nextInt(7);
        this.y = random.nextInt(7);
        this.speed = random.nextInt(7);
    }

    public void update(int delta) {
        Random random = new Random();
        int rand = new Random().nextInt((4 - 2) + 1) + 2;
        int rand2 = new Random().nextInt((4 - 2) + 1) + 2;
        this.x += rand;
        this.y += rand2;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
