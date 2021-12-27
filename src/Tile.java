package src;

public class Tile {
    private int x;
    private int y;
    private double cost;
    private Tile parent;
    private double heuristic;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, double cost) {
        this(x, y);
        this.cost = cost;
    }

    public Tile(int x, int y, double cost, double heuristic) {
        this(x, y, cost);
        this.heuristic = heuristic;
    }

    public Tile(int x, int y, double cost, double heuristic, Tile parent) {
        this(x, y, cost, heuristic);
        this.parent = parent;
    }

    public double getAStarHeuristic() {
        return cost + heuristic;
    }

    public Coordinate getRealCoordinates() {
        return new Coordinate((x + 1) / 2, (y + 1) / 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tile getParent() {
        return parent;
    }

    public double getCost() {
        return cost;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tile) {
            Tile other = (Tile) obj;
            return x == other.x && y == other.y;
        }
        return super.equals(obj);
    }

}
