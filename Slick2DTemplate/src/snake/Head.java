package snake;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Head implements IActor {


    private float x, y;
    private List<Point> points;
    private Shape collisionShape;
    private DIRECTION direction;
    private int timer;
    private List<Body> parts;

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
        graphics.draw(this.collisionShape);
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
            hasEatFood();
            removeCollisions();
        }
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

    private boolean hasEatFood() {

        boolean hasEatFood = false;

        for (Point point : points) {
            if (point.getCollisionShape().intersects(this.collisionShape)) {
                hasEatFood = true;
                System.out.println("The snake eat something");
                addBodyPart();
                System.out.println("added");
            }
        }
        return hasEatFood;
    }
    private void removeCollisions(){
        for (int i = 0; i <points.size() ; i++) {
            points.remove(i);
        }
    }

    private void addBodyPart() {
        Body body = new Body();
        if (this.direction==direction.UP){
            body.setX(this.x);
            body.setY(this.y+20);
        } else if (this.direction==direction.DOWN) {
            body.setX(this.x);
            body.setY(this.y - 20);
        }else if (this.direction==direction.LEFT) {
            body.setX(this.x-20);
            body.setY(this.y);
        }else if (this.direction==direction.RIGHT) {
            body.setX(this.x+20);
            body.setY(this.y);
        }
        this.parts.add(body);
    }
}