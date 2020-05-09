package strategyPattern.actors;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import strategyPattern.movements.IMoveStrategy;
import strategyPattern.movements.LeftMoveStrategy;

import java.util.Random;

public class Ellipse implements IActor {
    private IMoveStrategy moveStrategy;


    public Ellipse(IMoveStrategy moveStrategy) {
        Random random = new Random();
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void render(Graphics graphics) {
        //graphics.drawOval(this.leftMoveStrategy.getX(), this.leftMoveStrategy.getY(), 50, 5);
        graphics.fillOval(this.moveStrategy.getX(), this.moveStrategy.getY(), 50, 5);
        graphics.setColor(Color.lightGray);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.moveStrategy.update(delta);
    }
}
