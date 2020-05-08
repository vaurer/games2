package at.va.fightInTheSky.flyingObjects;

import at.va.fightInTheSky.actors.EnemyCollisionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Bullet implements EnemyCollisionActor {
    private float x, y, speed;
    private int diameter;
    private Shape collisionShape;
    private Sound sound;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Circle(this.x, this.y, 15);
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillOval(this.x, this.y, 5, 5);
        graphics.setColor(Color.red);
       //graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        sound = new Sound("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\at\\va\\fightInTheSky\\files\\restart.ogg");
        this.y = this.y - 2;
        this.collisionShape.setCenterY(this.y);
        this.collisionShape.setCenterX(this.x);
    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
