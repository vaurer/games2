package at.va.fightInTheSky;

import at.va.fightInTheSky.actors.Actor;
import at.va.fightInTheSky.actors.CollisionActor;
import at.va.fightInTheSky.actors.EnemyCollisionActor;
import at.va.fightInTheSky.actors.Weather;
import at.va.fightInTheSky.flyingObjects.*;
import at.va.fightInTheSky.graphics.ScoreDisplay;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sky extends BasicGame {
    private JetPlayer jetPlayer;
    private JetEnemy jetEnemy;
    private List<Actor> actors;
    private List<EnemyCollisionActor> enemyCollisionActors;
    private List<CollisionActor> collisionActors;
    private Cloud cloud;
    private List<Weather> weathers;
    private ScoreDisplay scoreDisplay;
    private double counter = 0;
    private Rocket rocket;
    private UFO ufo;

    public Sky(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.scoreDisplay = new ScoreDisplay();
        gameContainer.getGraphics().setBackground(new Color(0.4f, 0.5f, 0.9f));
        this.actors = new ArrayList<>();
        this.collisionActors = new ArrayList<>();
        this.enemyCollisionActors = new ArrayList<>();
        this.weathers = new ArrayList<>();

        generatePlayer();
        generateEnemy(3);
        generateClouds(60);
        generateRocket(8);
        generateUfo();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (jetPlayer.isGameNotOver()) {
            for (CollisionActor collisionActor : collisionActors) {
                try {
                    collisionActor.update(gameContainer, delta);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (EnemyCollisionActor enemyCollisionActor : enemyCollisionActors) {
                try {
                    enemyCollisionActor.update(gameContainer, delta);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (Weather weather : weathers) {
                try {
                    weather.update(gameContainer, delta);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deleteIntersections();
            scoreDisplay.setScore(counter);
            scoreDisplay.setLives(jetPlayer.getLives());
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if (jetPlayer.isGameNotOver()) {
            for (CollisionActor collisionActor : collisionActors) {
                collisionActor.render(graphics);
            }
            for (EnemyCollisionActor enemyCollisionActor : enemyCollisionActors) {
                enemyCollisionActor.render(graphics);
            }
            for (Weather weather : weathers) {
                weather.render(graphics);
            }
        }
        scoreDisplay.render(graphics);
        if (!jetPlayer.isGameNotOver()) {
            for (int i = 0; i < enemyCollisionActors.size(); i++) {
                enemyCollisionActors.remove(i);
            }
            for (int i = 0; i < collisionActors.size(); i++) {
                collisionActors.remove(i);
            }
            gameContainer.getGraphics().setBackground(Color.magenta);
            scoreDisplay.renderGameOver(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        if (key == Input.KEY_SPACE) {
            System.out.println("fire");
            Bullet bullet1 = new Bullet(this.jetPlayer.getX() + 30, this.jetPlayer.getY());
            Bullet bullet2 = new Bullet(this.jetPlayer.getX() + 70, this.jetPlayer.getY());
            this.enemyCollisionActors.add(bullet1);
            this.enemyCollisionActors.add(bullet2);
            for (CollisionActor collisionActor : collisionActors) {
                this.jetEnemy.addEnemyCollisionPartner(bullet1);
                this.jetEnemy.addEnemyCollisionPartner(bullet2);
            }
        }
    }

    public void generateEnemy(Integer number) throws SlickException {
        for (int i = 0; i < number; i++) {
            JetEnemy jetEnemy = new JetEnemy();
            this.jetEnemy = jetEnemy;
            this.jetPlayer.addCollisionPartners(jetEnemy);
            this.actors.add(jetEnemy);
            this.collisionActors.add(jetEnemy);
        }
    }

    public void generatePlayer() throws SlickException {
        JetPlayer jetPlayer = new JetPlayer();
        this.jetPlayer = jetPlayer;
        this.collisionActors.add(jetPlayer);
    }

    public void generateClouds(Integer number) throws SlickException {
        for (int i = 0; i < number; i++) {
            Cloud cloud = new Cloud();
            this.cloud = cloud;
            this.weathers.add(cloud);
        }
    }

    public static void main(String[] args) throws SlickException {
        try {
            AppGameContainer appGameContainer = new AppGameContainer(new Sky("Sky"));
            appGameContainer.setDisplayMode(1920, 1080, false);
            appGameContainer.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void deleteIntersections() throws SlickException {
        for (int i = 1; i < collisionActors.size(); i++) {
            for (int j = 1; j < enemyCollisionActors.size(); j++) {
                try {
                    if (collisionActors.get(i).getCollisionShape().intersects(enemyCollisionActors.get(j).getCollisionShape())) {
                        System.out.println("remove: " + collisionActors.get(i));
                        collisionActors.remove(i);
                        System.out.println("remove: " + enemyCollisionActors.get(j));
                        enemyCollisionActors.remove(j);
                        counter++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void removeOutOfWindow(){
        for (int i = 0; i <this.collisionActors.size() ; i++) {
            if (this.collisionActors.get(i).getCollisionShape().getY()< -500){
                this.collisionActors.remove(i);
            }
        }
    }
    public void generateRocket(Integer number) throws SlickException {
        for (int i = 0; i <number ; i++) {
            Rocket rocket = new Rocket();
            this.collisionActors.add(rocket);
            this.jetPlayer.addCollisionPartners(rocket);
            this.actors.add(rocket);
        }
    }
    public void generateUfo() throws SlickException {
           UFO ufo = new UFO();
            this.collisionActors.add(ufo);
            this.jetPlayer.addCollisionPartners(ufo);
            this.actors.add(ufo);

    }
}
