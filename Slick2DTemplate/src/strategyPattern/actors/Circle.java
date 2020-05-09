package strategyPattern.actors;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Circle implements IActor{
    private float x, y, speed;
    private int diameter;
    private Shape collisionShape;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(1920);
        this.y = random.nextInt(1080);
        this.speed = random.nextInt(40) + 10;
        this.diameter = random.nextInt(20) + 20;
        this.collisionShape = new org.newdawn.slick.geom.Circle(this.x,this.y, this.diameter/2);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y , this.diameter, this. diameter);
        graphics.setColor(Color.magenta);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.y += (float) delta / this.speed;
        if (this.y > 1080) {
            this.y = 0;
        }
    }
}
