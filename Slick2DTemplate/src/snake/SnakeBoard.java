package snake;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeBoard extends BasicGame {
    private List<IActor> actorList;
    private int width = 600;
    private int high = 600;

    public SnakeBoard(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorList = new ArrayList<>();
        createPlayer();
        createPoint();
        gameContainer.getGraphics().setBackground(new Color(0.4f, 0.5f, 0.9f));
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (IActor iActor : actorList) {
            try {
                iActor.update(gameContainer, delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (IActor iActor : actorList) {
            iActor.render(graphics);
        }
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer appGameContainer = new AppGameContainer(new SnakeBoard("Snake"));
        appGameContainer.setDisplayMode(600, 600, false);
        appGameContainer.start();

    }

    public void createPlayer() {
        Head head = new Head();
        this.actorList.add(head);
    }

    public void createPoint(){
        Random random = new Random();
            int tempX = random.nextInt(30);
            int tempY = random.nextInt(30);
            int tempXFinal = tempX*20;
            int tempYFinal = tempY*20;
            Point point = new Point(tempXFinal, tempYFinal);
            this.actorList.add(point);
    }
}
