package snake;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeBoard extends BasicGame {
    private List<ICollisionActor> iCollisionActors;
    private List<Body> snakeParts;
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
        this.snakeParts = new ArrayList<Body>();
        createPlayer();
        createPoint();
        gameContainer.getGraphics().setBackground(new Color(0.4f, 0.5f, 0.9f));
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        try {
            head.update(gameContainer, delta);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (ICollisionActor iCollisionActor : iCollisionActors) {
            try {
                iCollisionActor.update(gameContainer, delta);
                for (int i = 0; i < iCollisionActors.size(); i++) {
                    if (iCollisionActors.get(i).getCollisionShape().intersects(head.getCollisionShape())) {
                        iCollisionActors.remove(i);
                        createPoint();
                        addBodyParts();
                        addFirstBodyPart();

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setPositionForFirstBodyPart();
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (ICollisionActor iCollisionActor : iCollisionActors) {
            iCollisionActor.render(graphics);
        }
        for (Body body : snakeParts) {
            body.render(graphics);
        }
        head.render(graphics);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer appGameContainer = new AppGameContainer(new SnakeBoard("Snake"));
        appGameContainer.setDisplayMode(600, 600, false);
        appGameContainer.start();
    }

    public void createPlayer() {
        Head head = new Head();
        this.head = head;
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

    private void addFirstBodyPart() {
        if (snakeParts.size() == 0) {
            float tempX = 20;
            float tempY = 20;
            DIRECTION directionTemp = this.head.getDirection();
            switch (this.head.getDirection()) {
                case UP:
                    tempY = this.head.getX() + 20;
                    tempX = this.head.getY();
                    break;
                case DOWN:
                    tempY = this.head.getY() - 20;
                    tempX = this.head.getX();
                    break;
                case LEFT:
                    tempX = this.head.getX() + 20;
                    tempY = this.head.getY();
                    break;
                case RIGHT:
                    tempX = this.head.getX() - 20;
                    tempY = this.head.getY();
                    break;
            }
            Body body = new Body(tempX, tempY, directionTemp);
            this.snakeParts.add(body);
            for (int i = 0; i < snakeParts.size(); i++) {
                System.out.println(snakeParts.get(i));
            }
        }
    }

    private void addBodyParts() {
        if (this.snakeParts.size() > 0) {
            float tempX = 20;
            float tempY = 20;
            DIRECTION directionTemp = snakeParts.get(snakeParts.size()).getDirection();
            switch (snakeParts.get(snakeParts.size()).getDirection()) {
                case UP:
                    tempY = snakeParts.get(snakeParts.size()).getY() + 20;
                    tempX = snakeParts.get(snakeParts.size()).getX();
                    break;
                case DOWN:
                    tempY = snakeParts.get(snakeParts.size()).getY() - 20;
                    tempX = snakeParts.get(snakeParts.size()).getX();
                    break;
                case LEFT:
                    tempX = snakeParts.get(snakeParts.size()).getX() + 20;
                    tempY = snakeParts.get(snakeParts.size()).getY();
                    break;
                case RIGHT:
                    tempX = snakeParts.get(snakeParts.size()).getX() - 20;
                    tempY = snakeParts.get(snakeParts.size()).getY();
                    break;
            }
            Body body = new Body(tempX, tempY, directionTemp);
            this.snakeParts.add(body);
            for (int j = 0; j < snakeParts.size(); j++) {
                System.out.println(snakeParts.get(j));
            }
        }

    }


    private void setPositionForFirstBodyPart() {
        if (snakeParts.size() >= 1) {
            switch (this.head.getDirection()) {
                case UP:
                    snakeParts.get(0).setX(this.head.getX());
                    snakeParts.get(0).setY(this.head.getY() + 20);
                    snakeParts.get(0).setDirection(this.head.getDirection());
                    System.out.println("UP");
                    break;
                case DOWN:
                    snakeParts.get(0).setX(this.head.getX());
                    snakeParts.get(0).setY(this.head.getY() - 20);
                    snakeParts.get(0).setDirection(this.head.getDirection());
                    System.out.println("D");
                    break;
                case LEFT:
                    snakeParts.get(0).setX(this.head.getX() + 20);
                    snakeParts.get(0).setY(this.head.getY());
                    snakeParts.get(0).setDirection(this.head.getDirection());
                    System.out.println("L");
                    break;
                case RIGHT:
                    snakeParts.get(0).setX(this.head.getX() - 20);
                    snakeParts.get(0).setY(this.head.getY());
                    snakeParts.get(0).setDirection(this.head.getDirection());
                    System.out.println("R");
                    break;
            }
        }
    }

    private void setPositionForBodyParts() {
        if (snakeParts.size() >= 2) {
            for (int i = snakeParts.size(); i >= 1; i--) {
                switch (this.snakeParts.get(i - 1).getDirection()) {
                    case UP:
                        snakeParts.get(i).setX(this.snakeParts.get(i - 1).getX());
                        snakeParts.get(i).setY(this.snakeParts.get(i - 1).getY() + 20);
                        snakeParts.get(i).setDirection(this.snakeParts.get(i - 1).getDirection());
                        break;
                    case DOWN:
                        snakeParts.get(i).setX(this.snakeParts.get(i - 1).getX());
                        snakeParts.get(i).setY(this.snakeParts.get(i - 1).getY() - 20);
                        snakeParts.get(i).setDirection(this.snakeParts.get(i - 1).getDirection());
                        break;
                    case LEFT:
                        snakeParts.get(i).setX(this.snakeParts.get(i - 1).getX() + 20);
                        snakeParts.get(i).setY(this.snakeParts.get(i - 1).getY());
                        snakeParts.get(i).setDirection(this.snakeParts.get(i - 1).getDirection());
                        break;
                    case RIGHT:
                        snakeParts.get(i).setX(this.snakeParts.get(i - 1).getX() - 20);
                        snakeParts.get(i).setY(this.snakeParts.get(i - 1).getY());
                        snakeParts.get(i).setDirection(this.snakeParts.get(i - 1).getDirection());
                        break;
                }
            }
        }
    }
}

