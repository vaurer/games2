package snake;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Player implements IActor {

    enum DIRECTION {UP, DOWN, LEFT, RIGHT, WAIT}

    private float x, y, l, speed;
    private List<IActor> actorList;
    private Shape collisionShape;
    private DIRECTION direction;
    private int timer;

    public Player() {
        this.l = 0;
        this.x = 0;
        this.y = 0;
        this.speed = 1f;
        this.actorList = actorList;
        this.collisionShape = new Rectangle(0, 0, 20, 20);
        this.actorList = new ArrayList<>();
        this.direction = DIRECTION.WAIT;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x, this.y, 20, 20);
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.direction = DIRECTION.UP;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.direction = DIRECTION.DOWN;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.direction = DIRECTION.LEFT;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.direction = DIRECTION.RIGHT;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
            this.direction = DIRECTION.WAIT;
        }

        this.collisionShape.setCenterX(this.x + 10);
        this.collisionShape.setCenterY(this.y + 10);

        this.timer += delta;
        int temp = 100;
        if (this.timer > temp) {
            timer=0;
            move();
//            if (this.direction == DIRECTION.RIGHT) {
//                this.x += 20;
//                timer=0;
//            } else if (this.direction == DIRECTION.LEFT) {
//                this.x -= 20;
//                timer=0;
//            } else if (this.direction == DIRECTION.UP) {
//                this.y -= 20;
//                timer=0;
//            } else if (this.direction == DIRECTION.DOWN) {
//                this.y += 20;
//                timer=0;
//            } else if (this.direction == DIRECTION.WAIT) {
//            }

        }
        for (
                IActor actor : actorList) {
            if (this.collisionShape.intersects(actor.getCollisionShape())) {
                collisionShape.setX(x);
            }
        }
        System.out.println(this.x);
    }

    public Shape getCollisionShape() {
        return collisionShape;
    }

    @Override
    public void addEnemyCollisionPartner() {

    }

    public void move() {
        switch (this.direction) {
            case UP:
                this.y -= 20;
                break;
            case DOWN:
                this.y += 20;
                break;
            case LEFT:
                this.x -= 20;
                break;
            case RIGHT:
                this.x += 20;
                break;
        }
    }

    public void addEnemyCollisionPartner(Point point) {
        this.actorList.add(point);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
