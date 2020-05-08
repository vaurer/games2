package at.va.fightInTheSky.graphics;

import at.va.fightInTheSky.actors.Weather;
import at.va.fightInTheSky.flyingObjects.JetPlayer;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class ScoreDisplay implements Weather {
    private int lives;
    private double score;
    private String gameOver = "GAME OVER";
    private AngelCodeFont font;

    JetPlayer jetPlayer = new JetPlayer();

    public ScoreDisplay() throws SlickException {
        this.lives = 3;
        this.score = 0;
        this.font = new AngelCodeFont("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\at\\va\\fightInTheSky\\files\\hiero.fnt", "C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\at\\va\\fightInTheSky\\files\\hiero.png");
    }
    @Override
    public void render(Graphics graphics) throws SlickException {
        font.drawString(50, 50, getLives());
        font.drawString(50, 100, getScore());
    }

    public void renderGameOver(Graphics graphics){
        font.drawString(850, 540, gameOver);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException, InterruptedException {

    }
    public String getLives() {
        return "LIVES: " + Integer.toString(lives);
    }

    public String getScore() {
        return "SCORE: " + Double.toString(score);
    }

    public String getGameOver() {
        return gameOver;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
