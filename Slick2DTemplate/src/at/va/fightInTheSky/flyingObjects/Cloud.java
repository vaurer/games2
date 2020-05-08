package at.va.fightInTheSky.flyingObjects;

import at.va.fightInTheSky.actors.Weather;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class Cloud implements Weather {
    private Image cloudImage;
    private float x, y, speed;


    public Cloud() throws SlickException {
        Random random = new Random();
        this.cloudImage = cloudImage;
        Image temp = new Image("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\at\\va\\fightInTheSky\\files\\cloud.png");
        this.cloudImage = temp.getScaledCopy(100, 100);
        this.x = random.nextInt(2920)-3000;
        this.y = random.nextInt(1080);
        this.speed = 10;
    }
    @Override
    public void render(Graphics graphics) throws SlickException {
        cloudImage.draw(this.x, this.y);
    }
    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.y += (float) delta / this.speed;
        this.x +=(float) delta / this.speed;
        Random random =  new Random();
        if (this.y > 1080) {
            this.y = 0;
            this.x = random.nextInt(1880);
        }
    }
}
