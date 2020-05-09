package strategyPattern.actors;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import strategyPattern.movements.IMoveStrategy;

public class Rectangle implements IActor {
    private IMoveStrategy moveStrategy;

    public Rectangle(IMoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.moveStrategy.getX(), this.moveStrategy.getY(), 10, 10);
        graphics.setColor(Color.yellow);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        moveStrategy.update(delta);
    }
}
