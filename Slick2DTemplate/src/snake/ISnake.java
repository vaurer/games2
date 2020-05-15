package snake;

import org.newdawn.slick.geom.Shape;

public interface ISnake extends IActor{
    public Shape getCollisionShape();
}
