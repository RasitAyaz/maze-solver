package src.algorithm;

import java.util.List;

import src.Maze;
import src.Tile;

public class GreedyBestFirstSearch extends SearchAlgorithm {

    public GreedyBestFirstSearch(Maze maze) {
        super(maze);
    }

    @Override
    public boolean search() {

        while (!frontier.isEmpty()) {
            Tile currentTile = removeMinHeuristicFrontier();

            exploredTiles.add(currentTile);
            expandedCoordinates.add(currentTile.getRealCoordinates());

            if (maze.get(currentTile) == 'G') {
                lastTile = currentTile;
                findSolution();
                return true;
            }

            List<Tile> expandableTiles = getExpandableTiles(currentTile);

            for (Tile tile : expandableTiles) {
                if (!frontier.contains(tile) && !exploredTiles.contains(tile)) {
                    frontier.add(tile);
                }
            }

        }
        return false;

    }

    private Tile removeMinHeuristicFrontier() {

        int indexOfMinElement = 0;
        double minCost = Double.MAX_VALUE;

        for (int i = 0; i < frontier.size(); i++) {
            if (frontier.get(i).getHeuristic() < minCost) {
                indexOfMinElement = i;
                minCost = frontier.get(i).getHeuristic();
            }
        }
        return frontier.remove(indexOfMinElement);
    }

}
