package snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Point implements IActor {
    private float x, y, speed;
    private List<IActor> actorList;
    private Shape collisionShape;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.actorList = new ArrayList<>();
        this.collisionShape = collisionShape;
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
        this.collisionShape.setCenterX(this.x + 10);
        this.collisionShape.setCenterY(this.y + 10);
        for (IActor actor : actorList) {
            if (this.collisionShape.intersects(actor.getCollisionShape())) {

            }
        }

    }

    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void addEnemyCollisionPartner() {
    }


    public void addCollisionPartner(Player player) {
        this.actorList.add(player);
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

    public List<IActor> getActorList() {
        return actorList;
    }

    public void setActorList(List<IActor> actorList) {
        this.actorList = actorList;
    }

    public void setCollisionShape(Shape collisionShape) {
        this.collisionShape = collisionShape;
    }
}
