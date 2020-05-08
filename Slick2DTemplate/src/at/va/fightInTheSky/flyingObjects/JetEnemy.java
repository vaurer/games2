package at.va.fightInTheSky.flyingObjects;

import at.va.fightInTheSky.actors.CollisionActor;
import at.va.fightInTheSky.actors.EnemyCollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JetEnemy implements CollisionActor {
    private Image planeEnemyImage;
    private float x, y, speed;
    private Shape collisionShape;
    private List<EnemyCollisionActor> enemyCollisionActors;

    public JetEnemy() throws SlickException {
        Random random = new Random();
        this.planeEnemyImage = planeEnemyImage;
        Image temp = new Image("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\at\\va\\fightInTheSky\\files\\jet2.png");
        this.planeEnemyImage = temp.getScaledCopy(100, 100);
        this.x = random.nextInt(1920);
        this.y = 0;
        this.speed = random.nextInt(6) + 2;
        this.collisionShape = new Circle(this.x, this.y, 40);
        this.enemyCollisionActors = new ArrayList<>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        planeEnemyImage.draw(this.x, this.y);
        //graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        Random random = new Random();
        this.y += (float) delta / this.speed;
        if (this.y > 1080) {
            this.y = 0;
            this.x = random.nextInt(1800) + 100;
        }

        this.collisionShape.setCenterX(this.x + 50);
        this.collisionShape.setCenterY(this.y + 50);

        for (int i = 0; i < enemyCollisionActors.size(); i++) {
            if (this.collisionShape.intersects(enemyCollisionActors.get(i).getCollisionShape())) {
                System.out.println("Enemy colission");
            }
        }
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

    public void addEnemyCollisionPartner(Bullet bullet) {
        this.enemyCollisionActors.add(bullet);
    }
}
