package src;

public class Tile {
    private int x;
    private int y;
    private double cost;
    private Tile parent;
    private double heuristic;

    public Tile(int x, int y, double cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public Tile(int x, int y, double cost, Tile parent) {
        this(x, y, cost);
        this.parent = parent;
    }

    public Tile(int x, int y, double cost, Tile parent, double heuristic) {
        this(x, y, cost, parent);
        this.heuristic = heuristic;
    }

    public double getAStarHeuristic() {
        return cost + heuristic;
    }

    public Coordinate getRealCoordinates() {
        return new Coordinate((x + 1) / 2, (y + 1) / 2);
    }

    public Tile getParent() {
        return parent;
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
