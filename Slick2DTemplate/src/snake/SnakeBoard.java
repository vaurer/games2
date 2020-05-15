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
    //private Body parts;

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
        moveSnakeParts();
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
                        addBodyPart();
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
//        for (IActor iActor : iActors) {
//            iActor.render(graphics);
//        }
//        for (Body body : parts) {
//            body.render(graphics);
//        }
        for (ISnake iSnake : snakeParts) {
            iSnake.render(graphics);
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

    private void addBodyPart() {
        float x = 0;
        float y = 0;
        DIRECTION direction = DIRECTION.WAIT;
        switch (this.head.getDirection()) {
            case UP:
                x = this.head.getX();
                y = this.head.getY() + 20;
                direction = this.head.getDirection();
                break;
            case DOWN:
                x = this.head.getX();
                y = this.head.getY() - 20;
                direction = this.head.getDirection();
                break;
            case LEFT:
                x = this.head.getX() + 20;
                y = this.head.getY();
                direction = this.head.getDirection();
                break;
            case RIGHT:
                x = this.head.getX() - 20;
                y = this.head.getY();
                direction = this.head.getDirection();
                break;
        }

        Body body = new Body(x, y, direction);
        this.parts.add(body);
        this.snakeParts.add(body);
        for (int i = 0; i < parts.size(); i++) {
            System.out.println(parts.get(i)); // all body parts

        }
    }

    private void moveSnakeParts() {
        try {
            if (snakeParts.size() > 1) {
                for (int i = snakeParts.size(); i > 1 ; i--) {
                    for (int j = snakeParts.size()-1; j <=0 ; j--) {
                        snakeParts.get(i).getCollisionShape().setLocation(snakeParts.get(j).getCollisionShape().getX(), snakeParts.get(j).getCollisionShape().getY());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
