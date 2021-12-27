package src.algorithm;

import java.util.List;

import src.Coordinate;
import src.Maze;
import src.Tile;

public abstract class Search {
    protected List<Coordinate> solutionCoordinates;
    protected List<Tile> exploredTiles;
    protected double solutionCost;
    protected Maze maze;
    protected List<Tile> frontier;

    public abstract void search();
}
