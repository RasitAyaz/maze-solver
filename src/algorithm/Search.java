package src.algorithm;

import java.util.Collections;
import java.util.List;

import src.Coordinate;
import src.Maze;
import src.Tile;

public abstract class Search {
    protected List<Coordinate> solutionCoordinates;
    protected List<Tile> exploredTiles;
    protected List<Coordinate> expandedCoordinates;
    protected double solutionCost;
    protected Maze maze;
    protected List<Tile> frontier;
    protected Tile lastTile;

    public abstract void search();

    protected void findSolution() {
        Tile temp = lastTile;
        solutionCost = lastTile.getCost();

        while (temp != null) {
            solutionCoordinates.add(temp.getRealCoordinates());
            temp = temp.getParent();
        }

        Collections.reverse(solutionCoordinates);
    }

    protected List<Tile> getExpandableTiles() {
        return null;
    }
}
