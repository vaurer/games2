package at.va.fightInTheSky.flyingObjects;

import at.va.fightInTheSky.actors.CollisionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JetPlayer implements CollisionActor {
    private Image planePlayerImage;
    private float x, y, speed;
    private Shape collisionShape;
    private List<CollisionActor> collisionActors;
    private boolean isGameNotOver = true;

    private int lives = 3;

    public JetPlayer() throws SlickException {
        this.planePlayerImage = planePlayerImage;
        Image temp = new Image("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\at\\va\\fightInTheSky\\files\\jetup.png");
        this.planePlayerImage = temp.getScaledCopy(100, 100);
        this.x = 960;
        this.y = 540;
        this.speed = 5;
        this.collisionShape = new Circle(this.x + 50, this.y + 50, 40);
        this.collisionActors = new ArrayList<>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        planePlayerImage.draw(this.x, this.y);
        //graphics.draw(this.playerCollisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y--;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y++;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
        }

        this.collisionShape.setCenterX(this.x + 50);
        this.collisionShape.setCenterY(this.y + 50);

        for (CollisionActor collisionActor : collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getCollisionShape())) {
                System.out.println("Player collision" + collisionActor);
                int  temp = collisionActors.indexOf(collisionActor);
                System.out.println(temp);
               // collisionActors.remove(temp);
               //collisionActors.remove(collisionActor);
                lives--;
                this.x = 990;
                this.y = 540;
                if (lives == 0) {
                    isGameNotOver = false;
//                    System.out.println("GAME OVER");
//                    TimeUnit.SECONDS.sleep(5);
//                    System.exit(0);
                }
            }
        }
    }

    public void addCollisionPartners(CollisionActor collisionActor) {
        this.collisionActors.add(collisionActor);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getLives() {
        return lives;
    }

    public boolean isGameNotOver() {
        return isGameNotOver;
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }

    @Override
    public void addEnemyCollisionPartner(Bullet bullet) {
    }
}
