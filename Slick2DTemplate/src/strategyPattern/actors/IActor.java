package strategyPattern.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface IActor {
    public void render(Graphics graphics);

    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException;
}
