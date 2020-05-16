package snake;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeBoard extends BasicGame {
    private List<ICollisionActor> iCollisionActors;
    private List<IActor> iActors;
    private List<Body> parts;
    private List<ISnake> snakeParts;
    private Head head;


    public void setPoint(Point point) {
        this.point = point;
    }

    private Point point;

    public SnakeBoard(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.iCollisionActors = new ArrayList<ICollisionActor>();
        this.iActors = new ArrayList<IActor>();
        this.parts = new ArrayList<Body>();
        this.snakeParts = new ArrayList<ISnake>();
        createPlayer();
        createPoint();
        gameContainer.getGraphics().setBackground(new Color(0.4f, 0.5f, 0.9f));
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (ICollisionActor iCollisionActor : iCollisionActors) {
            try {
                iCollisionActor.update(gameContainer, delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Body body : parts) {
            try {
                body.update(gameContainer, delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (IActor iActor : iActors) {
            try {
                iActor.update(gameContainer, delta);
                for (int i = 0; i < iCollisionActors.size(); i++) {
                    if (iCollisionActors.get(i).getCollisionShape().intersects(iActor.getCollisionShape())) {
                        iCollisionActors.remove(i);
                        createPoint();
                        //addBodyPart();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (ISnake iSnake : snakeParts) {
            try {
                iSnake.update(gameContainer, delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (ICollisionActor iCollisionActor : iCollisionActors) {
            iCollisionActor.render(graphics);
        }
        for (IActor iActor : iActors) {
            iActor.render(graphics);
        }
        for (Body body : parts) {
            body.render(graphics);
        }
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer appGameContainer = new AppGameContainer(new SnakeBoard("Snake"));
        appGameContainer.setDisplayMode(600, 600, false);
        appGameContainer.start();
    }

    public void createPlayer() {
        Head head = new Head();
        this.head = head;
        this.iActors.add(head);
        this.snakeParts.add(head);
    }

    public void createPoint() {
        for (int i = 0; i < 1; i++) {
            Random random = new Random();
            int tempX = random.nextInt(30);
            int tempY = random.nextInt(30);
            int tempXFinal = tempX * 20;
            int tempYFinal = tempY * 20;
            Point point = new Point(tempXFinal, tempYFinal);
            this.iCollisionActors.add(point);
            this.head.addPointToTheList(point);
        }
    }
}

