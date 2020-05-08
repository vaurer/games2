package at.va.fightInTheSky.actors;

import org.newdawn.slick.geom.Shape;

public interface EnemyCollisionActor extends Actor{
    public Shape getCollisionShape();
}
