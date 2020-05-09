package strategyPattern.actors;

import org.newdawn.slick.Graphics;
import strategyPattern.movements.IMoveStrategy;

public class RectangleFilled extends AbstractMovableActor {
    public RectangleFilled(IMoveStrategy moveStrategy) {
        super(moveStrategy);
    }

    @Override
    public void getShape() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.moveStrategy.getX(), this.moveStrategy.getY(), 30, 30);
    }
}
