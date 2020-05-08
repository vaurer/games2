package at.va.fightInTheSky.actors;

import at.va.fightInTheSky.flyingObjects.Bullet;
import org.newdawn.slick.geom.Shape;

public interface CollisionActor extends Actor {
    public Shape getCollisionShape();

    public void addEnemyCollisionPartner(Bullet bullet);
}
