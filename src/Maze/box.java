package src.maze;

public class Box {
    private Box parent;
    private int x;
    private int y;
    private int cost;
    private double heuristic;

    public Box(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public Box(int x, int y, Box parent, int cost) {
        this(x, y, cost);
        this.parent = parent;
    }

    public Box(int x, int y, int cost, Box parent, double heuristic) {
        this(x, y, parent, cost);
        this.heuristic = heuristic;
    }

    public double getAStarHeuristic() {
        return cost + heuristic;
    }

    
}
