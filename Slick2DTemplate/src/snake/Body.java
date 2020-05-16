package snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class Body implements ISnake, ICollisionActor{
    private float x, y;
    private Shape collisionShape;
    private DIRECTION direction;

    public Body() {
        this.x = 0;
        this.y = 0;
        this.collisionShape = new Rectangle(this.x, this.y, 15, 15);
        this.direction = DIRECTION.WAIT;
    }
    public Body(float x, float y, DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x, this.y, 15, 15);
        this.direction = direction;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillOval(this.x,this.y, 20,20);
        graphics.setColor(Color.black);
        graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.collisionShape.setCenterX(this.x);
        this.collisionShape.setCenterY(this.y);
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

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public DIRECTION getDirection() {
        return direction;
    }

}
