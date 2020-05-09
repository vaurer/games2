package strategyPattern;

import org.newdawn.slick.*;
import strategyPattern.actors.Circle;
import strategyPattern.actors.Ellipse;
import strategyPattern.actors.IActor;
import strategyPattern.movements.IMoveStrategy;
import strategyPattern.movements.LeftMoveStrategy;
import strategyPattern.movements.RightMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    private List<IActor> actors;

    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        Random random = new Random();
        this.actors = new ArrayList<>();
        IMoveStrategy rms = new RightMoveStrategy(random.nextInt(1920), random.nextInt(1080), 5);
        IMoveStrategy rms2 = new RightMoveStrategy(random.nextInt(1920), random.nextInt(1080), 5);
        IMoveStrategy lms = new LeftMoveStrategy((1920), random.nextInt(1080), 5);
        IMoveStrategy lms2 = new LeftMoveStrategy((1920), random.nextInt(1080), 5);

        for (int i = 0; i < 5; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
        }
        Ellipse e1 = new Ellipse(lms);
        this.actors.add(e1);
        Ellipse e2 = new Ellipse(rms);
        this.actors.add(e2);
        Ellipse e3 = new Ellipse(lms2);
        this.actors.add(e3);
        Ellipse e4 = new Ellipse(rms2);
        this.actors.add(e4);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (IActor actor : actors) {
            try {
                actor.update(gameContainer, delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (IActor actor : actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer appGameContainer = new AppGameContainer(new ObjectsGame("Different games"));
        appGameContainer.setDisplayMode(1920, 1080, false);
        appGameContainer.start();
    }
}
