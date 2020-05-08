package at.va.fightInTheSky.flyingObjects;

import at.va.fightInTheSky.actors.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class UFO implements CollisionActor {
    private Shape collisionShape;
    private Image ufoImage;
    private float x, y, speed;

    public UFO() throws SlickException {
        Random random = new Random();
        Image temp = new Image("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\at\\va\\fightInTheSky\\files\\ufo.png");
        this.ufoImage = temp.getFlippedCopy(false, false);
        this.ufoImage = temp.getScaledCopy(100, 100);
        this.collisionShape = collisionShape;
        this.x = random.nextInt(1800)+100;
        this.y = random.nextInt(900)+100;
        this.speed = random.nextInt(5)+1;
        this.collisionShape = new Circle(this.x,this.y,35);
    }


    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    @Override
    public void addEnemyCollisionPartner(Bullet bullet) {

    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        ufoImage.draw(this.x, this.y);
        //graphics.draw(this.collisionShape);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        Random random = new Random();
        this.y += (float) delta / this.speed * random.nextInt(3);
        this.x += (float) delta / this.speed * random.nextInt(5);
        if (this.y > 1080) {
            this.y = 0;
        }
        if (this.x > 1980) {
            this.x = 0;
        }
        this.collisionShape.setCenterX(this.x + 50);
        this.collisionShape.setCenterY(this.y + 50);
    }
}
