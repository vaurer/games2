package snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Point implements ICollisionActor {
    private float x, y, speed;
    private Shape collisionShape;
    private List<ICollisionActor> iCollisionActors;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x, this.y, 10, 10);
        this.iCollisionActors = new ArrayList<ICollisionActor>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillOval(this.x, this.y, 20, 20);
        graphics.setColor(Color.magenta);
        graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.collisionShape.setCenterX(this.x + 10);
        this.collisionShape.setCenterY(this.y + 10);
        for (ICollisionActor iCollisionActor : iCollisionActors){
            if (this.collisionShape.intersects(iCollisionActor.getCollisionShape())){
                setNewPosition();
                System.out.println("new position");
            }
        }
    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void addHeadToTheList(ICollisionActor iCollisionActor) {
        this.iCollisionActors.add(iCollisionActor);
        System.out.println("added to " + this.iCollisionActors.add(iCollisionActor));
    }

    public void setNewPosition() {
        Random random = new Random();
        int tempX = random.nextInt(30);
        int tempY = random.nextInt(30);
        int tempXFinal = tempX * 20;
        int tempYFinal = tempY * 20;
        System.out.println(tempXFinal);
        System.out.println(tempYFinal);
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
