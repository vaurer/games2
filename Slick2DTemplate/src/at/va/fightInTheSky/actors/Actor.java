package at.va.fightInTheSky.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Actor {
    public void render(Graphics graphics) throws SlickException;

    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException;

}
