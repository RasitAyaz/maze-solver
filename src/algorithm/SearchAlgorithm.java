package src.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Coordinate;
import src.Maze;
import src.Tile;

public abstract class SearchAlgorithm {
    protected List<Coordinate> solutionCoordinates;
    protected List<Tile> exploredTiles;
    protected List<Coordinate> expandedCoordinates;
    protected double solutionCost;
    protected Maze maze;
    protected List<Tile> frontier;
    protected Tile lastTile;

    public abstract boolean search();

    protected void findSolution() {
        Tile temp = lastTile;
        solutionCost = lastTile.getCost();

        while (temp != null) {
            solutionCoordinates.add(temp.getRealCoordinates());
            temp = temp.getParent();
        }

        Collections.reverse(solutionCoordinates);
    }

    protected List<Tile> getExpandableTiles(Tile currentTile) {

        List<Tile> expandableTiles = new ArrayList<>();

        int x = currentTile.getX();
        int y = currentTile.getY();

        Tile left = new Tile(x, y + 1);
        Tile up = new Tile(x + 1, y);
        Tile right = new Tile(x, y - 1);
        Tile down = new Tile(x - 1, y);

        if (canMoveTo(right)) {
            expandableTiles
                    .add(new Tile(x, y + 2, currentTile.getCost() + getCost(x, y + 2), getManhattanDistance(x, y + 2)));
        }
        if (canMoveTo(up)) {
            expandableTiles
                    .add(new Tile(x - 2, y, currentTile.getCost() + getCost(x - 2, y), getManhattanDistance(x - 2, y)));
        }
        if (canMoveTo(left)) {
            expandableTiles
                    .add(new Tile(x, y - 2, currentTile.getCost() + getCost(x, y - 2), getManhattanDistance(x, y - 2)));
        }
        if (canMoveTo(down)) {
            expandableTiles
                    .add(new Tile(x + 2, y, currentTile.getCost() + getCost(x + 2, y), getManhattanDistance(x + 2, y)));
        }

        return expandableTiles;
    }

    private boolean canMoveTo(Tile currentTile) {
        return maze.get(currentTile) != '#';
    }

    private int getCost(int x, int y) {
        if (maze.get(x, y) == 'T')
            return 10;
        return 1;
    }

    private double getManhattanDistance(int x, int y) {
        int realX = (x + 1) / 2;
        int realY = (y + 1) / 2;

        List<Double> heuristicResults = new ArrayList<>();

        for (Tile tile : maze.getGoalTiles()) {
            heuristicResults.add((double) Math.abs(realX - tile.getX() + Math.abs(realY - tile.getY())));
        }
        return Collections.min(heuristicResults);
    }
}
