package strategyPattern.actors;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import strategyPattern.movements.IMoveStrategy;

public class Ellipse extends AbstractMovableActor {


    public Ellipse(IMoveStrategy moveStrategy) {
        super(moveStrategy);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.moveStrategy.getX(), this.moveStrategy.getY(), 50, 5);
        graphics.setColor(Color.red);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.moveStrategy.update(delta);
    }

    @Override
    public void getShape() {

    }
}
