package snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Point implements ICollisionActor {
    private float x, y, speed;
    private Shape collisionShape;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x, this.y, 20, 20);
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillOval(this.x, this.y, 20, 20);
        graphics.setColor(Color.magenta);
        graphics.draw(this.collisionShape);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.collisionShape.setCenterX(this.x+10);
        this.collisionShape.setCenterY(this.y+10);
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
