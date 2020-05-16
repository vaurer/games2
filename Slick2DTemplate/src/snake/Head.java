package snake;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Head implements IActor, ISnake {


    private float x, y;
    private List<Point> points;
    private List<Body> parts;
    private Shape collisionShape;
    private DIRECTION direction;
    private int timer;

    public Head() {
        this.x = 0;
        this.y = 0;
        this.collisionShape = new Rectangle(0, 0, 10, 10);
        this.points = new ArrayList<Point>();
        this.parts = new ArrayList<Body>();
        this.direction = DIRECTION.WAIT;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillOval(this.x, this.y, 20, 20);
        for (int i = 0; i < parts.size(); i++) {
            graphics.fill(parts.get(i).getCollisionShape());
            graphics.draw(parts.get(i).getCollisionShape());
        }
        graphics.draw(this.collisionShape);
        graphics.setColor(Color.magenta);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.direction = DIRECTION.UP;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.direction = DIRECTION.DOWN;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.direction = DIRECTION.LEFT;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.direction = DIRECTION.RIGHT;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
            this.direction = DIRECTION.WAIT;
        }

        this.collisionShape.setCenterX(this.x + 10);
        this.collisionShape.setCenterY(this.y + 10);

        this.timer += delta;
        int temp = 500;
        if (this.timer > temp) {
            timer = 0;
            move();
            if (hasEatFood()) {
                removeCollisions();
                addBodyPart();
            }
        }
        setFirstBodyPosition();
    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void addPointToTheList(Point point) {
        this.points.add(point);
        System.out.println("added to " + this.points.add(point));
    }

    public void move() {
        switch (this.direction) {
            case UP:
                this.y -= 20;
                break;
            case DOWN:
                this.y += 20;
                break;
            case LEFT:
                this.x -= 20;
                break;
            case RIGHT:
                this.x += 20;
                break;
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public List<Point> getPoints() {
        return points;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    private boolean hasEatFood() {
        boolean hasEatFood = false;
        for (Point point : points) {
            if (point.getCollisionShape().intersects(this.collisionShape)) {
                hasEatFood = true;
                System.out.println("The snake eat something");
                System.out.println("added");
            }
        }
        return hasEatFood;
    }

    private void removeCollisions() {
        for (int i = 0; i < points.size(); i++) {
            points.remove(i);
        }
    }

    private void addBodyPart() {
        float tempX = 20;
        float tempY = 20;
        DIRECTION directionTemp = this.direction;
        switch (this.direction) {
            case UP:
                tempY = y + 20;
                tempX = x;
                directionTemp = this.direction;
                break;
            case DOWN:
                tempY = y - 20;
                tempX = x;
                directionTemp = this.direction;
                break;
            case LEFT:
                tempX = x + 20;
                tempY = y;
                directionTemp = this.direction;
                break;
            case RIGHT:
                tempX = x - 20;
                tempY = y;
                directionTemp = this.direction;
                ;
                break;
        }
        Body body = new Body(tempX, tempY, directionTemp);
        this.parts.add(body);
        for (int i = 0; i < parts.size(); i++) {
            System.out.println(parts.get(i));
        }
    }

    private void setFirstBodyPosition() {
        if (parts.size() >= 1) {
            switch (this.direction) {
                case UP:
                    parts.get(0).setX(this.x);
                    parts.get(0).setY(this.y + 20);
                    parts.get(0).setDirection(this.direction);
                    System.out.println("UP");
                    break;
                case DOWN:
                    parts.get(0).setX(this.x);
                    parts.get(0).setY(this.y - 20);
                    parts.get(0).setDirection(this.direction);
                    System.out.println("D");
                    break;
                case LEFT:
                    parts.get(0).setX(this.x + 20);
                    parts.get(0).setY(this.y);
                    parts.get(0).setDirection(this.direction);
                    System.out.println("L");
                    break;
                case RIGHT:
                    parts.get(0).setX(this.x - 20);
                    parts.get(0).setY(this.y);
                    parts.get(0).setDirection(this.direction);
                    System.out.println("R");
                    break;

            }
        }
    }
}