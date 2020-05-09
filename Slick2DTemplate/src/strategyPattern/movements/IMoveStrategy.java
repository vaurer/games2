package strategyPattern.movements;

public interface IMoveStrategy {
    public float getX();
    public float getY();
    public void update (int delta);
}
