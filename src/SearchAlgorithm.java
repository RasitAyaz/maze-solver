package src;

import java.util.List;

public abstract class SearchAlgorithm {
    protected List<Coordinate> solutionCoordinates;
    protected List<Tile> exploredTiles;
    protected double solutionCost;
    protected Maze maze;
    protected List<Tile> frontier;

    public abstract void search();
}
