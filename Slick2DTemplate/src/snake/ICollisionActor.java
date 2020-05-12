package snake;

import org.newdawn.slick.geom.Shape;

public interface ICollisionActor extends IActor{
    public Shape getCollisionShape();
}

