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

//    @Override
//    public void keyPressed(int key, char c) {
//        super.keyPressed(key, c);
//        if ()
//    }

    public void createPlayer() {
        Player player = new Player();
        this.actorList.add(player);
    }

    public void createPoint(){
        Random random = new Random();
        int tempX = random.nextInt(594);
        int tempY = random.nextInt(594);
        Point point = new Point(tempX, tempY);
        this.actorList.add(point);
//        for (int i = 0; i <this.width ; i++) {
//            for (int j = 0; j <this.high ; j++) {
//                if (t)
//            }
//        }
    }
}
