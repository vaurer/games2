package snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class Snake implements ISnake{
    private float x, y;
    private DIRECTION direction;
    private Shape collisionShape;

    public Snake(float x, float y, DIRECTION direction, Shape collisionShape) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.collisionShape = collisionShape;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x, this.y, 20, 20);
        graphics.setColor(Color.black);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {

    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
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

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }
}
