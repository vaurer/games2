package strategyPattern.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import strategyPattern.movements.IMoveStrategy;

public abstract class AbstractMovableActor implements ICollisionActor {
    protected IMoveStrategy moveStrategy;

    public AbstractMovableActor(IMoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        this.moveStrategy.update(delta);
    }
}
