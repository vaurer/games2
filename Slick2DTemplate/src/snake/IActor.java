package snake;

import at.va.fightInTheSky.flyingObjects.Bullet;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public interface IActor {

    public void render(Graphics graphics) throws SlickException;

    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException;
}
