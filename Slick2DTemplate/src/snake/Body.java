package snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Body implements ICollisionActor{
    private float x, y;
    private Shape collisionShape;
    private List<Body> bodies;

    public Body() {
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x, this.y, 15, 15);
        this.bodies = new ArrayList<Body>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x, this.y, 20, 20);
        graphics.setColor(Color.yellow);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.x = x;
        this.y = y;
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
}
