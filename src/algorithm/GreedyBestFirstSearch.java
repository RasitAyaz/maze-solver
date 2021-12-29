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
                    if (frontier.size() > maxFrontierSize) {
                        maxFrontierSize = frontier.size();
                    }
                }
            }
        }

        return false;
    }

    private Tile removeMinHeuristicFrontier() {

        int indexOfMinElement = 0;
        double minHeuristic = Double.MAX_VALUE;

        for (int i = 0; i < frontier.size(); i++) {
            if (frontier.get(i).getHeuristic() < minHeuristic) {
                indexOfMinElement = i;
                minHeuristic = frontier.get(i).getHeuristic();
            }
        }
        return frontier.remove(indexOfMinElement);
    }

}
