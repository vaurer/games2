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
    private List<ICollisionActor> actorList;
    private Shape collisionShape;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.actorList = new ArrayList<>();
        this.collisionShape = new Rectangle(0, 0, 20, 20);;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x, this.y, 20, 20);
        graphics.setColor(Color.magenta);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
    }

    public void update(GameContainer gameContainer) throws SlickException, InterruptedException {
        this.x = x;
        this.y = y;
        this.collisionShape.setCenterX(this.x);
        this.collisionShape.setCenterY(this.y);
        for (IActor actor : actorList) {
            if (this.collisionShape.intersects(actor.getCollisionShape())) {

            }
        }

    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    @Override
    public void addEnemyCollisionPartner() {

    }
}
