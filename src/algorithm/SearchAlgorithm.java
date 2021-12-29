package src.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import src.Coordinate;
import src.Maze;
import src.Tile;

public abstract class SearchAlgorithm {
    protected List<Coordinate> solutionCoordinates;
    protected List<Tile> exploredTiles;
    protected List<Coordinate> expandedCoordinates;
    protected double solutionCost;
    protected int maxFrontierSize;
    protected int maxExploredSetSize;
    protected Maze maze;
    protected List<Tile> frontier;
    protected Tile lastTile;

    public SearchAlgorithm(Maze maze) {
        this.maze = maze;
        solutionCoordinates = new ArrayList<>();
        exploredTiles = new ArrayList<>();
        expandedCoordinates = new ArrayList<>();
        frontier = new ArrayList<>();

        Tile startTile = maze.getStartTile();
        startTile.setHeuristic(getManhattanDistance(startTile));
        frontier.add(startTile);
    }

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

        Tile right = new Tile(x, y + 1);
        Tile down = new Tile(x + 1, y);
        Tile left = new Tile(x, y - 1);
        Tile up = new Tile(x - 1, y);

        if (canMoveTo(right)) {
            tryToMove(expandableTiles, currentTile, x, y + 2);
        }
        if (canMoveTo(down)) {
            tryToMove(expandableTiles, currentTile, x + 2, y);
        }
        if (canMoveTo(left)) {
            tryToMove(expandableTiles, currentTile, x, y - 2);
        }
        if (canMoveTo(up)) {
            tryToMove(expandableTiles, currentTile, x - 2, y);
        }

        return expandableTiles;
    }

    private void tryToMove(List<Tile> tiles, Tile parentTile, int x, int y) {
        try {
            Tile tile = new Tile(x, y, parentTile.getCost() + getCost(x, y), getManhattanDistance(x, y), parentTile);
            tiles.add(tile);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    private boolean canMoveTo(Tile tile) {
        return maze.get(tile) != '#';
    }

    private int getCost(int x, int y) {
        if (maze.get(x, y) == 'T')
            return 10;
        return 1;
    }

    private double getManhattanDistance(Tile tile) {
        return getManhattanDistance(tile.getX(), tile.getY());
    }

    private double getManhattanDistance(int x, int y) {
        x = (x + 1) / 2;
        y = (y + 1) / 2;

        List<Double> heuristicResults = new ArrayList<>();

        for (Tile tile : maze.getGoalTiles()) {
            Coordinate realCoordinates = tile.getRealCoordinates();
            heuristicResults.add((double) Math.abs(x - realCoordinates.getX()) + Math.abs(y - realCoordinates.getY()));
        }
        return Collections.min(heuristicResults);
    }

    public void printSolutions() {
        System.out.println("\n\t  RESULT\n\t----------");
        System.out.println("\nThe cost of the solution: " + (int) solutionCost);
        System.out.println("\nThe number expanded nodes: " + expandedCoordinates.size());
        System.out.println("\nThe maximum size of the frontier: " + maxFrontierSize);
        System.out.println("\nThe maximum size of the explored set: " + maxExploredSetSize);
        printCoordinateList("\nSolution Path", solutionCoordinates, " - ");
        System.out.println("\nVisualized Solution:\n");

        System.out.print("      ");
        for (int y = 1; y < maze.getSize() / 2 + 1; y++) {
            if (y < 10)
                System.out.print(" ");
            System.out.print(y + "  ");
        }

        System.out.println("\n   ");

        for (int i = 0; i < maze.getSize(); i++) {
            int x = (i + 1) / 2;
            if (i % 2 == 1) {
                if (x < 10)
                    System.out.print(" ");
                System.out.print(x + "   ");
            } else {
                System.out.print("     ");
            }
            for (int j = 0; j < maze.getSize(); j++) {
                char ch = maze.get(i, j);
                if (ch == ' ' && isOnPath(i, j))
                    System.out.print(". ");
                else
                    System.out.print(maze.get(i, j) + " ");
            }
            System.out.println();
        }
    }

    private boolean isOnPath(int i, int j) {
        int x = (i + 1) / 2;
        int y = (j + 1) / 2;

        if (i % 2 == 1 && j % 2 == 1) {
            return solutionCoordinates.contains(new Coordinate(x, y));
        } else if (i % 2 == 1 && j % 2 == 0) {
            return solutionCoordinates.contains(new Coordinate(x, y))
                    && solutionCoordinates.contains(new Coordinate(x, y + 1));
        } else if (i % 2 == 0 && j % 2 == 1) {
            return solutionCoordinates.contains(new Coordinate(x, y))
                    && solutionCoordinates.contains(new Coordinate(x + 1, y));
        }

        return false;
    }

    private void printCoordinateList(String title, List<Coordinate> list, String delimiter) {
        System.out.println(title + ":");
        String listStr = list.stream()
                .map(Coordinate::toString)
                .collect(Collectors.joining(delimiter));

        System.out.println(listStr + "\n");
    }
}
