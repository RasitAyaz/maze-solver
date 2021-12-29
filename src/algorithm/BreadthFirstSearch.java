package src.algorithm;

import java.util.List;

import src.Maze;
import src.Tile;

public class BreadthFirstSearch extends SearchAlgorithm {
    public BreadthFirstSearch(Maze maze) {
        super(maze);
    }

    @Override
    public boolean search() {
        while (!frontier.isEmpty()) {
            Tile currentTile = frontier.remove(0);

            exploredTiles.add(currentTile);
            expandedCoordinates.add(currentTile.getRealCoordinates());
            if (exploredTiles.size() > maxSizeExploredSet) {
                maxSizeExploredSet = frontier.size();
            }

            if (maze.get(currentTile) == 'G') {
                lastTile = currentTile;
                findSolution();
                return true;
            }

            List<Tile> expandableTiles = getExpandableTiles(currentTile);

            for (Tile tile : expandableTiles) {
                if (!frontier.contains(tile) && !exploredTiles.contains(tile)) {
                    frontier.add(tile);
                    if (frontier.size() > maxSizeFrontier) {
                        maxSizeFrontier = frontier.size();
                    }
                }
            }
        }
        return false;
    }
}
