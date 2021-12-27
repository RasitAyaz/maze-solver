package src;

import java.util.List;

public abstract class SearchAlgorithm {
    private List<Coordinate> solutionCoordinates;
    private List<Tile> exploredTiles;
    private double solutionCost;
    private Maze maze;
    private List<Tile> frontier;

    public abstract void search();
}
